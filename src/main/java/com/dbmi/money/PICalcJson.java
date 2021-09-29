package com.dbmi.money;

import java.util.*;

public class PICalcJson {

    private StringBuilder sb   = new StringBuilder();
    private Formatter fmt      = new Formatter(sb);

   public String calculatePayment(int mon, double princp, double irate){
      String calculation = "";
      double totpay      = 0;
      Double [][] paydet;
      double payment = 0;
      double intrate = (irate * 0.01)/12;
      payment = (intrate * princp)/(1-(java.lang.Math.pow((1+intrate),-mon)));
      paydet = calculatePaymentDetails(princp,intrate,mon,payment);
      fmt.format("{\"LOAN\" : { \"terms\" : { \"principal\" :  %04.2f , \"annual interest rate \" : %04.2f , \"months\" : %d }}, \n",princp,irate,mon);
      fmt.format("        \"monthly payment\" : %04.2f , \n",payment);
      fmt.format("       \"details\" : [ \n");
      for(int indx = 0 ; indx < mon ; indx++){
         fmt.format(" {\"month\" : %d , \"interest payment\" : %04.2f , \"principal paid\" : %04.2f , \"principal balance\" : %04.2f }",
                 indx + 1, paydet[indx][0],paydet[indx][1],paydet[indx][2]);
         if(indx < (mon - 1))  fmt.format(",\n");
         else fmt.format("\n");
         totpay += payment;
      } // FOR
      fmt.format(" ] , \n \"total payments\" : \"$%04.2f\"  \n", totpay);
      fmt.format("}");
      calculation = calculation.concat(sb.substring(0));
      return calculation;
   } // CALCULATE(DOUBLE,DOUBLE,INT)

   public Double[][] calculatePaymentDetails(double princp, double irate, int mon, double pymt){
      Double[][] detail = new Double[mon][3];
      double intpaid = 0;
      double balance = princp;
      double prinpaid = 0;
      double payment = pymt;
      for(int i=0; i<mon; i++){
         intpaid  = irate * balance    ;  detail[i][0] = intpaid  ;
         prinpaid = payment - intpaid  ;  detail[i][1] = prinpaid ;
         balance = balance - prinpaid  ;  detail[i][2] = balance  ;
      } // FOR
      return detail;
   } // SHOWPAYMENTDETAILS(DOUBLE,DOUBLE,INT,DOUBLE)

   /*
    * Test the PICalc engine.
    */
   public static void main(String[] args){
      int    months    = 48;
      double principal = 25000.0;
      double intrate  = 3.85;
      PICalcJson myCalc = new PICalcJson();
      String result = myCalc.calculatePayment(months,principal,intrate);
      System.out.format("%s", result);
} // MAIN(STRING[])

} // CLASS
