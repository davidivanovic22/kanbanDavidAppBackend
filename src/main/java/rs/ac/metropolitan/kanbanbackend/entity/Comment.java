package rs.ac.metropolitan.kanbanbackend.entity;


import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Data
@Entity
@NoArgsConstructor
@Table(name = "comment")
@EqualsAndHashCode(callSuper = false, onlyExplicitlyIncluded = true)
public  class Comment extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    @Column(name = "comment_id")
    private Integer commentId;
    @Column(name = "comment_text")
    private String commentText;
    @ManyToOne
    @JoinColumn(name = "task_id", referencedColumnName = "task_id")
    private Task taskId;
    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "user_id")
    private User userId;

}