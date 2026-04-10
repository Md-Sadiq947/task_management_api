package com.sadique.task_api.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import io.swagger.v3.oas.annotations.media.Schema;
import java.time.LocalDate;

@Entity
@Table(name = "task")
@Data
@NoArgsConstructor
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(hidden = true)
    private int id;
    @Schema(hidden = true)
    private LocalDate createdAt;
    private String title;
    private String description;

    //Foreign key
    @JsonBackReference
    @ManyToOne
    @JoinColumn(name = "user_id")
    @Schema(hidden = true)
    private User user;
}
