package com.pathforge.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "topics")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long topicId;

    @ManyToOne
    @JoinColumn(name = "roadmap_id")
    private Roadmap roadmap;

    @Column(nullable = false)
    private String topicName;

    @Column(columnDefinition = "TEXT")
    private String description;

    private String difficulty;

    private Integer estimatedHours;

    @Column(updatable = false)
    private LocalDateTime createdAt;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<StudyMaterial> studyMaterials;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<InterviewQuestion> interviewQuestions;

    @OneToMany(mappedBy = "topic", cascade = CascadeType.ALL)
    private List<FAQ> faqs;

    @PrePersist
    public void prePersist() {
        createdAt = LocalDateTime.now();
    }
}