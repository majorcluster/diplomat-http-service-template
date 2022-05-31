(ns {{namespace}}.controllers.foo
  (:require [{{namespace}}.logic.foo :as l.foo]))

(defn generate-foo-data
  []
  (l.foo/return-a-foo-map))