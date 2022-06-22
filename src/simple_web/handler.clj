(ns simple-web.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :as resp]
            [simple-web.pages :as page]
            [simple-web.files :as file]))

(defroutes app-routes
  (GET "/" [] (page/index file/txt))
  (POST "/" [note] (do (file/add note)
                       (resp/redirect "/")))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
