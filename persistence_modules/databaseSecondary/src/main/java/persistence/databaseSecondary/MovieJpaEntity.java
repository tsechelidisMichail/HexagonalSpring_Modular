package persistence.databaseSecondary;

import jakarta.persistence.*;
import lombok.Data;


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
