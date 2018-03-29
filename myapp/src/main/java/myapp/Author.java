package myapp;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="author")
public class Author implements Serializable{
	
	private static final long serialVersionUID = -9157845054463772638L;

	@Id
	@Column(name="id")
	private Long id;
	
	@Column(name="last_name")
	private String lastname;
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
	
	@Override
	public String toString() {
		return "Author [id=" + id + ", lastname=" + lastname + "]";
	}
	
	

}
