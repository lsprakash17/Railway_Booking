package dto;

import java.sql.Date;
import java.time.LocalDate;
import java.time.Period;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

import lombok.Data;


@ Entity
@Data
public class User 
{
	@Id
	@GeneratedValue(generator = "x")
	@SequenceGenerator(name="x",sequenceName = "x",initialValue =121456,allocationSize = 1)
	int id;
	String Fname;
	String lname;
	long mobile;
	String email;
	String gender;
	String password;
    Date dob;
    int age;
    double wallet;
}
