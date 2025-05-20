package models;

import org.springframework.stereotype.Component;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="Plane")
@Data
@NoArgsConstructor
public class PlaneModel {
	@Id
	@GeneratedValue
	private int id;
	
	@Column(nullable=false)
	private String model;
	
	@Column(nullable=false)
	private int seats;
	
	@Column(nullable=false)
	private int productionYear;
}
