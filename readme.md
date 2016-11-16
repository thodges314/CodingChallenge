
## CodingChallange

###goal
The goal of this project is that a shipper may be receiving ranges of five digit zip codes that they are not permitted to ship packages to.  These lists of ranges may come from various sources and may come in any order, and it is necessary to condense these lists into a single list that expresses forbidden zip codes in as few entries as possible.  For example, if one were to receive the following entries:

`[94133,94133] [94200,94299] [94226,94399]`

then the overlap between the second and third entry should be detected and the returned list should be:

`[94133,94133] [94200,94399]`

###strategy



