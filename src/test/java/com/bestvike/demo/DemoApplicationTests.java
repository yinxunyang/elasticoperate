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
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {
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
	@Test
	public void test2(){
		String index = "fangwu_index";
		String type = "fangwu_type";
		// 唯一编号
		String id = "1";
		IndexRequest request = new IndexRequest(index, type, id);
		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("regionname", "丁豪广场");
		jsonMap.put("bldname", "1#楼");
		jsonMap.put("cellname", "2单元");
		jsonMap.put("roomname", "501室");
		jsonMap.put("address", "工业南路66号");
		jsonMap.put("name", "张三");
		jsonMap.put("certno", "370102199805210011");
		request.source(jsonMap);
		try {
			IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
			System.out.println(indexResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test3(){
		String index = "fangwu_index";
		String type = "fangwu_type";
		// 唯一编号
		String id = "2";
		IndexRequest request = new IndexRequest(index, type, id);
		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("regionname", "海信慧园");
		jsonMap.put("bldname", "2#楼");
		jsonMap.put("cellname", "1单元");
		jsonMap.put("roomname", "701室");
		jsonMap.put("address", "工业南路61号");
		jsonMap.put("name", "李四");
		jsonMap.put("certno", "370102199805210012");
		request.source(jsonMap);
		try {
			IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
			System.out.println(indexResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test4(){
		String index = "fangwu_index";
		String type = "fangwu_type";
		// 唯一编号
		String id = "3";
		IndexRequest request = new IndexRequest(index, type, id);
		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("regionname", "海信慧园");
		jsonMap.put("bldname", "2号楼");
		jsonMap.put("cellname", "1单元");
		jsonMap.put("roomname", "701室");
		jsonMap.put("address", "工业南路61号");
		jsonMap.put("name", "李四");
		jsonMap.put("certno", "370102199805210012");
		request.source(jsonMap);
		try {
			IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
			System.out.println(indexResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	@Test
	public void test5(){
		String index = "fangwu_index";
		String type = "fangwu_type";
		// 唯一编号
		String id = "4";
		IndexRequest request = new IndexRequest(index, type, id);
		Map<String, Object> jsonMap = new HashMap<>();
		jsonMap.put("regionname", "新东方花园");
		jsonMap.put("bldname", "2号楼");
		jsonMap.put("cellname", "1单元");
		jsonMap.put("roomname", "701室");
		jsonMap.put("address", "舜华路6号");
		jsonMap.put("name", "李四");
		jsonMap.put("certno", "370102199805210012");
		request.source(jsonMap);
		try {
			IndexResponse indexResponse = client.index(request, RequestOptions.DEFAULT);
			System.out.println(indexResponse);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
