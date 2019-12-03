package com.bestvike.demo;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

@Document(indexName = "blog", type = "blog")
/**
 * 注意：
 * 1.blog要实现 Serializable
 * 2.ID为String
 */
public class Blog implements Serializable {

	@Id //2.表示为主键
	private String id;
	private Integer title;  //标题
	private Integer summary; //标签
	private Integer content;   //内容

	public Blog() {

	}

	public Blog(Integer title, Integer summary, Integer content) {
		this.title = title;
		this.summary = summary;
		this.content = content;
	}

	//省略getter()和setter()

	@Override
	public String toString() {
		return "EsBlog{" +
				"id='" + id + '\'' +
				", title='" + title + '\'' +
				", summary='" + summary + '\'' +
				", content='" + content + '\'' +
				'}';
	}
}