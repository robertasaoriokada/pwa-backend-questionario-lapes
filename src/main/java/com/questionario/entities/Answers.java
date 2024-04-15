package com.questionario.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Table;

@Entity
@Table(name = "ANSWERS")
public class Answers {
  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  @Column(name = "content")
  private String content;

  @Column(name = "point")
  private String point;

  @Column(name = "question")
  @JoinColumn(name = "answer_id", nullable = false)
  private Questions question;

  @Column(name = "created_at")
  private Timestamp created_at;
  
  @Column(name = "updated_at")
  private Timestamp updated_at;
}
