(ns hirstree.core
  (:gen-class))

(def answer
  (let [character (read-line)]
    (if (= character "1234")
      (do (println "Correct")
        false)
      (do (println "False")
        true))))

(defn -main 
  []
  (loop [iter true]
    (let [iter answer])
    (if (= iter false)
      false
      (recur true))))
