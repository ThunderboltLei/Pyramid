package com.pyramid.entity.login;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OrderBy;
import javax.persistence.Table;

/**
 * 
 * @Author: lm8212<br>
 * @Date: 2014年8月23日 下午9:22:43<br>
 * @Project: Pyramid-Entity<br>
 * @Package: com.pyramid.entity.login<br>
 * @File: TLoginUser.java<br>
 * @Description: <br>
 */
@Entity
@Table(name = "T_LOGINUSER")
public class TLoginUser implements Serializable {

	private static final long serialVersionUID = 1822896961274276981L;
	private Integer id;
	private String email;
	private String telephone;
	private String password;
	private Long serianumber;
	private Long dbid;
	private Long usertype;// 注册用户userType 为1；体验用户userType为0
	private Long createtime;
	private Long endtime;
	private Long actived;// 注册用户：未通过邮件激活的，actived为0，否则为1；体验用户为0

	private Set<TUrl> turl;

	@Id
	@Column(name = "ID", unique = true)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the email
	 */
	@Column(name = "EMAIL")
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the password
	 */
	@Column(name = "PASSWORD")
	public String getPassword() {
		return password;
	}

	/**
	 * @param password
	 *            the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * @return the serianumber
	 */
	@Column(name = "SERIANUMBER")
	public Long getSerianumber() {
		return serianumber;
	}

	/**
	 * @param serianumber
	 *            the serianumber to set
	 */
	public void setSerianumber(Long serianumber) {
		this.serianumber = serianumber;
	}

	/**
	 * @return the dbid
	 */
	@Column(name = "DBID")
	public Long getDbid() {
		return dbid;
	}

	/**
	 * @param dbid
	 *            the dbid to set
	 */
	public void setDbid(Long dbid) {
		this.dbid = dbid;
	}

	/**
	 * @return the usertype
	 */
	@Column(name = "USERTYPE")
	// 0为检验用户，1为注册用户
	public Long getUsertype() {
		return usertype;
	}

	/**
	 * @param usertype
	 *            the usertype to set
	 */
	public void setUsertype(Long usertype) {
		this.usertype = usertype;
	}

	/**
	 * @return the createtime
	 */
	@Column(name = "CREATETIME")
	public Long getCreatetime() {
		return createtime;
	}

	/**
	 * @param createtime
	 *            the createtime to set
	 */
	public void setCreatetime(Long createtime) {
		this.createtime = createtime;
	}

	/**
	 * @return the endtime
	 */
	@Column(name = "ENDTIME")
	public Long getEndtime() {
		return endtime;
	}

	/**
	 * @param endtime
	 *            the endtime to set
	 */
	public void setEndtime(Long endtime) {
		this.endtime = endtime;
	}

	/**
	 * @return the actived
	 */
	@Column(name = "ACTIVED")
	public Long getActived() {
		return actived;
	}

	/**
	 * @param actived
	 *            the actived to set
	 */
	public void setActived(Long actived) {
		this.actived = actived;
	}

	/**
	 * @return the telephone
	 */
	@Column(name = "TELEPHONE")
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone
	 *            the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the turl
	 */
	// @OneToMany(mappedBy = "tloginuser")
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "tloginuser")
	@OrderBy("id asc")
	// mappedBy为one一方在many一方的声明对象
	public Set<TUrl> getTurl() {
		return turl;
	}

	/**
	 * @param turl
	 *            the turl to set
	 */
	public void setTurl(Set<TUrl> turl) {
		this.turl = turl;
	}

}
