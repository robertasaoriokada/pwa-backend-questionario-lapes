package com.questionario.entities;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "FORMS")
public class Forms {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Column(name = "title")
  private String title;

  @Column(name = "description")
  private String description;

  @ManyToOne()
  @Column(name = "owner")
  @JoinColumn(name="user_id", nullable=false)
  private User owner;

  @Column(name = "questions")
  @OneToMany(mappedBy = "forms")
  private Questions questions; //int ou string? docs ta int

  @Column(name = "created_at")
  private Timestamp created_at;

  @Column(name = "updated_at")
  private Timestamp updated_at;

  
}
