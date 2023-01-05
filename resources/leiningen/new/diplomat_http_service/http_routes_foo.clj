(ns {{namespace}}.ports.http.routes.foo
  (:require [{{namespace}}.ports.http.adapters.foo :as a.foo]
            [{{namespace}}.controllers.foo :as c.foo]))

(defn get-foo
  [request]
  (let [result (-> (c.foo/generate-foo-data)
                   (a.foo/normalize-outbound-foo))]
    {:status 200 :headers {"Content-Type" "application/json"} :body result}))

(defn post-foo
  [request]
  (let [crude-body (:json-params request)]
    (println "POST RECEIVED" crude-body)
    {:status 204}))
