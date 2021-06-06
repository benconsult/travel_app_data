package main.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Future;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GeneratorType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Tour {

	public enum Continent{
		AFRICA,ASIA,EUROPE,SOUTH_AFRICA;
		
	}
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	

	@NotBlank(message = "Your name cannot be null")
	@Size(min = 5, message = "Name should have at least 5 characters")
    private String name;
	
	@Pattern(regexp = "^[a-zA-Z]{2}-[0-9]{2}[a-zA-Z]{1}$", message = "Expected format  is CC-DDC where c stands for character and D stand for digit")
	private String code;
	
	private Continent continent;
	
	@NotNull(message = "Please pick a date")
	@Future(message = "Date should be from the future")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date date;
	
	@Min(value=7, message = "Must be between 7 and 21")
	@Max(value = 21, message = "Must be between 7 and 21")
	private int duration;
	
	@Column(name = "all_inclusive")
	private boolean allInclusive = false;


	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Continent getContinent() {
		return continent;
	}

	public void setContinent(Continent continent) {
		this.continent = continent;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public boolean isAllInclusive() {
		return allInclusive;
	}

	public void setAllInclusive(boolean allInclusive) {
		this.allInclusive = allInclusive;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
	
	
	
}
