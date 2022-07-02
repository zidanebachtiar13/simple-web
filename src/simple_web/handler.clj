(ns simple-web.handler
  (:require [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer [wrap-defaults site-defaults]]
            [ring.util.response :as resp]
            [simple-web.pages :as page]
            [simple-web.files :as file]))

(defroutes app-routes
  (GET "/" [] (page/base-page file/txt))
  (POST "/tambah" [note] (do (file/add note)
                             (resp/redirect "/")))
  (POST "/reset" [] (do (file/reset)
                        (resp/redirect "/")))
  (route/not-found "Not Found"))

(def app
  (wrap-defaults app-routes site-defaults))
