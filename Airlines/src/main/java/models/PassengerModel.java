package models;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name="Passenger")
@NoArgsConstructor
public class PassengerModel {
	@Id
	@GeneratedValue
	private int id;
	@Column(nullable=false)
	private String name;
	@Column(nullable = false)
	private String surname;
	@Column(nullable=false, unique=true, length=11)
	private String pesel;
	@Column(nullable=false)
	private String email;
}
