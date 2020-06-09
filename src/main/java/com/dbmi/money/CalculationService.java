package com.dbmi.money;

public class CalculationService {
    private PICalcJson myCalc   = new PICalcJson();

    public String getCalculation(int months, double principal, double interestRate) {
        return myCalc.calculatePayment(months, principal, interestRate);
    } // GETCALCULATION()

    public static void main(String[] args) {
        System.out.format("%s", new CalculationService().getCalculation(48, 25000.00,  3.85));
    } // MAIN(STRING[])

} // CLASS
