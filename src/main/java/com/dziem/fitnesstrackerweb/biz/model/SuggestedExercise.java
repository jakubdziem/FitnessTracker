package com.dziem.fitnesstrackerweb.biz.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class SuggestedExercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @Column(length=1000)
    private String description;
    @Column(length=1000)
    private String link;
    @ManyToOne
    @JoinColumn(name = "category_id", referencedColumnName = "id")
    private ExerciseCategory category;
}
