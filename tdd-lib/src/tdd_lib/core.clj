(ns tdd-lib.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (println "Hello, World!"))

(defn b [a](reverse (reduce (fn [c d] (conj c (+ (first c) (second c)))) '(1 1) (range 1 (- a 1))))
  )


(defn b1 [a]
  (if (string? a)
    (= (apply str (reverse a)) a)
    (= (reverse a) a)))


(defn my-print [n l]
  (mapcat (fn [a] (map (fn [] a) (range n)) )l))





(defn h [l]
(first(list(clojure.string/join (filter #(Character/isUpperCase %) l)))))


(defn my-map [f a]
  (if (empty? a)
    a
    (conj (my-map f (rest a)) (f (first a)))))


(defn my-comp
  [& a]
  (fn [& args]
    (my-comp1 (apply (last a) args) (drop-last a))))

(defn my-comp1
  [b c]
  (if (empty? c)
    b
    (my-comp1 ((last c) b ) (drop-last c))))


(defn my-reduce [f acc a]
  (if (empty? a)
    acc
    (my-reduce (f (f acc (first a)) (rest a) ))))


(defn my-take [a b]
  (if (> a (count b))
    b
    (if(> a 0)
      (conj (my-take (dec a)(rest b)) (first b))
      '()
      )))

(defn my-drop [a b]
  (if (> a (count b))
    '()
    (if-not (zero? a)
      (reverse(conj (my-take (dec(- (count b) a))(rest b)) (last b))))))


(defn my-takewhile [a b]
  (if (a (first b))
    (conj (my-take a (rest b)) (first b))
    b
    ))


(defn my-dropwhile [a b]
  (if-not (true? (a (first b)))
    (reverse(conj (my-take  a (rest b)) (last b)))) )


(defn my-filter [a b]
  (if-not (empty? b)
    (if (true? (a (first b)))
      (conj (my-filter a (rest b)) (first b))
      (my-filter a (rest b)))))


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


(defn helper1 [f a]
  (if (empty? a)
    a
    (if (= (first a) f)
      (rest a)
      (cons (first a) (helper1 f (rest a))))))

(defn helper [b c]
  (if (empty? b)
    c
    (helper (helper1 (apply min b) b) (conj c (apply min b)))))

(defn my-sort1 [a]
  (helper a []))




(defn my-complement [f]
  (fn [& a]
    (not (apply f a))) )

(def not-empty (my-complement empty?) )

(not-empty [1 2 3])
(defn helper2 [out args]
  (if (empty? args)
    out
    (helper2   (into out (first args)) (rest args))))
(defn my-concat [& arr]
  (helper2 [] arr))





(defn my-hashmap [f a]
  (into [] (map f a))
  (apply map vector [a (into [] (map f a)) ]))












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
