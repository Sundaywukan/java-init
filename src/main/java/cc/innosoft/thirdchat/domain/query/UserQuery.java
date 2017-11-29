package cc.innosoft.thirdchat.domain.query;

import java.util.Date;

/**
 * @author wuk
 *
 */
public class UserQuery {

	/**
	 * id
	 */
	private Long id;

	/**
	 * 用户名
	 */
	private String userName;

	/**
	 * 昵称
	 */
	private String nickName;

	/**
	 * 性别
	 */
	private Integer sex;

	/**
	 * 生日
	 */
	private Date birthday;

	/**
	 * 头像
	 */
	private Long headPic;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
	}

	public Integer getSex() {
		return sex;
	}

	public void setSex(Integer sex) {
		this.sex = sex;
	}

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public Long getHeadPic() {
		return headPic;
	}

	public void setHeadPic(Long headPic) {
		this.headPic = headPic;
	}

}
