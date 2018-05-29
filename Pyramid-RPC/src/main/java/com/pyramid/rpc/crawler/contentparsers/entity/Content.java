package com.pyramid.rpc.crawler.contentparsers.entity;

public class Content {

	private String title; // 标题

	private String publicDate; // 发布时间

	private String visitedCount; // 访问次数

	private String source; // 来源

	private String author; // 作者

	private String anchor; // 特征词

	private String summary; // 摘要

	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * @return the publicDate
	 */
	public String getPublicDate() {
		return publicDate;
	}

	/**
	 * @return the visitedCount
	 */
	public String getVisitedCount() {
		return visitedCount;
	}

	/**
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * @return the author
	 */
	public String getAuthor() {
		return author;
	}

	/**
	 * @return the anchor
	 */
	public String getAnchor() {
		return anchor;
	}

	/**
	 * @return the summary
	 */
	public String getSummary() {
		return summary;
	}

	/**
	 * @param title
	 *            the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}

	/**
	 * @param publicDate
	 *            the publicDate to set
	 */
	public void setPublicDate(String publicDate) {
		this.publicDate = publicDate;
	}

	/**
	 * @param visitedCount
	 *            the visitedCount to set
	 */
	public void setVisitedCount(String visitedCount) {
		this.visitedCount = visitedCount;
	}

	/**
	 * @param source
	 *            the source to set
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * @param author
	 *            the author to set
	 */
	public void setAuthor(String author) {
		this.author = author;
	}

	/**
	 * @param anchor
	 *            the anchor to set
	 */
	public void setAnchor(String anchor) {
		this.anchor = anchor;
	}

	/**
	 * @param summary
	 *            the summary to set
	 */
	public void setSummary(String summary) {
		this.summary = summary;
	}

}
