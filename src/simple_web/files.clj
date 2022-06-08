(ns simple-web.files
  (:require [clojure.string :as st]))

(def txt (atom []))

(defn add [note]
  (when (not (empty? note)) 
    (swap! txt conj note)))
