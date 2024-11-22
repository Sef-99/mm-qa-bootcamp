package org.example.components;

public class Transaction {
    private final String date;
    private final String transactionType;
    private final String debit;
    private final String credit;

    public Transaction(String date, String transactionType, String debit, String credit) {
        this.date = date;
        this.transactionType = transactionType;
        this.debit = debit;
        this.credit = credit;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public String getDebit() {
        return debit;
    }

    public String getCredit() {
        return credit;
    }
}
