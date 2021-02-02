package rs.ac.metropolitan.kanbanbackend.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@Table(name = "project")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public class Project extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "project_id")
    @ToString.Exclude
    private Integer projectId;
    @Column(name = "name")
    @ToString.Exclude
    private String name;
    @Column(name = "description")
    @ToString.Exclude
    private String description;
    @Column(name = "start_date")
    @ToString.Exclude
    private Date startDate;
    @Column(name = "end_date")
    @ToString.Exclude
    private Date endDate;
    @ManyToMany
    @JsonIgnore
    @ToString.Exclude
    @JoinTable(name = "project_status", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "status_id"))
    private List<Status> statusList;
    @ManyToMany
    @JsonIgnore
    @ToString.Exclude
    @JoinTable(name = "user_project", joinColumns = @JoinColumn(name = "project_id"), inverseJoinColumns = @JoinColumn(name = "user_id"))
    private List<User> userList;

}