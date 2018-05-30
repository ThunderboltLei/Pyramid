package com.pyramid.rpc;

import java.util.Iterator;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import org.apache.log4j.Logger;
import org.springframework.context.annotation.Scope;

import com.google.common.base.Splitter;
import com.pyramid.rpc.crawler.CrawlerDoor;

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

	private Logger LOG = Logger.getLogger(getClass());

	private CrawlerDoor crawler;

	public RPCDoor() {
		// TODO Auto-generated constructor stub
		crawler = CrawlerDoor.getInstance();
		LOG.info(crawler.toString());
	}

	@GET
	@Path("{param1}")
	public Response testRPC(@PathParam("param1") String param1) {
		LOG.info("This is a test restful api.");
		return Response.ok().build();
	}

	@GET
	@Path("01/{param1}")
	public Response testRPC01(@PathParam("param1") String param1) {
		LOG.info("This is the other test restful api.");
		return Response.ok().build();
	}

	@GET
	@Path("crawler")
	public Response crawlerAPI(@QueryParam("urls") String strUrls) {
		// String[] urls = strUrls.split(",");
		LOG.info("strUrls: " + strUrls);
		Iterator<String> it = Splitter.on(",").split(strUrls).iterator();
		while (it.hasNext()) {
			crawler.crawlingByThreadPool(new String[] { it.next() });
		}
		LOG.info("This is the crawler api.");
		crawler.getConLinkedQueue().forEach(t_id -> System.out.println(t_id));
		return Response.ok().build();
	}

}
