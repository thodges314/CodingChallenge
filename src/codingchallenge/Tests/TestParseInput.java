package codingchallenge.Tests;
import codingchallenge.*;

/**
 *Holds a method used to test input parsing methods.  Sends first a
 * string, then an array of strings to the overloaded parseInput function tnad
 * idsplays the results in the terminal.  There ranges will be condensed as a
 * consequence of that action
 * 
 * @author Thomas Hodges
 */
public class TestParseInput {

    /**
     *sends two input types to parseInput and displays the results
     * 
     * @param args an environment rariable in a java 'main' method
     */
    public static void main(String[] args){
        RangeSet testSet = ParseInput.parseInput("[94133,94133] [94200,94299] [94226,94339]");
        System.out.println(testSet);
        
        String[] inputArray = {"[94133,94133]","[94200,94299]"," [94226,94339]"};
        testSet = ParseInput.parseInput(inputArray);
        System.out.println(testSet);
    }
    
}
