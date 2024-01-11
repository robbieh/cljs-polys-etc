
cljs-polys-etc
==============

Mostly this is for working with polybooljs in ClojureScript. Also provided are
some extra functions that I found useful while creating SVGs.



coordinates
-----------

```
[cljs-polys-etc "0.0.1"]
```

polybooljs
----------
The `polybooljs` library handles boolean operations on polygons. It has a conception
of a polygon as `regions` combined with an `inversion` flag. Which makes sense in
the case of taking the `difference` of polygons - the result might be two or more 
unconnected polygons.

usage suggestions
-----------------

Generally, the approach is:

* Create a polygon
* Rotate as needed
* Translate into position
* Encode as a string for the `:points` of an SVG `polygon`



