package com.softpager.sbsd.demosecurity.entities;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Data
@Entity
public class Task {
    @Id
   @GeneratedValue
    @Column(name = "task_id")
    private long id;

    @NotEmpty
    private String description;

    @ManyToOne()
    @JoinColumn(name = "TASK_OWNERS_ID")
    private User user;

    //constructors
    public Task(String description, User user) {
        this.description = description;
        this.user = user;
    }

    public Task(String description) {
        this.description = description;
    }

    public Task() {
    }
}
