/*
package com.bestvike.demo;

import org.apache.http.HttpHost;
import org.elasticsearch.action.delete.DeleteRequest;
import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.support.WriteRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.unit.TimeValue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class testt {

	private static void delete() throws IOException {
		RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost(elasticIp, elasticPort)));
		String index = "test1";
		String type = "_doc";
		// 唯一编号
		String id = "1";
		IndexRequest request = new IndexRequest(index, type, id);
		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("uid", 1234);
		jsonMap.put("phone", 12345678909L);
		jsonMap.put("msgcode", 1);
		jsonMap.put("sendtime", "2019-03-14 01:57:04");
		jsonMap.put("message", "xuwujing study Elasticsearch");
		request.source(jsonMap);
		IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
		System.out.println(indexResponse);
	}


}
*/
