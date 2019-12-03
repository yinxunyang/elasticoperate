package com.bestvike.demo;

import org.apache.http.HttpHost;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
	@Autowired
	private BlogRepository blogRepository;
	@Test
	public void contextLoads() {
		//blogRepository.save(new Blog(123, 456, 789));
	}
	RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.237.130", 9200)));
	@Test
	public void test1(){
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
		try {
			IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
			System.out.println(indexResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
