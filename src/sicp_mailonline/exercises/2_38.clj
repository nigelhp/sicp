;; Exercise 2.38
;; The accumulate procedure is also known as fold-right, because it combines the
;; first element of the sequence with the result of combining all the elements
;; to the right.  There is also a fold-left, which is similar to fold-right,
;; except that it combines elements working in the opposite direction:
;;
;; (define (fold-left op initial sequence)
;;   (define (iter result rest)
;;     (if (null? rest)
;;       result
;;       (iter (op result (car rest))
;;             (cdr rest))))
;;   (iter initial sequence))
;;
;; What are the values of
;;
;; (fold-right / 1 (list 1 2 3))
;;
;; (fold-left / 1 (list 1 2 3))
;;
;; (fold-right list nil (list 1 2 3))
;;
;; (fold-left list nil (list 1 2 3))
;;
;; Give a property that op should satisfy to guarantee that fold-right and
;; fold-left will produce the same values for any sequence.

(ns sicp-mailonline.exercises.2-38
  (:require [sicp-mailonline.examples.2-2-3 :refer [accumulate]]))

(def fold-right accumulate)

(defn fold-left [op initial sequence]
  (letfn [(iter [result others]
            (if (empty? others)
              result
              (recur (op result (first others))
                     (rest others))))]
    (iter initial sequence)))

;; An op should have the commutative property for fold-right and fold-left
;; to produce the same values for a sequence i.e. changing the order of the
;; operands to op should not change the result of op.
