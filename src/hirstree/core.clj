(ns hirstree.core
  (:gen-class))

(fn answer
  [input boind]
  (if (= input "1234")
    (do (println "Correct")
      false)
    (do (println "False")
      true)))

(defn -main 
  []
  (loop [answer (read-line)]
    (if (= answer false)
      false
      (recur (read-line)))))
