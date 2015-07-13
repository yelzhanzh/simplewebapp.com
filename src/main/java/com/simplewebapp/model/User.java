package com.simplewebapp.model;

import java.io.Serializable;
import javax.persistence.*;

/**
 * Created by Zhangariny on 10/07/2015.
 */
@Entity
@Table(name="USERS")
public class User implements Serializable {

  @Id
  @Column(name="ID")
  @GeneratedValue
  private Integer id;

  @Column(name="FIRST_NAME")
  private String firstName;

  @Column(name="LAST_NAME")
  private String lastName;

  public User() {

  }

  public User(String firstName, String lastName) {
    this.firstName = firstName;
    this.lastName = lastName;
  }


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

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  @Override
  public String toString() { return firstName + " " + lastName;}

}
