(ns {{namespace}}.configs
  (:require [outpace.config :refer [defconfig]]))

(defconfig env "test")

(defn env-test?
  []
  (= "test" env))
