package persistence.databaseSecondary;

import lombok.Data;

import javax.persistence.*;


@Entity
@Table(name = "movie")
@Data
class MovieJpaEntity {

	@Version
	private Integer version;

	@Id
	@GeneratedValue
	private int id;

	@Column
	private String name;

}
