package com.rf.backend.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Table
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotNull
    @Size(max = 255)
    private String content;
    @ManyToOne
    @JoinColumn(name = "post_id")
    private Share share;
    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

  // private List<Comment> comments;
}
