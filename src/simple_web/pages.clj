(ns simple-web.pages
  (:require [hiccup.page :refer [html5 include-css]]
            [hiccup.form :as form]
            [ring.util.anti-forgery :refer (anti-forgery-field)]))

(defn base-page [& body]
  (html5
    [:head 
     [:title "Simple Web"]
     (include-css "css/style.css")]
    [:body
     (form/form-to
       [:post "/"]
       [:br]
       (form/label "note" "Input message")
       [:br]
       (form/text-field "note")
       (anti-forgery-field)
       (form/submit-button "submit"))
     [:hr]
     body]))

(defn index [notes]
  (base-page
    (for [note @notes]
      [:p note])))
