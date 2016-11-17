
## CodingChallenge

###goal
The goal of this project is that a shipper may be receiving ranges of five digit zip codes that they are not permitted to ship packages to.  These lists of ranges may come from various sources and may come in any order, and it is necessary to condense these lists into a single list that expresses forbidden zip codes in as few entries as possible.  For example, if one were to receive the following entries:

`[94133,94133] [94200,94299] [94226,94399]`

then the overlap between the second and third entry should be detected and the returned list should be:

`[94133,94133] [94200,94399]`

###strategy

####RangeObject
This was attacked by creating an object `RangeObject` to represent a single range of zip code values.  Each `RangeObject` has private members `high`, `low` and `length` representing the high and low range values and the length of the range (the number of zip codes in the range; these are set by the constructor, with length computed as `high-low+1`).  These have publicly exposed getter methods, but `RangeObject` is immutable so there are no setters.

The method of detecting overlap between any two `RangeObject` instances uses a variation on the Triangle Inequality which states that the sum of the lengths of any two sides of a triangle must be less than the length of the third side.  By finding the distance between the extremes of any two `RangeObject`s, the lowest of their low values and the highest of their high values, and comparing that distance to the sum of the lengths of the two objects, it's determined that only if this combined range is less than or equal to the two summed ranges that the ranges overlap.

Consider the second and third entry in the example above: the number of zip codes between the lowest of the low values, 94200, and the highest of the high values, 94399 is *94399-94200+1 = 200*.  The lengths of each of the two zip code ranges are *100* and *174* respectively.  *174+100=274* and *274 >= 200* so there must be some overlap.  Note that this method also works when one range completely surrounds another, or when two ranges touch end to end.

`RangeObject` also contains a `merge` method which receives another `RangeObject` and returns a new `RangeObject` made of the two objects merged together.

####RangeSet
It was decided that the best way to look for overlaps and where needed merge a large number of `RangeObject`s would be to add them one by one to a set, and when each object is added, to compare it with all of the existing objects and perform any required merges.  This is an easier strategy than trying to coordinate a cross-compare of a large number of objects all at one time and means that in the future new `RangeObject`s can be quickly added to the set as they come in.

To accomplish this task, I created `RangeSet` which extends `TreeSet`.  I choose `TreeSet` because it implements the `SortedSet` interface and because of it's considerably faster performance than `ArrayList`.  In order to meet the comaparability requiement for `TreeSet`, I made `RangeObject` comparable via it's lower bound, the thought being that this should be acceptable for completely non-overlapping ranges.
In `RangeSet`, rather than overriding the `add` method, I created a new `addRange` method.  This method uses the following steps to add a `RangeObject` to the set:

1. create a `RangeSet` called `mergeSet` which contains any entries in the existing set that the new `RangeObject` overlaps

2. remove all entries that are also in `mergeSet`.

3. iterate the new `RangeObject` over the entries in `mergeSet`, merging them all into one large `RangeObject`.  The object being added to the set is redefined as this new merged obect.

4. add the new `RangeObject` to the `RangeSet`.

Should the `mergeSet` in step 1 be empty, we jump straight from there to step 4.

###Implementation and Use
The original version of this project operated entirely on the command line.  You could either provide your input as a list of parameters when calling the program, or you could call the program and enter the parameters.  This also allowed data to be piped in from a file.

After completing this goal I decided to move to a graphical interface as the primary interface.  You can still call the program with a list of parameters, and even pipe the output to a file if you like, however the graphical interface is the encouraged use.

Run `CodingChallenge` by navigating to the `dist` directory and typing:

`java -jar CodingChallenge.jar`

You will be presented with an interface where you can enter lists of ranges and condense them.

![](http://i63.tinypic.com/xgeba1.png)

Via the `file` menu it is possible to open files and have their contents loaded into the *original* frame, or to save the contents of the *condensed* frame to a new file.
Presently errors are presented as an alert dialog with the stackTrace of the offending exception.  This causes some problems using this program via the command line as I have not been able to find a reliable way of detecting whether *javafx* is running, so bad data received on the command line will throw an error about being unable to throw an error.

However, if you would like to run this from the command line, simply provide your data after the command.  As demonstrated below, the output is presented without decoration, making it possible to be piped directly into an output file in usable format.

![](http://i64.tinypic.com/71gwlu.png)
