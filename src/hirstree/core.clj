(ns hirstree.core
  (:gen-class))
(require 'clojure.string)

(def oikeavastaus "eebenpuu")

(defn paljasta
  [kirjaimet]
  (clojure.string/replace
    oikeavastaus 
    (re-pattern (str "[^" kirjaimet "]")) "_"))

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
  (loop [arvaus (kysy "Arvaa kokonaista sanaa, tai anna kirjain:")
         kirjaimet ""]
    (if (= (count arvaus) 1)
      (do 
        (println (paljasta (str arvaus kirjaimet)))
        (recur 
          (kysy "Arvaa lisää kirjaimia, tai arvaa koko sanaa:")
          (str kirjaimet arvaus)))
      (if (oikein arvaus)
        (println "Vastaus oli oikein!")
        (recur (kysy "Väärin, arvaa uudelleen, tai anna kirjain:") kirjaimet)))))
