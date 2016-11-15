/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codingchallenge.Tests;
import codingchallenge.RangeObject;
import codingchallenge.RangeSet;

/**
 *
 * @author thodges
 */
public class TestRangeSet {
    public static void main(String[] args) {
        RangeSet rangeSet = new RangeSet();
        rangeSet.addRange(new RangeObject(94133,94133));
        rangeSet.addRange(new RangeObject(94200,94299));
        rangeSet.addRange(new RangeObject(94226,94399));
        rangeSet.addRange(new RangeObject(94133,94133));
        rangeSet.addRange(new RangeObject(94130,94135));
        rangeSet.addRange(new RangeObject(94200,94399));
        System.out.println(rangeSet);
    }
    
}
