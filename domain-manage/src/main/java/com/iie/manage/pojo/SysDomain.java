package com.iie.manage.pojo;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.iie.common.util.DateFormatConverter;
@Table(name="sys_domain")
public class SysDomain {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private String domain;
	private Integer sourceId;
	private Integer labelId;
	private Integer typeId;
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
	public Integer getSourceId() {
		return sourceId;
	}
	public void setSourceId(Integer sourceId) {
		this.sourceId = sourceId;
	}
	public Integer getLabelId() {
		return labelId;
	}
	public void setLabelId(Integer labelId) {
		this.labelId = labelId;
	}
	public Integer getTypeId() {
		return typeId;
	}
	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	@JsonSerialize(using=DateFormatConverter.class)
	public Date getFoundtime() {
		return foundtime;
	}
	@DateTimeFormat(pattern="yyyy-MM-dd")
	public void setFoundtime(Date foundtime) {
		this.foundtime = foundtime;
	}
}
