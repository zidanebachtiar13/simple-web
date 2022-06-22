(ns simple-web.pages
  (:require [hiccup.page :refer [html5]]
            [hiccup.form :as form]
            [garden.core :refer [css]]
            [ring.util.anti-forgery :refer (anti-forgery-field)]))

(def style
  (css [:label {:margin-left "40px"}] 
       ["input[type=text]" 
        {:width "20%"
         :margin "10px 10px 20px 40px"
         :padding "10px"
         :display "inline-block"
         :border "1px solid #ccc"
         :border-radius "4px"
         :box-sizing "border-box"}]
       ["input[type=submit]" 
        {:width "90px"
         :background-color "#e7e7e7e7"
         :padding "7px"
         :border "2px solid #e7e7e7"
         :border-radius "4px"
         :cursor "pointer"}
        [:&:hover {:background-color "#D3D3D3"
                   :border "2px solid #D3D3D3"}]]
       [:p
        {:border "1px solid black"
         :border-radius "5px"
         :padding "15px"
         :text-align "center"}]))

(defn base-page [& body]
  (html5
    [:head 
     [:title "Simple Web"]
     [:style style]]
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
