package com.pyramid.utils.lucene;

import java.io.FileWriter;
import java.util.Arrays;
import java.util.List;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.document.Field.Index;
import org.apache.lucene.document.Field.Store;
import org.apache.lucene.document.Field.TermVector;
import org.apache.lucene.index.IndexReader;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.index.IndexWriterConfig;
import org.apache.lucene.index.IndexWriterConfig.OpenMode;
import org.apache.lucene.queryparser.classic.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.search.vectorhighlight.BaseFragmentsBuilder;
import org.apache.lucene.search.vectorhighlight.FastVectorHighlighter;
import org.apache.lucene.search.vectorhighlight.FieldQuery;
import org.apache.lucene.search.vectorhighlight.FragListBuilder;
import org.apache.lucene.search.vectorhighlight.FragmentsBuilder;
import org.apache.lucene.search.vectorhighlight.ScoreOrderFragmentsBuilder;
import org.apache.lucene.search.vectorhighlight.SimpleFragListBuilder;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.RAMDirectory;
import org.apache.lucene.util.Version;
import org.wltea.analyzer.lucene.IKAnalyzer;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月24日 下午6:33:35<br>
 * @Project: Pyramid-Utils<br>
 * @Package: com.pyramid.utils.lucene<br>
 * @File: HighLighterUtil.java<br>
 * @Description: 对指定查询的字符串添加高亮<br>
 */
public class HighLighterUtil {

	private static Directory dir = new RAMDirectory();
	private static Analyzer analyzer = new IKAnalyzer();
	// private static Analyzer analyzer = new
	// StandardAnalyzer(Version.LUCENE_46);

	// 最后生成写入高亮内容的文件
	private static String strHighlightFilePath = "E:/z-tmp/08_solr/highlight.html";

	/**
	 * To make searching indexes
	 * 
	 * @throws Exception
	 */
	public void makeIndex(List<String> docs) throws Exception {
		// 配置IndexWriterConfig
		IndexWriterConfig iwConfig = new IndexWriterConfig(Version.LUCENE_46,
				analyzer);
		iwConfig.setOpenMode(OpenMode.CREATE_OR_APPEND);
		IndexWriter writer = new IndexWriter(dir, iwConfig);
		// IndexWriter writer = new IndexWriter(dir, analyzer, true,
		// MaxFieldLength.UNLIMITED);
		int intField = 0;
		for (String d : docs) {
			Document doc = new Document();
			doc.add(new Field("" + intField, d, Store.YES, Index.ANALYZED,
					TermVector.WITH_POSITIONS_OFFSETS));
			writer.addDocument(doc);
			intField++;
		}
		writer.close();
	}

	/**
	 * To search by indexes
	 * 
	 * @param filename
	 *            生成高亮后的文件
	 * @throws Exception
	 */
	public void searchIndex(String filename, String sthToFind) throws Exception {
		QueryParser parser = new QueryParser(Version.LUCENE_46, "f", analyzer);
		Query query = parser.parse(sthToFind);
		FastVectorHighlighter highlighter = getHighlighter();
		FieldQuery fieldQuery = highlighter.getFieldQuery(query);
		IndexReader ireader = IndexReader.open(dir);
		IndexSearcher searcher = new IndexSearcher(ireader);
		TopDocs docs = searcher.search(query, 10);

		/**
		 * 将结果写到文件中
		 */
		FileWriter writer = new FileWriter(filename); // 亦可：PrintWriter pwriter
														// =
														// new PrintWriter(new
														// File(filename));
		writer.write("<html>");
		writer.write("<body>");
		writer.write("<p>QUERY : " + sthToFind + "</p>");

		int i = 0;
		for (ScoreDoc scoreDoc : docs.scoreDocs) {
			String F = "F" + i;
			String snippet = highlighter.getBestFragment(fieldQuery,
					searcher.getIndexReader(), scoreDoc.doc, F, 100);
			System.out.println("Hits: " + scoreDoc + ", " + scoreDoc.score);
			if (snippet != null) {
				writer.write(scoreDoc.doc + " : " + snippet + "<br/>");
			}
			i++;
		}
		writer.write("</body></html>");
		writer.close();
		// searcher.close();
		System.out.println("Result: it's finished...");
	}

	/**
	 * 获取高亮对象
	 * 
	 * @return
	 */
	public FastVectorHighlighter getHighlighter() {
		FragListBuilder fragListBuilder = new SimpleFragListBuilder();
		FragmentsBuilder fragmentsBuilder = new ScoreOrderFragmentsBuilder(
				BaseFragmentsBuilder.COLORED_PRE_TAGS,
				BaseFragmentsBuilder.COLORED_POST_TAGS);
		return new FastVectorHighlighter(true, true, fragListBuilder,
				fragmentsBuilder);
	}

	/**
	 * Singleton
	 */
	private static HighLighterUtil sample = null;

	private HighLighterUtil() {
	}

	public static HighLighterUtil getInstance() {
		sample = new HighLighterUtil();
		return sample;
	}

	/**
	 * Main Function
	 * 
	 * @param args
	 * @throws Exception
	 */
	public static void main(String[] args) throws Exception {
		//
		String[] docs = { "the quick brown fox jumps over the lazy dog",
				"the quick gold fox jumped over the lazy black dog",
				"the quick fox jumps over the black dog",
				"the black bear go toward to my lazy dog",
				"the red fox jumped over the lazy dark gray dog" };
		String sthToFind = "quick OR fox OR \"lazy dog\"~1"; // PS:~1没有特殊含义

		// Test
		HighLighterUtil sample = HighLighterUtil.getInstance();

		/**
		 * 创建索引
		 */
		sample.makeIndex(Arrays.asList(docs));

		/**
		 * 搜索
		 */
		sample.searchIndex(strHighlightFilePath, sthToFind);
	}

}
