/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingchallenge.Tests;
import codingchallenge.*;

/**
 *
 * @author thodges
 */
public class TestParseInput {
    public static void main(String[] args){
        RangeSet testSet = ParseInput.parseInputString("[94133,94133] [94200,94299] [94226,94339]");
        System.out.println(testSet);
        
        String[] inputArray = {"[94133,94133]","[94200,94299]"," [94226,94339]"};
        testSet = ParseInput.parseInputArray(inputArray);
        System.out.println(testSet);
    }
    
}