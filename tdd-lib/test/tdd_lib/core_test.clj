(ns tdd-lib.core-test
  (:require #_[clojure.test :refer :all]
            [tdd-lib.core :refer :all]
            [expectations :as expect]))

#_(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 1))))


(expect/expect [true false true] (my-map even? [2 5 4] ))

#_(expect/expect [-2 -1] (my-takewhile neg? '(-2 -1 0)))

(expect/expect [1 3] (my-filter odd? [1 2 3]))

(expect/expect nil (my-filter odd? [2 4]))

(expect/expect true (my-some odd? [1 2]))

(expect/expect nil (my-some nil? [1 2 3]))

(expect/expect '(2 4 6 8) (my-filter even? [2 4 6 8 9]))

(expect/expect nil (my-filter even? [1 3 5]))

(expect/expect [1 2] (my-take 2 [1 2 3 4]))

(expect/expect [1 2 3 4] (my-take 5 [1 2 3 4]))

(expect/expect [1 2 3] (my-take 3 [1 2 3 4 5]))

(expect/expect [1 2] (my-drop 2 [2 1 1 2]))

(expect/expect '(2 4) (my-filter even? [1 2 3 4 5]))

(expect/expect '(1 1 2) (my-sort1 [1 2 1]))

(expect/expect '(1 2 2) (my-sort1 [2 2 1]))

(expect/expect '(-3 -2 -1) (my-sort1 [-1 -2 -3 ]))

(expect/expect '() (my-take -1 [1 2 3]))

(expect/expect '() (my-take -1 [-1 -2 -3]))

(expect/expect true (b1 "strrts"))

(expect/expect false (b1 "starts"))

(expect/expect true (b1 "adada"))

(expect/expect 7 ((my-comp inc *) 2 3))

(expect/expect 6 ((my-comp inc dec inc +)2 3))
