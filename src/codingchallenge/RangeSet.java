package codingchallenge;

import java.util.*;

/**
 * Extends TreeSet to provide an ordered set of RangeObjects. This does not
 * override any methods but provides additional methods to incorporate new
 * RangeObjects into the set without overlap.
 *
 * @author Thomas Hodges
 */
public class RangeSet extends TreeSet<RangeObject> {

    /**
     * to be used in place of add when adding RangeObjects to RangeSet. This
     * method calls the methods to iterate over the set of existing RangeObjects
     * to look for possible overlap, return a RangeSet of overlapping objects,
     * remove these objects from the set, merge the new RangeObject with the set
     * of overlapping RangeObjects and finally add the new merged object back
     * into the set.
     *
     * @param rangeObject the RangeObject to be added to the set
     * @return a boolean corresponding to successful addition of the new
     * RangeObject
     */
    public boolean addRange(RangeObject rangeObject) {
        RangeSet mergeSet = getMergeSet(rangeObject);
        if (!mergeSet.isEmpty()) {
            removeAll(mergeSet);
            rangeObject = mergeRangeSet(rangeObject, mergeSet);
        }
        return super.add(rangeObject);
    }

    private RangeSet getMergeSet(RangeObject rangeObject) {
        RangeSet returnSet = new RangeSet();
        for (RangeObject testObject : this) {
            if (rangeObject.overlap(testObject)) {
                returnSet.add(testObject);
            }
        }
        return returnSet;
    }

    private void removeAll(RangeSet removeSet) {
        for (RangeObject removeObject : removeSet) {
            this.remove(removeObject);
        }
    }

    private RangeObject
            mergeRangeSet(RangeObject rangeObject, RangeSet mergeSet) {
        for (RangeObject testObject : mergeSet) {
            rangeObject = rangeObject.merge(testObject);
        }
        return rangeObject;
    }

    public String toString() {
        String outString = "";
        for (RangeObject outObject : this) {
            outString += (outObject.toString() + " ");
        }
        return outString;
    }

}
