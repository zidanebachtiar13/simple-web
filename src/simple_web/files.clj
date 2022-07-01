(ns simple-web.files)

(def txt (atom []))

(defn add [note]
  (when (not (empty? note)) 
    (swap! txt conj note)))

(defn reset []
  (reset! txt []))
