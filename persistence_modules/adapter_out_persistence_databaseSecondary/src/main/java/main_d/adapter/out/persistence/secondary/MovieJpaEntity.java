package main_d.adapter.out.persistence.secondary;

import lombok.Data;
import main_d.Movie;

import javax.persistence.*;


@Entity
@Table(name = "movie")
@Data
class MovieJpaEntity {

	@Version
	@GeneratedValue
	private Integer version;

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String name;

	public MovieJpaEntity update(Movie movieUpdated) {
		this.name = movieUpdated.getName();
		return this;
	}
}
