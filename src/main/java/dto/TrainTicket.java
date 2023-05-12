package dto;

import java.sql.*;

import javax.annotation.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

import lombok.Data;

@Entity(name="trainticket")
@Data
public class TrainTicket {
@Id
@GeneratedValue(generator = "pnr")
@SequenceGenerator(initialValue = 4566541,allocationSize = 1,name="pnr",sequenceName = "pnr")
int pnr;
int id;
int trainnum;
String source;
String destination;
int NUmberOfSeats;
double amt;
Date dob;
Date doj;
String status;

//pan
@ManyToOne
User user;
}
