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
@Table(name = "label")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Label extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "label_id")
	@ToString.Exclude
	private Integer labelId;
	@Column(name = "name")
	@ToString.Exclude
	private String name;
	@Column(name = "background_color")
	@ToString.Exclude
	private String backgroundColor;
	@Column(name = "text_color")
	@ToString.Exclude
	private String textColor;
	@ManyToMany
	@JsonIgnore
	@ToString.Exclude
	@JoinTable(name = "task_label", joinColumns = @JoinColumn(name = "label_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
	private List<Task> taskList;
	
}