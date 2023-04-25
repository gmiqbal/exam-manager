package com.gmiqbal.exammanager.entities;

import com.gmiqbal.exammanager.constants.DifficultyType;
import com.gmiqbal.exammanager.constants.ExamStatus;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
//used data from lombok instead of getters, setters, toString
@Table(name="exam")
public class Exam {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", unique = true, nullable = false)
    private Integer id;

    @Column(name = "title", nullable = false, length = 10000)
    private String title;

    @Column(name="description", columnDefinition = "TEXT")
    private String description;

    @Column(name = "difficulty", nullable = false, columnDefinition = "ENUM('EASY','MEDIUM','HARD')")
    @Enumerated(EnumType.STRING)
    private DifficultyType difficulty;

    @Column(name = "status", nullable = false, columnDefinition = "ENUM('UPCOMING', 'ONGOING', 'DONE')")
    @Enumerated(EnumType.STRING)
    private ExamStatus status;

    @Column(name="is_deleted", nullable = false)
    private boolean isDeleted;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at", nullable = false, length = 10)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "modified_at", nullable = false, length = 10)
    private Date modifiedAt;

    @PrePersist
    protected void onCreate(){
        createdAt = new Date();
        modifiedAt = new Date();
    }

    @PreUpdate
    protected void onUpdate(){
        modifiedAt = new Date();
    }
}
