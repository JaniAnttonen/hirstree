(ns hirstree.core
  (:gen-class))

(def oikeavastaus "ebin")

; (defn paljasta
;   [kirjain]
;   ())

(defn oikein
  [arvaus]
  (if (= arvaus oikeavastaus)
  true
  false))

(defn kysy
  [kysymys]
  (println kysymys)
  (read-line))

(defn -main 
  []
  (loop [arvaus (kysy "Arvaa kokonaista sanaa, tai anna kirjain:")]
    (if (= (count arvaus) 1)
      (do 
        (println "e___")
        (recur (kysy "Arvaa lisää kirjaimia, tai arvaa koko sanaa:")))
      (if (oikein arvaus)
        (println "Vastaus oli oikein!")
        (recur (kysy "Väärin, arvaa uudelleen, tai anna kirjain:")))
    )
  )
)
