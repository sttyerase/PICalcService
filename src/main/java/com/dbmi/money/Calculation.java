package com.dbmi.money;

public class Calculation {
    private PICalcJson myCalc   = new PICalcJson();

    public String getCalculation(int months, double principal, double interestRate) {
        return myCalc.calculatePayment(months, principal, interestRate);
    } // GETCALCULATION()

    public static void main(String[] args) {
        System.out.format("%s", new Calculation().getCalculation(48, 25000.00,  3.85));
    } // MAIN(STRING[])

} // CLASS
