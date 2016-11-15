/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingchallenge;

/**
 *
 * @author thodges
 */
public class ParseInput {
    public static RangeSet parseInputString(String inputString){
        String[] splitStrings = inputString.split("\\]\\s*\\[");
        splitStrings[0] = splitStrings[0].replaceAll("\\s*\\[", "");
        splitStrings[splitStrings.length-1] = 
                splitStrings[splitStrings.length-1].replaceAll("\\]\\s*", "");
        
        RangeSet returnSet = new RangeSet();
        for(String pair: splitStrings){
            String[] splitPair = pair.split("\\,\\s*");
            returnSet.addRange(new RangeObject(Integer.parseInt(splitPair[0]),
                    Integer.parseInt(splitPair[1])));
        }
        return returnSet;
    }
    
    public static RangeSet parseInputArray(String[] inputStringsArray){
        RangeSet returnSet = new RangeSet();
        for(String pair: inputStringsArray){
            pair = pair.replaceAll("(\\s*\\[|\\]\\s*)", "");
            String[] splitPair = pair.split("\\,\\s*");
            returnSet.addRange(new RangeObject(Integer.parseInt(splitPair[0]),
                    Integer.parseInt(splitPair[1])));
        }
        return returnSet;
    }
    
}
