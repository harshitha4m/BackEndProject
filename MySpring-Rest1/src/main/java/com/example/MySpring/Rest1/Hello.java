package com.example.MySpring.Rest1;

import jakarta.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Hello {
private int id;
private String name;
public Hello() {
	super();
}
private String massage;
public Hello(int id, String name, String massage) {
	super();
	this.id = id;
	this.name = name;
	this.massage = massage;
}
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
@Override
public String toString() {
	return "Hello [id=" + id + ", name=" + name + ", massage=" + massage + "]";
}
public String getMassage() {
	return massage;
}
public void setMassage(String massage) {
	this.massage = massage;
}
}