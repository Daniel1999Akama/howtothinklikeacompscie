// NAME : DANIEL AKAMA NYAMWEYA.

// REG: J31S/14016/2018.

// PROGRAM : PHONE BILLING SYSTEM.


import javax.swing.*;

import java.util.Calendar;

import java.util.GregorianCalendar;


public class Phonebill{

    private double starttime = 0;  // Setting the start time for the stopwatch .
    private double stoptime = 0;  //Setting the stop time for the watch.
    private boolean run = false; // Setting the stopwatch to false so that it does not start running.
    private static char [] phoneNo = new char[30];

    // Stopwatch start function.
    public void start(){
        this.starttime = System.currentTimeMillis();  // We are working with Milliseconds.
        this.run = true;
    }

    // Stopwatch stop function.
    public void stop(){
        this.stoptime = System.currentTimeMillis();
        this.run = false;
    }

    // Elapsed time function.
    public double elapsedtime(){
        double elapsed;
        if(run){
            elapsed = ((System.currentTimeMillis() - starttime) / 1000); // converting milliseconds to seconds.
        }
        else{
            elapsed = ((stoptime - starttime) / 1000);
        }
        return elapsed;
    }

    private static boolean check(){
        if((phoneNo[2] == '0' || phoneNo[2]== '1' || phoneNo[2] == '2' || phoneNo[2] == '4' || phoneNo[2] == '5' ||  phoneNo[2] == '6' || phoneNo[2] == '8'|| phoneNo[2] == '9') && phoneNo[1] == '7'){
            System.out.println("This net");
            return true;
        }else{
            System.out.println("Other Net");
            return false;
        }
    }
// Main function.

    public static void main(String[] args){

        String a = JOptionPane.showInputDialog("Enter phone number.");
        phoneNo = a.toCharArray();

       int choice = Integer.parseInt(a);

        // Gregorian calendar to get current time .
        Calendar cal = GregorianCalendar.getInstance();
        int time_of_day = cal.get(Calendar.HOUR_OF_DAY);
        try {
            if (check()) { // if the user is calling to the same line as his, i have assumed he/she knows the network they are calling to.

                //time check
                if (time_of_day >= 6 && time_of_day <= 17) { // from 6am to 6pm

                    Phonebill phone = new Phonebill(); // new object of the class phonebill.

                    int optiontype = JOptionPane.YES_NO_OPTION;
                    int result = JOptionPane.showConfirmDialog(null, "Start call ?" + optiontype);

                    if (result == JOptionPane.YES_OPTION) { //check if user has started call.
                        phone.start();
                    } else {
                        JOptionPane.showMessageDialog(null, "Simply, Simplicity!\n" +
                                "Goodbye.");
                        System.exit(1);
                    }

                    int optiontype2 = JOptionPane.YES_OPTION;
                    int result2 = JOptionPane.showConfirmDialog(null, "call running...\n\n"
                            + "Stop call ?" + optiontype2);

                    if (result2 == JOptionPane.YES_OPTION) { // used to terminate the call.
                        phone.stop();
                    }

                    //calculating cost.
                    double duration = phone.elapsedtime(); // we call the method elapsed and pass it the object phone to get the duration.

                    if (duration > 120) { // 120 seconds represents 2 min

                        double tot = (duration * 0.0667); // Multiplying by the 0.0667 since it will amount to 4 shilling in 60 seconds i.e 1 min.
                        double tot2 = (0.16 * tot); // TAX.
                        double tot3 = tot + tot2;

                        JOptionPane.showMessageDialog(null, "PHONE BILLING SOLUTIONS!!!\n" +
                                "Mini statement ,\n\n\n" +
                                "The call lasted for " + duration + " seconds\n\n" +
                                String.format("% 2f", (duration / 60.0)) + " minutes.\n\n" +
                                "Total cost is " + String.format("% 2f", tot3) + " KES.\n\n\n"
                                + "Simply, Simplicity!\n"
                                + "T's & C's apply.");
                    } else {
                        double tot_norm = (duration * 0.0667);
                        JOptionPane.showMessageDialog(null, "PHONE BILLING SOLUTIONS!!!\n" +
                                "Mini statement ,\n\n\n" +
                                "The call lasted for " + duration + " seconds\n\n" +
                                String.format("% 2f", duration / 60.0) + " minutes.\n\n" +
                                "Total cost is " + String.format("% 2f", tot_norm) + " KES.\n\n\n"
                                + "Simply, Simplicity!\n"
                                + "T's & C's apply.");
                    }


                }// endif time_of_day

                // now to cater for 6pm to 6am . Night call.

                else {
                    Phonebill phone2 = new Phonebill(); // new object of the class phonebill.

                    JOptionPane.showInputDialog("Enter the number."); // destination number.

                    int optiontype3 = JOptionPane.YES_NO_OPTION;
                    int result2 = JOptionPane.showConfirmDialog(null, "Start call?" + optiontype3);

                    if (result2 == JOptionPane.YES_OPTION) {
                        phone2.start();
                    } else {
                        JOptionPane.showMessageDialog(null, "Simply, Simplicity!\n" +
                                "Goodbye.");
                        System.exit(1);
                    }

                    int optiontype4 = JOptionPane.YES_OPTION;
                    int result3 = JOptionPane.showConfirmDialog(null, "call running...\n\n"
                            + "Stop call ?" + optiontype4);
                    if (result3 == JOptionPane.YES_OPTION) {
                        phone2.stop();
                    }

                    //calculating cost.
                    double duration1 = phone2.elapsedtime();
                    if (duration1 > 120) { // 120seconds represents 2 min

                        double tot = (duration1 * 0.05); // Multiplying by the 0.05 since it will amount to 3 shillings in 60 seconds i.e 1 min.
                        double tot2 = (0.16 * tot); // TAX.
                        double tot3 = tot + tot2;

                        JOptionPane.showMessageDialog(null, "PHONE BILLING SOLUTIONS!!!\n" +
                                "Mini statement ,\n\n\n" +
                                "The call lasted for " + duration1 + " seconds\n\n" +
                                String.format("% 2f", (duration1 / 60.0)) + " minutes.\n\n" +
                                "Total cost is " + String.format("% 2f", tot3) + " KES.\n\n"
                                + "Simply, Simplicity!\n"
                                + "T's & C's apply.");
                    } else {
                        double tot_norm = (duration1 * 0.05);
                        JOptionPane.showMessageDialog(null, "PHONE BILLING SOLUTIONS!!!\n" +
                                "Mini statement ,\n\n\n" +
                                "The call lasted for " + duration1 + " seconds\n\n" +
                                String.format("% 2f", (duration1 / 60.0)) + " minutes.\n\n" +
                                "Total cost is " + String.format("% 2f", tot_norm) + " KES.\n\n\n"
                                + "Simply, Simplicity!\n"
                                + "T's & C's apply.");
                    }


                } // end else

            }//endif choice
        }catch(Exception e){
            JOptionPane.showMessageDialog(null,"Invalid Phone No", "Error", JOptionPane.OK_OPTION);
        }

        if(choice==2){ // if the user is calling to another network other than his,
            // i have assumed he/she knows the network they are calling to.

            Phonebill phone3 = new Phonebill();

            JOptionPane.showInputDialog("Enter the number."); // destination number.

            int optiontype = JOptionPane.YES_NO_OPTION;
            int result =  JOptionPane.showConfirmDialog(null, "Start call?" + optiontype);

            if (result == JOptionPane.YES_OPTION){
                phone3.start();
            }
            else{
                JOptionPane.showMessageDialog(null,"Simply, Simplicity!\n"
                        + "Goodbye.");
                System.exit(1);
            }

            int optiontype2 = JOptionPane.YES_OPTION;
            int result2 = JOptionPane.showConfirmDialog(null, "call running...\n\n"
                    + "Stop call ?" + optiontype2);
            if (result2 == JOptionPane.YES_OPTION){
                phone3.stop();
            }

            //calculating cost.

            double duration = phone3.elapsedtime();

            if (duration > 120){ // 120seconds represents 2 min

                double tot = (duration*0.0833); ; // Multiplying by the 0.0833 since it will amount to 5 shillings in 60 seconds i.e 1 min.
                double tot2 = (0.16*tot); // TAX.
                double tot3 = tot + tot2;

                JOptionPane.showMessageDialog(null, "PHONE BILLING SOLUTIONS!!!\n" +
                        "Mini statement ,\n\n\n" +
                        "The call lasted for " + duration+ " seconds\n\n" +
                        String.format("% 2f",(duration/60.0)) + " minutes.\n\n" +
                        "Total cost is " + String.format("% 2f",tot3) + " KES.\n\n\n" +
                        "Simply, Simplicity! \n"
                        + "T's & C's apply." );
            }

            else{
                double tot_norm = (duration*0.0833);
                JOptionPane.showMessageDialog(null, "PHONE BILLING SOLUTIONS!!!\n" +
                        "Mini statement ,\n\n\n" +
                        "The call lasted for " + duration+ " seconds\n\n" +
                        String.format("% 2f",(duration/60.0)) + " minutes.\n\n" +
                        "Total cost is " + String.format("% 2f",tot_norm) + " KES.\n\n\n"
                        + "Simply Simplicity !\n"
                        + "T's & C's apply." );
            }



        }// endif time_of_day


    }//end main

}//end class