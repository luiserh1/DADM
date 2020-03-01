package com.luiserh1.dadm.pojo;

public class Quotation {
    private String quoteText, quoteAuthor;

    public String getQuoteText() {return quoteText;}
    public void setQuoteAuthor(String newQuoteAuthor) {this.quoteAuthor = newQuoteAuthor;}

    public String getQuoteAuthor() {return quoteAuthor;}
    public void setQuoteText(String newQuoteText) {this.quoteText = newQuoteText;}

    public Quotation(String quoteText, String quoteAuthor) {
        this.quoteText = quoteText;
        this.quoteAuthor = quoteAuthor;
    }
}
