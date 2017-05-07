(ns hirstree.core
  (:gen-class))

(def oikeavastaus "ebin")

(defn oikein
  [arvaus]
  (if (= oikeavastaus arvaus)
  true
  false))

(defn kysy
  [kysymys]
  (println kysymys)
  (read-line))

(defn -main 
  []
  (loop [arvaus (kysy "Juuh elikkäs, arvaappa mikä sana on kyseessä:")]
    (if (oikein arvaus)
      (println "Vastaus oli oikein!")
      (recur (kysy "Väärin, arvaa uudelleen:")))))
