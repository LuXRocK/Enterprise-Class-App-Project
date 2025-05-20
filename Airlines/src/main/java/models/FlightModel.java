package models;

import java.time.LocalDateTime;

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


@Data
@NoArgsConstructor
@Entity
@Table(name="Flight")
public class FlightModel {
	@Id
	@GeneratedValue
	private int id;
	
	public enum FlightStatus {
        SCHEDULED,
        BOARDING,
        DEPARTED,
        IN_AIR,
        LANDED,
        CANCELLED,
        DELAYED,
        DIVERTED,
        UNKNOWN
    }
	@Enumerated(EnumType.STRING)
	@Column(nullable=false)
	private FlightStatus status;
	
	@Column(nullable=false)
	private String code;
	
	@Column(nullable=false)
	private LocalDateTime departureTime;
	
	@Column(nullable=false)
	private LocalDateTime arrivalTime;
}
