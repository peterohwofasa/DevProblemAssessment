package com.example.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Client {

    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String mobileNumber;
    @Id
    private String idNumber;
    private String physicalAddress;


    public Client() {
    }

 public Client(String firstName, String lastName, String mobileNumber, String idNumber, String physicalAddress) {
  this.firstName = firstName;
  this.lastName = lastName;
  this.mobileNumber = mobileNumber;
  this.idNumber = idNumber;
  this.physicalAddress = physicalAddress;
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

 public String getMobileNumber() {
  return mobileNumber;
 }

 public void setMobileNumber(String mobileNumber) {
  this.mobileNumber = mobileNumber;
 }

 public String getIdNumber() {
  return idNumber;
 }

 public void setIdNumber(String idNumber) {
  this.idNumber = idNumber;
 }

 public String getPhysicalAddress() {
  return physicalAddress;
 }

 public void setPhysicalAddress(String physicalAddress) {
  this.physicalAddress = physicalAddress;
 }
}
