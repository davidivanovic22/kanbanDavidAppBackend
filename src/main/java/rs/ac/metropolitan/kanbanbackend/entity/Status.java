package rs.ac.metropolitan.kanbanbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "status")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Status extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@ToString.Exclude
	@Column(name = "status_id")
	private Integer statusId;
	@Column(name = "name")
	@ToString.Exclude
	private String name;
	@ManyToMany
	@JsonIgnore
	@ToString.Exclude
	@JoinTable(name = "project_status", joinColumns = @JoinColumn(name = "status_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
	private List<Project> projectList;
	
}