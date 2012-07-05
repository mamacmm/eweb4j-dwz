package test.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "t_pet")
public class Pet {

	@Id
	@Column(name = "id")
	private long petId;
	private String number;
	private String name;

	private int age;

	private String type;// 只能添加猫和狗两种类型
	@OneToOne(mappedBy = "master_id")
	private Master master;

	public long getPetId() {
		return petId;
	}

	public void setPetId(long id) {
		this.petId = id;
	}

	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Master getMaster() {
		return master;
	}

	public void setMaster(Master master) {
		this.master = master;
	}

	@Override
	public String toString() {
		return "Pet [petId=" + petId + ", number=" + number + ", name=" + name
				+ ", age=" + age + ", type=" + type + ", master=" + master
				+ "]";
	}

}
