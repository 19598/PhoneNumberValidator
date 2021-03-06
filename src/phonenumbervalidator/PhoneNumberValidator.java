/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phonenumbervalidator;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

/**
 *
 * @author bdegryse
 */
public class PhoneNumberValidator {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length > 0) {
            String[] phoneNumbers = {"(419)123-4567", "(419) 123-4567", "419-123-4567", "419.123.4567", "419_123_4567", "(419)123-456", "4191234567", "419123456"};//list of phone numbers
            Pattern expression = Pattern.compile("[(]([0-9]{3})[)]([0-9]{3})-([0-9]{4})|[(]([0-9]{3})[)] ([0-9]{3})-([0-9]{4})|([0-9]{3})-([0-9]{3})-([0-9]{4})|([0-9]{3})[.]([0-9]{3})[.]([0-9]{4})");//pattern
            Matcher myMatcher;

            //loop through the numbers and test them
            for (String phoneNumber : phoneNumbers) {
                myMatcher = expression.matcher(phoneNumber);
                if (myMatcher.matches()) {
                    int offset = 1;
                    //find the first number
                    while (myMatcher.group(offset) == null) {
                        offset++;
                    }
                    //print the number in the requested format
                    System.out.println("(" + myMatcher.group(offset) + ") " + myMatcher.group(1 + offset) + "-" + myMatcher.group(2 + offset));
                }
                else {
                    System.out.println(phoneNumber + " is not a valid phonenumber.");
                }
            }
        }
        else {
            System.out.println("No arguments given.");
        }
    }
    
}
