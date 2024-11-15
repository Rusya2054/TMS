package com.task.Rusya2054.models;

import com.task.Rusya2054.models.enums.Priority;
import com.task.Rusya2054.models.enums.Status;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "tasks")
@Data
public class Task {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "status")
    @Enumerated(EnumType.STRING)
    private Status status;

    @Column(name = "priority")
    @Enumerated(EnumType.STRING)
    private Priority priority;

    @OneToOne(cascade =  CascadeType.REFRESH, fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User executor;

    @Column(name = "comment")
    private String comment;
}
