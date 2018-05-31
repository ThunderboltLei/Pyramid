package com.pyramid.rpc;

import java.util.concurrent.ConcurrentHashMap;

public class RPCCache {

	private static RPCCache rpcCache;

	public ConcurrentHashMap<String, String> dataCache = new ConcurrentHashMap<String, String>();;

	public RPCCache() {
		// TODO Auto-generated constructor stub
		
	}

	public static RPCCache getInstance() {
		if (rpcCache == null) {
			rpcCache = new RPCCache();
		}
		return rpcCache;
	}

	public ConcurrentHashMap<String, String> getDataCache() {
		return dataCache;
	}

	public void setDataCache(ConcurrentHashMap<String, String> dataCache) {
		this.dataCache = dataCache;
	}

}
