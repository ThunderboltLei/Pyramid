package com.pyramid.rpc;

import java.util.Iterator;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.commons.lang.StringUtils;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;

import com.google.common.base.Splitter;
import com.pyramid.rpc.crawler.CrawlerDoor;
import com.pyramid.utils.cache.PropertyConfigurer;
import com.pyramid.utils.thread.ThreadUtils;

import net.sf.json.JSONObject;

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

	@Autowired
	private static CopyOnWriteArrayList<Long> testList = new CopyOnWriteArrayList<Long>();

	public RPCDoor() {
		crawler = CrawlerDoor.getInstance();
		LOG.info(crawler.toString());
	}

	@GET
	@Path("demo/{param1}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response testRPC(@PathParam("param1") String param1) {
		LOG.info("Pyramid: This is a test restful api.");
		LOG.info("Pyramid: access_domains: " + PropertyConfigurer.getContextProperty("access_domains"));

		JSONObject json = new JSONObject();
		json.put("hello", "world");
		return Response.ok(json).build();
	}

	@GET
	@Path("demo/01/{param1}")
	public Response testRPC01(@PathParam("param1") String param1) {
		LOG.info("Pyramid: This is the other test restful api.");
		return Response.ok().build();
	}

	@GET
	@Path("test/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response testRPC01() {
		// LOG.info("Pyramid: This is a test restful api.");
		// LOG.info("Pyramid: access_domains: " +
		// PropertyConfigurer.getContextProperty("access_domains"));

		Thread t = new Thread(new Runnable() {
			@Override
			public void run() {
				while (true) {
					LOG.info("--->>> " + Thread.currentThread().getId() + " - " + UUID.randomUUID().toString());
					try {
						Thread.sleep(2000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		});
		t.start();

		testList.add(t.getId());

		JSONObject json = new JSONObject();
		json.put("Thread_ID", t.getId());
		return Response.ok(json).build();
	}

	@GET
	@Path("test/allids")
	@Produces(MediaType.APPLICATION_JSON)
	public Response testRPC02() {
		// LOG.info("Pyramid: This is a test restful api.");
		// LOG.info("Pyramid: access_domains: " +
		// PropertyConfigurer.getContextProperty("access_domains"));

		JSONObject json = new JSONObject();
		json.put("All_Thread_IDs", testList.toArray());
		return Response.ok(json).build();
	}

	@GET
	@Path("test/cancel")
	@Produces(MediaType.APPLICATION_JSON)
	public Response testRPC03(@QueryParam("ids") String ids) {
		// LOG.info("Pyramid: This is a test restful api.");
		// LOG.info("Pyramid: access_domains: " +
		// PropertyConfigurer.getContextProperty("access_domains"));

		JSONObject json = new JSONObject();

		if (null == ids || StringUtils.isEmpty(ids) == true) {
			json.put("status", 0);
			json.put("message", "Param[ids] is not correct.");
			return Response.ok(json).build();
		}

		Iterator<String> it = Splitter.on(",").split(ids).iterator();
		while (it.hasNext()) {
			Thread _thread_ = ThreadUtils.findThread(Long.parseLong(it.next()));
			while (_thread_.isAlive()) {
				_thread_.stop();
				try {
					_thread_.destroy();
				} catch (Exception | Error e) {
					LOG.info("Pyramid: The crawler thread [" + it.next() + "] has destroied.");
				} finally {
					testList.forEach(x -> System.out.println(x));
					// testList.remove(Long.parseLong(it.next()));
				}
			}
		}
		json.put("status", 1);
		json.put("message", "success");
		return Response.ok(json).build();
	}

	/**
	 * Add a crawler task.<br>
	 * 
	 * @param strUrls
	 *            the addresses of the crawler task.<br>
	 * @return
	 */
	@GET
	@Path("crawler/add")
	@Produces(MediaType.APPLICATION_JSON)
	public Response addCrawlerTask(@QueryParam("urls") String strUrls) {
		// String[] urls = strUrls.split(",");
		LOG.info("strUrls: " + strUrls);
		Iterator<String> it = Splitter.on(",").split(strUrls).iterator();
		while (it.hasNext()) {
			crawler.crawlingByThreadPool(new String[] { it.next() });
		}
		LOG.info("Pyramid: This is the crawler api.");
		CopyOnWriteArrayList list = crawler.getConwArrayList();
		list.forEach(t_id -> System.out.println(t_id));

		JSONObject json = new JSONObject();
		json.put("threadId", list.get(list.size() - 1));
		return Response.ok(json).build();
	}

	/**
	 * Get all crawler task ids.<br>
	 * 
	 * @return All crawler task ids.<br>
	 */
	@GET
	@Path("crawler/allids")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getAllCrawlerIDs() {
		CopyOnWriteArrayList conwArrayList = crawler.getConwArrayList();
		if (conwArrayList.isEmpty()) {
			LOG.info("Pyramid: There is no crawler task.");
		} else {
			conwArrayList.forEach(t_id -> System.out.println(t_id));
		}

		JSONObject json = new JSONObject();
		json.put("All_Thread_IDs", conwArrayList.toArray());
		return Response.ok(json).build();
	}

	/**
	 * Cancel the crawler task according to the thread ID<br>
	 * 
	 * @param ids
	 *            crawler task ids.
	 * @return
	 */
	@GET
	@Path("crawler/cancel")
	@Produces(MediaType.APPLICATION_JSON)
	public Response cancelCrawlerTasks(@QueryParam("ids") String ids) {
		LOG.info("ids: " + ids);
		Iterator<String> it = Splitter.on(",").split(ids).iterator();
		ThreadGroup threadGroup = Thread.currentThread().getThreadGroup();
		if (threadGroup.activeCount() == 0) {
			LOG.info("Pyramid: There is no crawler thread to kill.");
		} else {
			while (it.hasNext()) {
				Thread t = ThreadUtils.findThread(Long.parseLong(it.next()));
				t.interrupt();
			}
		}
		LOG.info("Pyramid: This is the crawler api.");
		crawler.getConwArrayList().forEach(t_id -> System.out.println(t_id));
		return Response.ok().build();
	}

}
