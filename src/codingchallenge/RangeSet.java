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
public class RangeSet extends TreeSet<RangeObject>{

    // overriding add method to check for possible merge
    public boolean addRange(RangeObject rangeObject){
        RangeSet mergeSet = getMergeSet(rangeObject);
        if(!mergeSet.isEmpty()){
            removeAll(mergeSet);
            rangeObject = mergeRangeSet(rangeObject, mergeSet);
        }          
        return super.add(rangeObject);
    }
    
    private RangeSet getMergeSet(RangeObject rangeObject) {
        RangeSet returnSet = new RangeSet();
        for (RangeObject testObject: this){
            if (rangeObject.overlap(testObject))
                returnSet.add(testObject);
        }
        return returnSet;
    }
    
    private void removeAll(RangeSet removeSet){
        for(RangeObject removeObject: removeSet){
            this.remove(removeObject);
        }
    }
    
    private RangeObject
        mergeRangeSet(RangeObject rangeObject, RangeSet mergeSet){
        for(RangeObject testObject: mergeSet){
            rangeObject = rangeObject.merge(testObject);
        }
        return rangeObject;
    }
    
}
