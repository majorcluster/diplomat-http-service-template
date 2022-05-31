(ns {{namespace}}.ports.http.routes.foo
  (:require [{{namespace}}.ports.http.adapters.foo :as a.foo]
            [{{namespace}}.controllers.foo :as c.foo]))

(defn get-foo
  [request]
  (let [result (-> (c.foo/generate-foo-data)
                   (a.foo/normalize-outbound-foo))]
    {:status 200 :headers {"Content-Type" "application/json"} :body result}))
