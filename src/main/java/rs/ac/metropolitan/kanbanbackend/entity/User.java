package rs.ac.metropolitan.kanbanbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "user")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class User extends Auditable implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "user_id")
    @ToString.Exclude
    private Integer userId;
    @Column(name = "first_name")
    @ToString.Exclude
    private String firstName;
    @Column(name = "last_name")
    @ToString.Exclude
    private String lastName;
    @Column(name = "password")
    @ToString.Exclude
    private String password;
    @Column(name = "username")
    @ToString.Exclude
    private String username;
    @Column(name = "prof_pic")
    @ToString.Exclude
    private String profPic;
    @Column(name = "email")
    @ToString.Exclude
    private String email;
    @ManyToMany(fetch = FetchType.EAGER)
    @ToString.Exclude
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private List<Role> roleList;
    @ManyToMany
    @ToString.Exclude
    @JsonIgnore
    @JoinTable(name = "user_project", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "project_id"))
    private List<Project> projectList;
    @ManyToMany
    @JoinTable(name = "user_task", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "task_id"))
    @ToString.Exclude
    @JsonIgnore
    private List<Task> taskList;

    @Override
    @JsonIgnore
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roleList;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return getRecordStatus() != null && getRecordStatus() != 0;
    }
}