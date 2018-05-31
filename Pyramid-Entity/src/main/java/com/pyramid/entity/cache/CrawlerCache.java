package com.pyramid.entity.cache;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("crawlerCache")
@Scope("singleton")
public class CrawlerCache {

	// ----- crawler.properties ----- //
	/**
	 * 方法1：<util:properties id="crawler" location=
	 * "classpath*:properties/crawler.properties" />
	 * <p>
	 * @Value("#{crawler['access_domains']}")
	 */
	/**
	 * 方法2：
	 */
	@Value("${access_domains}")
	private String accessDomains;

	public String getAccessDomains() {
		return accessDomains;
	}

	public void setAccessDomains(String accessDomains) {
		this.accessDomains = accessDomains;
	}

	@Override
	public String toString() {
		return "CrawlerCache [accessDomains=" + accessDomains + "]";
	}

}
