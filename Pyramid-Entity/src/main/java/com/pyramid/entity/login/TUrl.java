package com.pyramid.entity.login;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:22:51<br>
 * @Project: Pyramid-Entity<br>
 * @Package: com.pyramid.entity.login<br>
 * @File: TUrl.java<br>
 * @Description: <br>
 */
@Entity
@Table(name = "T_URL")
public class TUrl implements Serializable {

	private static final long serialVersionUID = -2004577742478160822L;
	private Integer id;
	private Integer userid;
	private String url;
	private Long urltype;
	private Long sdnid;
	private Integer cmsid;
	private Integer isCmsScan;

	private TLoginUser tloginuser;

	/**
	 * @return the id
	 */
	@Id
	@Column(name = "ID", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	/**
	 * @param id
	 *            the id to set
	 */
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the userid
	 */
	@Column(name = "USERID")
	public Integer getUserid() {
		return userid;
	}

	/**
	 * @param userid
	 *            the userid to set
	 */
	public void setUserid(Integer userid) {
		this.userid = userid;
	}

	/**
	 * @return the url
	 */
	@Column(name = "URL")
	public String getUrl() {
		return url;
	}

	/**
	 * @param url
	 *            the url to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return the urltype
	 */
	@Column(name = "URLTYPE")
	public Long getUrltype() {
		return urltype;
	}

	/**
	 * @param urltype
	 *            the urltype to set
	 */
	public void setUrltype(Long urltype) {
		this.urltype = urltype;
	}

	/**
	 * @return the sdnid
	 */
	@Column(name = "SDNID")
	public Long getSdnid() {
		return sdnid;
	}

	public void setSdnid(Long sdnid) {
		this.sdnid = sdnid;
	}

	/**
	 * @return the tloginuser
	 */
	@ManyToOne(cascade = { CascadeType.MERGE, CascadeType.REFRESH }, fetch = FetchType.EAGER)
	@JoinColumn(name = "userid", referencedColumnName = "ID", insertable = false, updatable = false)
	// name为many一方的关联字段名,referencedColumnName为one一方关联字段名
	public TLoginUser getTloginuser() {
		return tloginuser;
	}

	/**
	 * @param tloginuser
	 *            the tloginuser to set
	 */
	public void setTloginuser(TLoginUser tloginuser) {
		this.tloginuser = tloginuser;
	}

	@Column(name = "cms_id")
	public Integer getCmsid() {
		return cmsid;
	}

	public void setCmsid(Integer cmsid) {
		this.cmsid = cmsid;
	}

	@Column(name = "is_cms_scan")
	public Integer getIsCmsScan() {
		return isCmsScan;
	}

	public void setIsCmsScan(Integer isCmsScan) {
		this.isCmsScan = isCmsScan;
	}

}
