package com.learning.services;

import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.Cache;
import org.springframework.cache.CacheManager;
import org.springframework.stereotype.Service;

@Service 
public class CacheInspectionService {

	@Autowired
	private CacheManager cacheManager;
	
	public String printCacheContent(String cacheName) {
		Cache cache = cacheManager.getCache(cacheName);
		if(cache!=null) {
			System.out.println("Cache contents: ");
			System.out.println(Objects
					.requireNonNull(
							cache.getNativeCache()).toString());
			return cache.getNativeCache().toString();
		}
		else {
			System.out.println("No such cache: "+cacheName);
			return "No such cache Found with name "+cacheName;
		}
	}
}
