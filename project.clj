(defproject hirstree "0.1"
  :description "A game of hangman written in Clojure"
  :url "https://github.com/JaniAnttonen/hirstree"
  :dependencies [[org.clojure/clojure "1.8.0"]]
  :main ^:skip-aot hirstree.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}
             :dev {:plugins [[lein-binplus "0.6.2"]]}})
