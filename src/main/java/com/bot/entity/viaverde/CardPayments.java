package com.bot.entity.viaverde;

import java.util.List;

public class CardPayments {
	
	private Integer totalrows;
	private List<Transaction> transactions;
	
	public Integer getTotalrows() {
		return totalrows;
	}
	public void setTotalrows(Integer totalrows) {
		this.totalrows = totalrows;
	}
	public List<Transaction> getTransactions() {
		return transactions;
	}
	public void setTransactions(List<Transaction> transactions) {
		this.transactions = transactions;
	}

}
