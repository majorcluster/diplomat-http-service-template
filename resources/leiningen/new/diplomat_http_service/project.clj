(defproject {{raw-name}} "0.0.1-SNAPSHOT"
            :description "FIXME: write description"
            :url "http://example.com/FIXME"
            :license {:name "The MIT License"
                      :url "http://opensource.org/licenses/MIT"}
            :dependencies [[org.clojure/clojure "1.11.1"]
                           [io.pedestal/pedestal.service "0.5.10"]
                           [io.pedestal/pedestal.jetty "0.5.10"]
                           [org.clojure/data.json "2.4.0"]
                           [com.outpace/config "0.13.5"]

                           [ch.qos.logback/logback-classic "1.4.6" :exclusions [org.slf4j/slf4j-api]]
                           [org.slf4j/jul-to-slf4j "2.0.7"]
                           [org.slf4j/jcl-over-slf4j "2.0.7"]
                           [org.slf4j/log4j-over-slf4j "2.0.7"]]
            :min-lein-version "2.0.0"
            :aliases {"config" ["run" "-m" "outpace.config.generate"]}
            :resource-paths ["config", "resources"]
            :jvm-opts ["-Dresource.config.edn=app-config.edn"]
            :profiles {:dev {:aliases {"run-dev" ["trampoline" "run" "-m" "{{namespace}}.server/run-dev"]}
                             :dependencies [[io.pedestal/pedestal.service-tools "0.5.10"]]
                             :jvm-opts ["-Dresource.config.edn=dev-config.edn"]}
                       :test {:dependencies [[io.pedestal/pedestal.service-tools "0.5.10"]
                                             [nubank/matcher-combinators "3.8.4"]]
                              :jvm-opts ["-Dresource.config.edn=test-config.edn"]}
                       :uberjar {:aot [{{namespace}}.server]}}
            :main ^{:skip-aot true} {{namespace}}.server)
