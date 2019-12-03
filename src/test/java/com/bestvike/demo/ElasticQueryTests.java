package com.bestvike.demo;

import org.apache.http.HttpHost;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.io.IOException;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ElasticQueryTests {
	RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.237.130", 9200)));

	@Test
	public void test1() {
		String index = "fangwu_index";
		String type = "fangwu_type";
		// 查询指定的索引库
		SearchRequest searchRequest = new SearchRequest(index);
		searchRequest.types(type);
		SearchSourceBuilder sourceBuilder = new SearchSourceBuilder();
		// 设置查询条件
		sourceBuilder.query(QueryBuilders.termQuery("certno", "370102199805210012"));
		searchRequest.source(sourceBuilder);
		System.out.println("普通查询的DSL语句:"+sourceBuilder.toString());
		// 同步查询
		try {
			SearchResponse searchResponse = client.search(searchRequest, RequestOptions.DEFAULT);
			// 结果
			searchResponse.getHits().forEach(hit -> {
				Map<String, Object> map = hit.getSourceAsMap();
				System.out.println("普通查询的结果:" + map);
			});
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
