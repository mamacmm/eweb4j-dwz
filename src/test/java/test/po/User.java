package test.po;

import org.eweb4j.mvc.validator.annotation.Chinese;
import org.eweb4j.mvc.validator.annotation.DateFormat;
import org.eweb4j.mvc.validator.annotation.Email;
import org.eweb4j.mvc.validator.annotation.Enumer;
import org.eweb4j.mvc.validator.annotation.Equals;
import org.eweb4j.mvc.validator.annotation.Forbid;
import org.eweb4j.mvc.validator.annotation.IDCard;
import org.eweb4j.mvc.validator.annotation.Int;
import org.eweb4j.mvc.validator.annotation.Length;
import org.eweb4j.mvc.validator.annotation.QQ;
import org.eweb4j.mvc.validator.annotation.Required;
import org.eweb4j.mvc.validator.annotation.Size;

public class User {
	@Required
	@IDCard
	private long idCard;// 身份证号码,必填

	@Required
	@Chinese
	private String chineseName;// 中文姓名,必填

	@DateFormat("yyyy年MM月dd号")
	private String birthDay;// 出生日期,格式:yyyy年MM月dd号

	@Int
	@Size(min = 18, max = 50)
	private int age = 0;// 年龄 0 为保密

	@Required
	@Length(min = 6, max = 18)
	private String account;// 帐号,必填

	@Required
	@Length(min = 6, max = 32)
	private String password;// 密码,必填

	@Equals(to="password", mess="请确认密码")
	private String confirmPwd;// 确认密码

	@Email
	private String email;// 邮件地址

	@QQ
	private String qq;// QQ号码

	@Enumer(words = { "男", "女", "保密" })
	private String gender;// 性别

	@Length(min = 50, max = 500)
	@Forbid(words = { "独立", "反共", "性爱" })
	private String intro;// 个人简介,要求文明用语

	public long getIdCard() {
		return idCard;
	}

	public void setIdCard(long idCard) {
		this.idCard = idCard;
	}

	public String getChineseName() {
		return chineseName;
	}

	public void setChineseName(String chineseName) {
		this.chineseName = chineseName;
	}

	public String getBirthDay() {
		return birthDay;
	}

	public void setBirthDay(String birthDay) {
		this.birthDay = birthDay;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getConfirmPwd() {
		return confirmPwd;
	}

	public void setConfirmPwd(String confirmPwd) {
		this.confirmPwd = confirmPwd;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getQq() {
		return qq;
	}

	public void setQq(String qq) {
		this.qq = qq;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getIntro() {
		return intro;
	}

	public void setIntro(String intro) {
		this.intro = intro;
	}

	@Override
	public String toString() {
		return "User [idCard=" + idCard + ", chineseName=" + chineseName
				+ ", birthDay=" + birthDay + ", age=" + age + ", account="
				+ account + ", password=" + password + ", confirmPwd="
				+ confirmPwd + ", email=" + email + ", qq=" + qq + ", gender="
				+ gender + ", intro=" + intro + "]";
	}

}
