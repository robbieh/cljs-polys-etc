(ns cljs-polys-etc.polys
  "Functions for working with polygons in SVG. This library requires `polybooljs` to work.

  The notion of a polygon here is just a vector of points in cartesian space, e.g.
  ```
  (def a-square [[0 0] [10 0] [10 10] [0 10]])
  ```

  The polybooljs library has a more complex idea of what a polygon is [<https://sean.cm/a/polygon-clipping-pt2],
  which means a vector of with multiple regions and an `inverted?` flag. Cljs-polys-etc is not
  that complex (yet). The `inverted?` tag remains unimplemented.
  "
  (:require 
    [polybooljs :as pbjs]))

(def sqrt3 (js/Math.sqrt 3)) 

(defn degrees-to-radians 
  "Converts degrees to radians. 
  0 radians usually 'point right' and the resulting degrees will also have 0 'pointing right.'"
  [degrees]
  (* degrees (/ js/Math.PI 180)))

(defn arc-len-radians 
  "Returns the length of an arc with given theta (radians) and radius."
  [theta radius]
  (* theta radius))

(defn arc-len-degrees 
  "Returns the length of an arc with given theta (degrees) and radius."
  [theta radius]
  (-> (/ theta 360)
     (* 2 js/Math.PI radius)))

(defn polar-to-cartesian
  "Converts a point in polar space to cartesian space."
  [cx cy radius degrees]
  (let [radians (degrees-to-radians degrees)]
    [(+ cx (* radius (js/Math.cos radians)))
     (+ cy (* radius (js/Math.sin radians)))]))

(defn union 
  "Returns a vector of polys that is the union of two polys."
  [poly1 poly2]
  (let [jspoly1 (clj->js {:regions [poly1] :inverted false})
        jspoly2 (clj->js {:regions [poly2] :inverted false})]
  (-> (pbjs/union jspoly1 jspoly2) js->clj (get "regions") first)
  ))

(defn intersection 
  "Returns a vector of polys that is the intersection of two polys."
  [poly1 poly2]
  (let [jspoly1 (clj->js {:regions [poly1] :inverted false})
        jspoly2 (clj->js {:regions [poly2] :inverted false})]
  (-> (pbjs/intersection jspoly1 jspoly2) js->clj (get "regions") first)
  ))

(defn difference 
  "Returns a vector of polys that is the difference of two polys."
  [poly1 poly2]
  (let [jspoly1 (clj->js {:regions [poly1] :inverted false})
        jspoly2 (clj->js {:regions [poly2] :inverted false})]
  (-> (pbjs/difference jspoly1 jspoly2) js->clj (get "regions") first)
  ))

(defn poly2path 
  "Converts a poly into a string suitable for using in an SVG `:polygon`'s `:point` attribute."
  [poly]
    (apply str (interpose " " (flatten poly))))

(defn translate-point 
  "Translates a point by `xd`, `yd`."
  [[x y] xd yd]
  [(+ x xd) (+ y yd)])

(defn translate-poly 
  "Translates all points in a poly by `xd`, `yd`."
  [poly xd yd ]
  (mapv #(translate-point % xd yd) poly))

(defn rotate-point 
  "Rotates a point around [0,0] by given degrees."
  [[x y] degrees]
  (let [radians (degrees-to-radians degrees)
        cos     (js/Math.cos radians)
        sin     (js/Math.sin radians) 
        xr      (+ (* cos x) (* sin y))
        yr      (- (* cos y) (* sin x))
        ]
    [xr yr]))

(defn rotate-poly 
  "Rotates all points in poly around [0,0] by given degrees."
  [poly degrees]
  (mapv #(rotate-point % degrees) poly))

(defn translate-polys 
  "Translates all polys in a vector of polys."
  [polys x y]
  (mapv #(translate-poly % x y) polys))

(defn equilateral-height "Returns height of an equilateral triangle with given side length."
  [sidelen] (/ (* sidelen sqrt3) 2))
(defn equilateral-sidelen "Returns the side length of an equilateral triangle with given height."
  [height] (/ (* 2 height) sqrt3))
(defn equilateral-inradius "Returns the inner radius of an equilateral triangle with given side length."
  [sidelen] (/ (* sqrt3 sidelen) 6))
