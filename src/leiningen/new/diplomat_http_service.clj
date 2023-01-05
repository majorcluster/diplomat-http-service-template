(ns leiningen.new.diplomat-http-service
  (:require [leiningen.new.templates :as tmpl]
            [leiningen.core.main :as main]))

(def render (tmpl/renderer "diplomat_http_service"))

(defn diplomat-http-service
  [name]
  (let [main-ns (tmpl/sanitize-ns name)
        data {:raw-name name
              :name (tmpl/project-name name)
              :namespace main-ns
              :sanitized (tmpl/name-to-path name)}]
    (main/info "Generating fresh 'lein new' diplomat-http-service project.")
    (tmpl/->files data
                  ["README.md" (render "README.md" data)]
                  ["project.clj" (render "project.clj" data)]
                  ["Dockerfile" (render "Dockerfile" data)]
                  [".gitignore" (render "gitignore" data)]
                  ["resources/dev-config.edn" (render "dev_config.edn" data)]
                  ["resources/test-config.edn" (render "test_config.edn" data)]
                  ["src/{{sanitized}}/server.clj" (render "server.clj" data)]
                  ["src/{{sanitized}}/configs.clj" (render "configs.clj" data)]
                  ["src/{{sanitized}}/controllers/foo.clj" (render "foo_controller.clj" data)]
                  ["src/{{sanitized}}/logic/foo.clj" (render "foo_logic.clj" data)]
                  ["src/{{sanitized}}/ports/http/adapters/foo.clj" (render "foo_http_adapter.clj" data)]
                  ["src/{{sanitized}}/ports/http/routes/core.clj" (render "http_routes_core.clj" data)]
                  ["src/{{sanitized}}/ports/http/routes/foo.clj" (render "http_routes_foo.clj" data)]
                  ["src/{{sanitized}}/ports/http/routes/interceptors.clj" (render "http_routes_interceptors.clj" data)]
                  ["src/{{sanitized}}/ports/http/core.clj" (render "http_core.clj" data)]
                  ["src/{{sanitized}}/ports/core.clj" (render "ports_core.clj" data)]
                  ["test/{{sanitized}}/ports/http/routes/foo_test.clj" (render "http_routes_foo_test.clj" data)]
                  ["config/logback.xml" (render "logback.xml" data)])))
