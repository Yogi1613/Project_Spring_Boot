package com.itv.ITV205FirstSpringbootApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Entity
public class Player {
 @Id@GeneratedValue(strategy = GenerationType.IDENTITY)
 private int playerId;
 private String playerName;
 private String playerEmail;
 private long playerPhone;
 private String dob;
 private String gender;
 private String position;
 private String skillLevel;
 private String teamAffiliation;
 private String playerBio;
 private int fitnessLevel;
 
}
