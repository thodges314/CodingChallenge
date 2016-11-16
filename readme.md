
## CodingChallange

###goal
The goal of this project is that a shipper may be receiving ranges of five digit zip codes that they are not permitted to ship packages to.  These lists of ranges may come from various sources and may come in any order, and it is necessary to condense these lists into a single list that expresses forbidden zip codes in as few entries as possible.  For example, if one were to receive the following entries:

`[94133,94133] [94200,94299] [94226,94399]`

then the overlap between the second and third entry should be detected and the returned list should be:

`[94133,94133] [94200,94399]`

###strategy

####RangeObject
This was attacked by creating an object `RangeObject` to represent a single range of zip code values.  Each RangeObject has private members `high`, `low` and `length` representing the high and low range values and the length of the range (the number of zip codes int he range.  These are set by the constructor, with length computed as `high-low+1`.  These have publicly exposed getter methods, but `RangeObject` is immutable so there are no setters.
The method of detecting overlap between any two `RangeObject` instances uses a variation on the Triangle Inequality Which states that the sum of the lengths of any two sides of a triangle must be less than the length of the third side.  By finding the distance betweeen the extremes of any two RangeObjects, the lowest of their low values and the highest of their high values, and comparing that distance to the sum of the lengths of the two objects, it's determined that only if this combined range is less than or equal to the two summed ranges that the ranges overlap.
Consider the second and third entry in the example above: the number of zip codes between the lowest value, 94200, and the highest value, 94399 is *94399-94200+1 = 200*.  The lengths of each of the two zip code ranges are *100* and *174* respectively.  *174+100=274* and *274 >= 200* so there must be some overlap.  Note that this method also works when one range completely surrounds another, or when two ranges touch end to end.
`RangeObject` also contains a `merge` method which receives another `RangeObject` and returns a new `RangeObject` made of the two objects merged together.

####RangeSet



