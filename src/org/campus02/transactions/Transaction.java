package org.campus02.transactions;

import java.io.Serializable;

public class Transaction implements Serializable {
    private final String transactionDate;
    private final String product;
    private final double price;
    private final String paymentType;
    private final String name;
    private final String city;
    private final String state;
    private final String country;

    public Transaction(String transactionDate, String product, double price, String paymentType, String name, String city, String state, String country) {
        this.transactionDate = transactionDate;
        this.product = product;
        this.price = price;
        this.paymentType = paymentType;
        this.name = name;
        this.city = city;
        this.state = state;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionDate='" + transactionDate + '\'' +
                ", product='" + product + '\'' +
                ", price=" + price +
                ", paymentType='" + paymentType + '\'' +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    public String getTransactionDate() {
        return transactionDate;
    }

    public String getProduct() {
        return product;
    }

    public double getPrice() {
        return price;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }
}
