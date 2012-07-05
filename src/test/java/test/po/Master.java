package test.po;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.eweb4j.mvc.validator.annotation.Enumer;
import org.eweb4j.mvc.validator.annotation.Length;
import org.eweb4j.mvc.validator.annotation.Required;


/**
 * 宠物主人
 * 
 * @author weiwei
 * 
 */
@Entity(name = "t_master")
public class Master {
	@Id
	private long id;
	@Required(mess = "姓名必填")
	@Length(min = 2, max = 32, mess = "姓名2-32位")
	private String name;
	@Enumer(words = { "男", "女", "保密" }, mess = "性别只能填写为[男,女,保密]")
	private String gender;

	@OneToMany(targetEntity = Pet.class, mappedBy = "master_id")
	private List<Pet> pets = new ArrayList<Pet>();

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Pet> getPets() {
		return pets;
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
	}

	public long getId() {
		return id;
	}

	public void setId(long masterId) {
		this.id = masterId;
	}

	@Override
	public String toString() {
		return "Master [masterId=" + id + ", name=" + name + ", gender="
				+ gender + ", pets=" + pets + "]";
	}

}
