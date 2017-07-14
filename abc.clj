
(fn [x]
 (map (fn [y](conj () y)) x))


(fn fib [a]
 (if (> a 0)
  (do  (conj (+ (fib [(- a 1)]) (fib [(- a 2)])) '())
    (recur (dec a))
  ))
  )



(fn fib [b]

  (let n (vec(repeat b 0)))
  (let [(first n) 1])
  (reductions + 1 n)
  )






(defn b [a](reverse (reduce (fn [c d] (conj c (+ (first c) (second c)))) '(1 1) (range 1 (- a 1))))
)


(defn b [a]
 (if (string? a)
(= (apply str (reverse a)) a)
(= (reverse a) a)))








(defn flatten [i]
(let [h (first i)
     t (rest i)]

(concat (if(coll? h)
(map flatten h)
'(h)
)
(flatten t)
)))

(mapcat(fn [l]
(if (coll? l)
(mapcat flat l)
[l]
))l)


  (fn [l]
    (mapcat
(fn flat [x]
(if (coll? x)
(mapcat flat x)
[x]))
  l))


(fn h [l]
(first(list(clojure.string/join (filter #(Character/isUpperCase %) l)))))


(defn my-map [f a]
  (if (empty? a)
    a
    (conj (my-map f (rest a)) (f (first a)))))




(defn my-reduce [f acc a]
  (if (empty? a)
    acc
    (my-reduce (f (f acc (first a)) (rest a) ))))


(defn my-take [a b]
  (if (> a (count b))
    b
    (if-not (zero? a)
      (conj (my-take (dec a)(rest b)) (first b))
      )))

(defn my-drop [a b]
  (if (> a (count b))
    '()
    (if-not (zero? a)
      (reverse(conj (my-take (dec(- (count b) a))(rest b)) (last b))))))


(defn my-takewhile [a b]
  (if (a (first b))
    (conj (my-take1 a (rest b)) (first b))
    b
    ))


(defn my-dropwhile [a b]
  (if-not (true? (a (first b)))
    (reverse(conj (my-take  a (rest b)) (last b)))
    )
  )


(defn my-filter [a b]
  (if-not (empty? b)
    (if (true? (a (first b)))
      (conj (my-filter a (rest b)) (first b))
      (my-filter a (rest b))))
  )



(defn my-some [a b]
  (if-not (empty? b)
    (if (a (first b))
      true
      (my-some a (rest b)))
    ))

(defn my-sort [a]
  (if(= (count a) 1)
    a
      (conj (my-sort (rest a)) (apply min a))))


(defn my-sort1 [a]
  (helper a []))

(defn helper [b c]
  (if (empty? b)
    c
    (helper (helper1 (apply min b) b) (conj c (apply min b)))
    ))



(defn helper1 [f a]
  (if (empty? a)
    a
    (if (= (first a) f)
      (rest a)
      (cons (first a) (helper1 f (rest a))))))

(defn my-complement [f]
  (fn [& a]
    (not (apply f a))) )

(def not-empty (my-complement empty?) )

(not-empty [1 2 3])

(defn my-concat [& arr]
  (helper2 [] arr))

(defn helper2 [out args]
  (if (empty? args)
    out
    (helper2   (into out (first args)) (rest args))))



(defn my-hashmap [f a]
  (into [] (map f a))
  (apply map vector [a (into [] (map f a)) ]))



(defn helper-4 [e]
  (min-by e []))








(defn h-map [arr marr hmap]
  (if (empty? marr)
    hmap
    (recur (rest arr) (rest marr) (conj hmap (vector (first arr) (first marr))))))

(defn f1 [f arr]
  (sort-by (h-map arr (map f arr) []) []))



(defn min-by
  ([arr] (min-by (rest arr) (first arr)))
  ([arr min]
   (if (empty? arr)
     min
     (min-by (rest arr) (if (< (second (first arr)) (second min))
                          (first arr)
                          min )) )))

(defn remove-by [arr min]
  (vec (concat (subvec arr 0 (.indexOf arr min)) (subvec arr (inc (.indexOf arr min))))))


(defn sort-by [arr my-arr]
  (if (empty? arr)
    my-arr
    (sort-by (remove-by  arr (min-by arr)) (conj my-arr (first (min-by arr))))))
