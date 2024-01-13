package com.levimartines.springdemo.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLRestriction;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "estimates")
@SQLRestriction("deleted=false")
public class Estimate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToOne
	@JoinColumn(name = "car_id", updatable = false)
	private Car car;

	@OneToMany(mappedBy = "estimate", cascade = CascadeType.ALL)
	private List<Item> items = new ArrayList<>();
	private LocalDate date = LocalDate.now();
	private boolean done;
	private boolean deleted;

	public Double getTotal() {
		Double total = 0.0;
		for (Item item : items) {
			total += item.getPrice();
		}
		return total;
	}

}
