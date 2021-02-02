package rs.ac.metropolitan.kanbanbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "role")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Role extends Auditable  implements GrantedAuthority {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@EqualsAndHashCode.Include
	@Column(name = "role_id")
	private Integer roleId;
	@Column(name = "name")
	private String name;

	@ManyToMany(cascade = {CascadeType.PERSIST})
	@JoinTable(name = "user_role", joinColumns = @JoinColumn(name= "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
	@JsonIgnore
	@ToString.Exclude
	private List<rs.ac.metropolitan.kanbanbackend.entity.User> userList;

	@Override
	public String getAuthority() {
		return "ROLE_" + getName();
	}
}