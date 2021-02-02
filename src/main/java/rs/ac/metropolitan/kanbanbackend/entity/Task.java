package rs.ac.metropolitan.kanbanbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "task")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Task extends Auditable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "task_id")
	@ToString.Exclude
	private Integer taskId;
	@JoinColumn(name = "project_id", referencedColumnName = "project_id")
	@ManyToOne
	@ToString.Exclude
	private Project projectId;
	@JoinColumn(name = "status_id", referencedColumnName = "status_id")
	@ManyToOne
	@ToString.Exclude
	private Status statusId;
	@Column(name = "name")
	private String name;
	@ToString.Exclude
	@Column(name = "description")
	private String description;
	@ToString.Exclude
	@Column(name = "due_date")
	private Date dueDate;
	@JoinTable(name = "task_label", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "label_id"))
	@ManyToMany
	@ToString.Exclude
	private List<Label> labelList;
	@JoinTable(name = "user_task", joinColumns = @JoinColumn(name = "task_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
	@ManyToMany
	@ToString.Exclude
	private List<User> userList;
	
}