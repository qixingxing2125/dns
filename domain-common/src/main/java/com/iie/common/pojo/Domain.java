package com.iie.common.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class Domain {
	private Long id;
	private String domain;
	private String source;
	private String label;
	private String type;
	private String location;
	private Date foundtime;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getDomain() {
		return domain;
	}
	public void setDomain(String domain) {
		this.domain = domain;
	}
	public String getSource() {
		return source;
	}
	public void setSource(String source) {
		this.source = source;
	}
	public String getLabel() {
		return label;
	}
	public void setLabel(String label) {
		this.label = label;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public Date getFoundtime() {
		return foundtime;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setFoundtime(Date foundtime) {
		this.foundtime = foundtime;
	}
}
