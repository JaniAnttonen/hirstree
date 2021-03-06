(ns hirstree.core
  (:gen-class))
(require 'clojure.string)

;;; Lataa kaikki mahdolliset oikeat vastaukset
;;; tiedostosta src/hirstree/words.txt
(def sanat
  (with-open [tiedosto (clojure.java.io/reader "src/hirstree/words.txt")]
    (doall (line-seq tiedosto))))

;;; Laskee ladattujen sanojen lukumäärän
(def sanamäärä (count sanat))

;;; Arpoo ladatuista sanoista yhden oikean vastauksen
(def oikeavastaus
  (nth sanat (rand-int sanamäärä)))

;;; Tulostaa sanan tilan:
;;; Oikein arvatut kirjaimet tulostuvat itsenään
;;; Väärin arvatut tulostetaan alaviivoina
(defn paljasta
  [kirjaimet]
  (clojure.string/replace
    oikeavastaus 
    (re-pattern (str "[^" kirjaimet "]")) "_"))

;;; Yksinkertainen tarkistus, onko arvaus oikein
(defn oikein
  [arvaus]
  (if (= arvaus oikeavastaus)
    true
    false))

;;; Tarkistaa, sisältääkö haettu sana arvauksen
(defn oikeassavastauksessa
  [arvaus
   kirjaimet]
  (if (not (clojure.string/includes? kirjaimet arvaus))
    (clojure.string/includes? oikeavastaus arvaus)
    (println "Olet arvannut jo tämän kirjaimen.")))

;;; Kysyy kysymyksen ja palauttaa pelaajan vastauksen
(defn kysy
  [kysymys]
  (println kysymys)
  (read-line))

;;; Pelisilmukka
(defn -main 
  []
  (loop [arvaus (kysy "Arvaa kokonaista sanaa, tai anna kirjain:")
         kirjaimet ""
         vaaratvastaukset 0]
    ;; Tulostetaan yksi tyhjä rivi
    (println "")

    ;; Jatketaan pelin suorittamista,
    ;; jos vääriä vastauksia on alle 9 kappaletta
    (if (< vaaratvastaukset 9)

      ;; Jos arvauksen pituus on yksi kirjain,
      ;; yritetään paljastaa kaikkia kirjaimen esiintymisiä
      ;; oikeassa vastauksessa
      (if (= (count arvaus) 1)

        ;; Jos oikea vastaus sisältää arvatun kirjaimen,
        ;; mutta kirjainta ei vielä ole arvattu
        (if (oikeassavastauksessa arvaus kirjaimet)

          ;; Paljastetaan arvattu kirjain oikeasta vastauksesta,
          ;; näytetään pelaajalle sanan tila ja aloitetaan uusi pelikierros
          (do
            (println (str "Kirjain " arvaus " löytyy sanasta."))
            (println (paljasta (str arvaus kirjaimet)))
            (println "")
            (if (oikein (paljasta (str arvaus kirjaimet)))
              (println "Vastaus oli oikein!")
              (recur 
                (kysy "Arvaa lisää kirjaimia, tai arvaa koko sanaa:")
                (str kirjaimet arvaus)
                vaaratvastaukset)))

          ;; Kerrotaan pelaajalle väärästä arvauksesta,
          ;; lisätään yksi väärä vastaus ja aloitetaan uusi pelikierros
          (do
            (println (str "Kirjain " arvaus " ei löydy sanasta."))
            (println (paljasta (str arvaus kirjaimet)))
            (println
              (str
                "Sinulla on vielä varaa vastata "
                (- 8 vaaratvastaukset)
                " kertaa väärin."))
            (println "")
            (recur
              (kysy "Arvaa lisää kirjaimia, tai arvaa koko sanaa:")
              kirjaimet
              (+ vaaratvastaukset 1))))

        ;; Jos arvaus on enemmän kuin yksi kirjain,
        ;; tarkistetaan onko se oikein, jolloin lopetetaan peli.
        ;; Jos väärin, kerrotaan arvauksen vääryys, lisätään väärä vastaus
        ;; ja aloitetaan uusi pelikierros
        (if (oikein arvaus)
          (println "Vastaus oli oikein!")
          (do
            (println
              (str
                "Sinulla on vielä varaa vastata "
                (- 8 vaaratvastaukset)
                " kertaa väärin."))
            (recur
              (kysy "Väärin, arvaa uudelleen, tai anna kirjain:")
              kirjaimet
              (+ vaaratvastaukset 1)))))

      ;; Jos vääriä vastauksia on tullut jo 9 kpl, lopetetaan peli.
      (do
        (println (str "Oikea sana olisi ollut " oikeavastaus))
        (println "Hävisit pelin.")))))
