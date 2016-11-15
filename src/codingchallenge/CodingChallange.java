/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingchallenge;
import java.util.*;

/**
 *
 * @author thodges
 */
public class CodingChallange {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        if (args.length != 0){
            displayRanges(ParseInput.parseInputArray(args));
        } else {
            Scanner myInput = new Scanner(System.in);
            myInput.useDelimiter("\n");
            String rangeData = myInput.next();
            displayRanges(ParseInput.parseInputString(rangeData));
        }
    }
    
    private static void displayRanges(RangeSet rangeSet) {
        for(RangeObject rangeObject : rangeSet)
            System.out.print(rangeObject + " ");
        System.out.println();
    }
    
}
