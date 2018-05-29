package com.pyramid.rpc.crawler.contentparsers;

import com.pyramid.rpc.crawler.contentparsers.entity.Content;

public interface ContentParser {

	public Content parserUrl(String url);

}
