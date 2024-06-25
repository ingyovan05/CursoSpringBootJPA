package com.yovan.jpa.springjparelation.entities;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "club")
public class Club {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  private String name;

  @OneToOne(targetEntity = Coach.class, cascade = CascadeType.PERSIST)
  @JoinColumn(name = "id_coach")
  private Coach coach;

  @OneToMany(targetEntity = Player.class, fetch = FetchType.LAZY, mappedBy = "club")
  private List<Player> players;

  @ManyToOne(targetEntity = FootballAssociation.class)
  private FootballAssociation footballAssociation;

  @ManyToMany(targetEntity = FootballCompetition.class, fetch = FetchType.LAZY)
  @JoinTable(name = "club_competitions", joinColumns = @JoinColumn(name = "club"), inverseJoinColumns = @JoinColumn(name = "competition"))
  private List<FootballCompetition> footballCompetitions;

}
