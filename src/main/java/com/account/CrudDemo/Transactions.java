package com.account.CrudDemo;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Transactions {
	@Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "transaction_seq")
    @SequenceGenerator(sequenceName = "transaction_seq", allocationSize = 1, name = "transaaction_seq")
	//@Column(name = "emp_id")
    //private Long empId;
	int transactionId;
	int debitedAccount;
	public int getTransactionId() {
		return transactionId;
	}
	public void setTransactionId(int transactionId) {
		this.transactionId = transactionId;
	}
	int creditedAccount;
	int amount;
	public int getDebitedAccount() {
		return debitedAccount;
	}
	public void setDebitedAccount(int debitedAccount) {
		this.debitedAccount = debitedAccount;
	}
	public int getCreditedAccount() {
		return creditedAccount;
	}
	public void setCreditedAccount(int creditedAccount) {
		this.creditedAccount = creditedAccount;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}

}
