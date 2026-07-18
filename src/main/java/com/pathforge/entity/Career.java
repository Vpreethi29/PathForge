package com.pathforge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "careers")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Career {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long careerId;

    @Column(nullable = false, unique = true)
    private String careerName;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String icon;

    private String duration;

    private String difficulty;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "career", cascade = CascadeType.ALL)
    private List<Roadmap> roadmaps;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}