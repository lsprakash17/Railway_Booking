package dto;

import java.sql.*;

import javax.annotation.ManagedBean;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import lombok.Data;

@Entity
@Data
public class TrainTicket {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
int id;
int trainnum;
String From;
String To;
int NUmberOfSeats;
double amt;
Date dob;
Date doj;

//pan
@ManyToOne
User user;
}
