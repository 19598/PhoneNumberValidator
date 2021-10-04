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
        String[] phoneNumbers = {"(419)123-4567", "(419) 123-4567", "419-123-4567", "419.123.4567", "419_123_4567", "(419)123-456", "4191234567", "419123456"};//list of phone numbers
        Pattern expression = Pattern.compile("[(]([0-9]{3})[)]([0-9]{3})-([0-9]{4})|[(]([0-9]{3})[)] ([0-9]{3})-([0-9]{4})|([0-9]{3})-([0-9]{3})-([0-9]{4})|([0-9]{3})[.]([0-9]{3})[.]([0-9]{4})");//pattern
        Matcher myMatcher;
        
        for (String phoneNumber : phoneNumbers) {
            myMatcher = expression.matcher(phoneNumber);
            if (myMatcher.matches()) {
                int offset = 0;
                if (myMatcher.group(1) != null) {
                    offset = 0;
                }
                else if (myMatcher.group(4) != null) {
                    offset = 3;
                }
                else if (myMatcher.group(7) != null) {
                    offset = 6;
                }
                else {
                    offset = 9;
                }
                System.out.println("(" + myMatcher.group(1 + offset) + ") " + myMatcher.group(2 + offset) + "-" + myMatcher.group(3 + offset));
            }
        }
    }
    
}
