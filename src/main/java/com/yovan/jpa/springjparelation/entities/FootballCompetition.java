package com.yovan.jpa.springjparelation.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "football_competition")
public class FootballCompetition {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name", columnDefinition = "VARCHAR(300)")
  private String name;

  @Column(name = "cuantity_price")
  private Integer cuantityPrice;

  @Column(name = "start_date", columnDefinition = "DATE")
  private LocalDate startDate;

  @Column(name = "end_date", columnDefinition = "DATE")
  private LocalDate endDate;

}
