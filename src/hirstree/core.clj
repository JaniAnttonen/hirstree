(ns hirstree.core
  (:gen-class))

(def answer
  (let [character (read-line)]
    (if (= character "1234")
      (do (println "Correct")
        true)
      (do (println "False")
        false))))

(defn -main 
  []
  (loop [iter false]
    (let [iter answer])
    (if (= iter false)
      (recur false)
      false)))
