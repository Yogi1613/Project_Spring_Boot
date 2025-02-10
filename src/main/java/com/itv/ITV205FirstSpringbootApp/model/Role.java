package com.itv.ITV205FirstSpringbootApp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
public class Role {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private int roleId;
private String roleName;
}
