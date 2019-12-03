package com.bestvike.demo;

import org.apache.http.HttpHost;
import org.elasticsearch.action.admin.indices.alias.Alias;
import org.elasticsearch.action.admin.indices.create.CreateIndexRequest;
import org.elasticsearch.action.admin.indices.create.CreateIndexResponse;
import org.elasticsearch.action.admin.indices.get.GetIndexRequest;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author: yinxunyang
 * @Description:
 * @Date: 2019/12/3 9:13
 * @param:
 * @return:
 */
@Service
public class ElasticService {
	private static final RestHighLevelClient client = new RestHighLevelClient(RestClient.builder(new HttpHost("192.168.237.130", 9200)));

	/**
	 * @Author: yinxunyang
	 * @Description: 新增索引库
	 * @Date: 2019/12/3 9:15
	 * @param:
	 * @return:
	 */
	@Deprecated
	public static void createIndex() throws IOException {
		String type = "_doc";
		String index = "fangwu";
		// setting 的值
		Map<String, Object> setmapping = new HashMap<>();
		// 分区数、副本数、缓存刷新时间
		setmapping.put("number_of_shards", 5);
		setmapping.put("number_of_replicas", 0);
		setmapping.put("refresh_interval", "5s");
		Map<String, Object> keyword = new HashMap<>();
		//设置类型
		keyword.put("type", "keyword");
		// 房屋地址
		Map<String, Object> address = new HashMap<>();
		//设置类型
		address.put("type", "text");
		// 业务姓名
		Map<String, Object> ownername = new HashMap<>();
		// 设置类型
		address.put("ownername", "keyword");
		// 身份证号
		Map<String, Object> certno = new HashMap<>();
		//设置类型
		address.put("certno", "keyword");
		Map<String, Object> date = new HashMap<>();
		//设置类型
		date.put("type", "date");
		date.put("format", "yyyy-MM-dd HH:mm:ss");

		Map<String, Object> jsonMap2 = new HashMap<>();
		Map<String, Object> properties = new HashMap<>();
		//设置字段message信息
		properties.put("uid", keyword);
		properties.put("phone", keyword);
		properties.put("msgcode", keyword);
		properties.put("address", address);
		properties.put("ownername", ownername);
		properties.put("certno", certno);
		properties.put("message", keyword);
		properties.put("sendtime", date);
		Map<String, Object> mapping = new HashMap<>();
		mapping.put("properties", properties);
		jsonMap2.put(type, mapping);

		GetIndexRequest getRequest = new GetIndexRequest();
		getRequest.indices(index);
		getRequest.local(false);
		getRequest.humanReadable(true);
		boolean exists2 = client.indices().exists(getRequest, RequestOptions.DEFAULT);
		//如果存在就不创建了
		if (exists2) {
			System.out.println(index + "索引库已经存在!");
			return;
		}
		// 开始创建库
		CreateIndexRequest request = new CreateIndexRequest(index);
		try {
			// 加载数据类型
			request.settings(setmapping);
			//设置mapping参数
			request.mapping(type, jsonMap2);
			//设置别名
			request.alias(new Alias("pancm_alias"));
			CreateIndexResponse createIndexResponse = client.indices().create(request, RequestOptions.DEFAULT);
			boolean falg = createIndexResponse.isAcknowledged();
			if (falg) {
				System.out.println("创建索引库:" + index + "成功！");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
