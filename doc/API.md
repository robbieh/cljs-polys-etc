# Table of contents
-  [`cljs-polys-etc.polys`](#cljs-polys-etc.polys)  - Functions for working with polygons in SVG.
    -  [`arc-len-degrees`](#cljs-polys-etc.polys/arc-len-degrees) - Returns the length of an arc with given theta (degrees) and radius.
    -  [`arc-len-radians`](#cljs-polys-etc.polys/arc-len-radians) - Returns the length of an arc with given theta (radians) and radius.
    -  [`degrees-to-radians`](#cljs-polys-etc.polys/degrees-to-radians) - Converts degrees to radians.
    -  [`difference`](#cljs-polys-etc.polys/difference) - Returns a vector of polys that is the difference of two polys.
    -  [`equilateral-height`](#cljs-polys-etc.polys/equilateral-height) - Returns height of an equilateral triangle with given side length.
    -  [`equilateral-inradius`](#cljs-polys-etc.polys/equilateral-inradius) - Returns the inner radius of an equilateral triangle with given side length.
    -  [`equilateral-sidelen`](#cljs-polys-etc.polys/equilateral-sidelen) - Returns the side length of an equilateral triangle with given height.
    -  [`intersection`](#cljs-polys-etc.polys/intersection) - Returns a vector of polys that is the intersection of two polys.
    -  [`polar-to-cartesian`](#cljs-polys-etc.polys/polar-to-cartesian) - Converts a point in polar space to cartesian space.
    -  [`poly2path`](#cljs-polys-etc.polys/poly2path) - Converts a poly into a string suitable for using in an SVG <code>:polygon</code>'s <code>:point</code> attribute.
    -  [`rotate-point`](#cljs-polys-etc.polys/rotate-point) - Rotates a point around [0,0] by given degrees.
    -  [`rotate-poly`](#cljs-polys-etc.polys/rotate-poly) - Rotates all points in poly around [0,0] by given degrees.
    -  [`sqrt3`](#cljs-polys-etc.polys/sqrt3)
    -  [`translate-point`](#cljs-polys-etc.polys/translate-point) - Translates a point by <code>xd</code>, <code>yd</code>.
    -  [`translate-poly`](#cljs-polys-etc.polys/translate-poly) - Translates all points in a poly by <code>xd</code>, <code>yd</code>.
    -  [`translate-polys`](#cljs-polys-etc.polys/translate-polys) - Translates all polys in a vector of polys.
    -  [`union`](#cljs-polys-etc.polys/union) - Returns a vector of polys that is the union of two polys.

-----
# <a name="cljs-polys-etc.polys">cljs-polys-etc.polys</a>


Functions for working with polygons in SVG. This library requires `polybooljs` to work.

  The notion of a polygon here is just a vector of points in cartesian space, e.g.
  ```
  (def a-square [[0 0] [10 0] [10 10] [0 10]])
  ```

  The polybooljs library has a more complex idea of what a polygon is [<https://sean.cm/a/polygon-clipping-pt2],
  which means a vector of with multiple regions and an `inverted?` flag. Cljs-polys-etc is not
  that complex (yet). The `inverted?` tag remains unimplemented.
  




## <a name="cljs-polys-etc.polys/arc-len-degrees">`arc-len-degrees`</a><a name="cljs-polys-etc.polys/arc-len-degrees"></a>
``` clojure

(arc-len-degrees theta radius)
```

Returns the length of an arc with given theta (degrees) and radius.
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L29-L33">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/arc-len-radians">`arc-len-radians`</a><a name="cljs-polys-etc.polys/arc-len-radians"></a>
``` clojure

(arc-len-radians theta radius)
```

Returns the length of an arc with given theta (radians) and radius.
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L24-L27">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/degrees-to-radians">`degrees-to-radians`</a><a name="cljs-polys-etc.polys/degrees-to-radians"></a>
``` clojure

(degrees-to-radians degrees)
```

Converts degrees to radians. 
  0 radians usually 'point right' and the resulting degrees will also have 0 'pointing right.'
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L18-L22">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/difference">`difference`</a><a name="cljs-polys-etc.polys/difference"></a>
``` clojure

(difference poly1 poly2)
```

Returns a vector of polys that is the difference of two polys.
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L58-L64">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/equilateral-height">`equilateral-height`</a><a name="cljs-polys-etc.polys/equilateral-height"></a>
``` clojure

(equilateral-height sidelen)
```

Returns height of an equilateral triangle with given side length.
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L102-L103">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/equilateral-inradius">`equilateral-inradius`</a><a name="cljs-polys-etc.polys/equilateral-inradius"></a>
``` clojure

(equilateral-inradius sidelen)
```

Returns the inner radius of an equilateral triangle with given side length.
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L106-L107">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/equilateral-sidelen">`equilateral-sidelen`</a><a name="cljs-polys-etc.polys/equilateral-sidelen"></a>
``` clojure

(equilateral-sidelen height)
```

Returns the side length of an equilateral triangle with given height.
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L104-L105">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/intersection">`intersection`</a><a name="cljs-polys-etc.polys/intersection"></a>
``` clojure

(intersection poly1 poly2)
```

Returns a vector of polys that is the intersection of two polys.
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L50-L56">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/polar-to-cartesian">`polar-to-cartesian`</a><a name="cljs-polys-etc.polys/polar-to-cartesian"></a>
``` clojure

(polar-to-cartesian cx cy radius degrees)
```

Converts a point in polar space to cartesian space.
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L35-L40">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/poly2path">`poly2path`</a><a name="cljs-polys-etc.polys/poly2path"></a>
``` clojure

(poly2path poly)
```

Converts a poly into a string suitable for using in an SVG `:polygon`'s `:point` attribute.
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L66-L69">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/rotate-point">`rotate-point`</a><a name="cljs-polys-etc.polys/rotate-point"></a>
``` clojure

(rotate-point [x y] degrees)
```

Rotates a point around [0,0] by given degrees.
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L81-L90">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/rotate-poly">`rotate-poly`</a><a name="cljs-polys-etc.polys/rotate-poly"></a>
``` clojure

(rotate-poly poly degrees)
```

Rotates all points in poly around [0,0] by given degrees.
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L92-L95">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/sqrt3">`sqrt3`</a><a name="cljs-polys-etc.polys/sqrt3"></a>



<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L16-L16">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/translate-point">`translate-point`</a><a name="cljs-polys-etc.polys/translate-point"></a>
``` clojure

(translate-point [x y] xd yd)
```

Translates a point by `xd`, `yd`.
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L71-L74">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/translate-poly">`translate-poly`</a><a name="cljs-polys-etc.polys/translate-poly"></a>
``` clojure

(translate-poly poly xd yd)
```

Translates all points in a poly by `xd`, `yd`.
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L76-L79">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/translate-polys">`translate-polys`</a><a name="cljs-polys-etc.polys/translate-polys"></a>
``` clojure

(translate-polys polys x y)
```

Translates all polys in a vector of polys.
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L97-L100">Source</a></sub></p>

## <a name="cljs-polys-etc.polys/union">`union`</a><a name="cljs-polys-etc.polys/union"></a>
``` clojure

(union poly1 poly2)
```

Returns a vector of polys that is the union of two polys.
<p><sub><a href="/blob/master/src/cljs_polys_etc/polys.cljs#L42-L48">Source</a></sub></p>
