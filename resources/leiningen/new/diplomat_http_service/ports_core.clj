(ns {{namespace}}.ports.core
  (:require [{{namespace}}.ports.http.core :as http.c]))

(defn start-ports-dev
  []
  (http.c/start-dev))

(defn start-ports
  []
  (http.c/start))