package com.pyramid.rpc;

import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import com.google.common.base.Splitter;
import com.pyramid.rpc.crawler.CrawlerDoor;
import com.pyramid.utils.cache.PropertyConfigurer;

/**
 * 
 * @author leiming4
 *
 * @description Provide external restful apis for individual services in the RPC
 *              directory.
 *
 */
@Path("/door/")
@Scope("prototype")
public class RPCDoor {

	private static final Logger LOG = Logger.getLogger(RPCDoor.class);

	private CrawlerDoor crawler;

	public RPCDoor() {
		crawler = CrawlerDoor.getInstance();
		LOG.info(crawler.toString());
	}

	@GET
	@Path("test/{param1}")
	public Response testRPC(@PathParam("param1") String param1) {
		LOG.info("Pyramid: This is a test restful api.");
		LOG.info("Pyramid: access_domains: " + PropertyConfigurer.getContextProperty("access_domains"));
		return Response.ok().build();
	}

	@GET
	@Path("test/01/{param1}")
	public Response testRPC01(@PathParam("param1") String param1) {
		LOG.info("Pyramid: This is the other test restful api.");
		return Response.ok().build();
	}

	@GET
	@Path("crawler/add")
	public Response crawlerAPI(@QueryParam("urls") String strUrls) {
		// String[] urls = strUrls.split(",");
		LOG.info("strUrls: " + strUrls);
		Iterator<String> it = Splitter.on(",").split(strUrls).iterator();
		while (it.hasNext()) {
			crawler.crawlingByThreadPool(new String[] { it.next() });
		}
		LOG.info("Pyramid: This is the crawler api.");
		crawler.getConLinkedQueue().forEach(t_id -> System.out.println(t_id));
		return Response.ok().build();
	}

	@GET
	@Path("crawler/allIDs")
	public Response getAllCrawlerIDs() {
		ConcurrentLinkedQueue conLinkedQueue = crawler.getConLinkedQueue();
		if (conLinkedQueue.isEmpty()) {
			LOG.info("Pyramid: There is no crawler task.");
		} else {
			conLinkedQueue.forEach(t_id -> System.out.println(t_id));
		}
		return Response.ok().build();
	}

	@GET
	@Path("crawler/cancel")
	public Response cancelCrawlers(@QueryParam("ids") String ids) {
		LOG.info("ids: " + ids);
		Iterator<String> it = Splitter.on(",").split(ids).iterator();
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
		if (threadGroup.activeCount() == 0) {
			LOG.info("Pyramid: There is no crawler thread to kill.");
		} else {
			// 根据线程 ID 取消相关的爬虫任务
		}
		LOG.info("Pyramid: This is the crawler api.");
		crawler.getConLinkedQueue().forEach(t_id -> System.out.println(t_id));
		return Response.ok().build();
	}

}
