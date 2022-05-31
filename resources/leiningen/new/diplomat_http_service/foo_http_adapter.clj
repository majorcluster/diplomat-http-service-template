(ns {{namespace}}.ports.http.adapters.foo
  (:require [clojure.set :as cset]))

(defn normalize-outbound-foo
  [foo]
  (cset/rename-keys foo {:a "a"
                         :state "state"}))