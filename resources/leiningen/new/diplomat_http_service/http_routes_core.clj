(ns {{namespace}}.ports.http.routes.core
  (:require [io.pedestal.http :as http]
    [io.pedestal.http.body-params :as body-params]
    [{{namespace}}.ports.http.routes.interceptors :as i]
    [{{namespace}}.ports.http.routes.foo :as r.foo]))

(def common-interceptors [(body-params/body-params)
                          http/html-body])

(def json-interceptors [(body-params/body-params)
                        (i/json-out)
                        http/html-body])

(def specs #{["/foo" :get (conj json-interceptors `r.foo/get-foo) :route-name :get-foo]
             ["/foo" :post (conj json-interceptors `r.foo/post-foo) :route-name :post-foo]})
