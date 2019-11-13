package com.account.CrudDemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Account {
	@Id
	@GeneratedValue
	private Long id;
	private String name;
	private Long initialBalance;
	
	
	public Long getInitialBalance() {
		return initialBalance;
	}
	public void setInitialBalance(Long initialBalance) {
		this.initialBalance = initialBalance;
	}
	public Long getId(){
		return this.id;
	}
	public String getName(){
		return this.name;
	}
	
	public void setId(Long id){
		this.id=id;
	}
	public void setName(String name){
		this.name=name;
	}
}