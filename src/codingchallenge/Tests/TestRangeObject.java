package codingchallenge.Tests;

import codingchallenge.RangeObject;

/**
 *Tests constructors, the length parameter, and overlap and merge 
 * methods on RangeObject objects.  This was used for early stage testing.
 * 
 * @author Thomas Hodges
 */
public class TestRangeObject {

    /**
     *Creates three RangeObjects, get's their length, finds out which
     * overlap and generates a new RangeObject by merging two of the
     * old
     * 
     * @param args an environment rariable in a java 'main' method
     */
    public static void main(String[] args){
        RangeObject range1 = new RangeObject(94133,94133);
        RangeObject range2 = new RangeObject(94200, 94299);
        RangeObject range3 = new RangeObject(94226, 94399);
        
        System.out.println(range1 +" length:" + range1.getLength());
        System.out.println(range2 +" length:" + range2.getLength());
        System.out.println(range3 +" length:" + range3.getLength());
        
        System.out.println("1 and 2 overlap? " + range1.overlap(range2));
        System.out.println("2 and 3 overlap? " + range2.overlap(range3));
        
        System.out.println("merge 2 and 3: " + range2.merge(range3));
    }
    
}
