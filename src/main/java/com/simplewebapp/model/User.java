package com.simplewebapp.model;

import javax.persistence.*;

/**
 * Created by Zhangariny on 10/07/2015.
 */
@Entity
@Table(name="users")
public class User {

  @Id
  @Column(name="ID")
  @GeneratedValue
  private Integer id;

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Column(name="FIRSTNAME")
  private String firstName;

  @Column(name="LASTNAME")
  private String lastName;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }


}
