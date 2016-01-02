;; Exercise 3.13
;; Consider the following make-cycle procedure, which uses the last-pair
;; procedure defined in exercise 3.12:
;;
;; (define (make-cycle x)
;;   (set-cdr! (last-pair x) x)
;;   x)
;;
;; Draw a box-and-pointer diagram that shows the structure z created by
;;
;; (define z (make-cycle (list 'a 'b 'c)))
;;
;; What happens if we try to compute (last-pair z)?

;;             c 
;;            [*|*]
;;          b |  |
;;         [*|*] |
;;       a |     |
;; z -> [*|*]    |
;;        ^      |
;;        |______|
;;
;; Attempting to compute (last-pair z) will not return, as attempting to
;; traverse the list will cycle continuously.
