(defproject simple-web "0.1.0-SNAPSHOT"
  :description "A simple note web"
  :url "https://simple-note-web.herokuapp.com/"
  :min-lein-version "2.0.0"
  :dependencies [[org.clojure/clojure "1.10.0"]
                 [compojure "1.6.1"]
                 [ring/ring-defaults "0.3.2"]
                 [hiccup "2.0.0-alpha2"]]
  :plugins [[lein-ring "0.12.5"]]
  :ring {:handler simple-web.handler/app}
  :profiles
  {:dev {:dependencies [[javax.servlet/servlet-api "2.5"]
                        [ring/ring-mock "0.3.2"]]}})
