(defproject {{raw-name}} "0.0.1-SNAPSHOT"
            :description "FIXME: write description"
            :url "http://example.com/FIXME"
            :license {:name "Eclipse Public License"
                      :url "http://www.eclipse.org/legal/epl-v10.html"}
            :dependencies [[org.clojure/clojure "1.11.1"]
                           [io.pedestal/pedestal.service "0.5.10"]

                           [io.pedestal/pedestal.jetty "0.5.10"]
                           [org.clojure/data.json "0.2.6"]

                           [ch.qos.logback/logback-classic "1.2.10" :exclusions [org.slf4j/slf4j-api]]
                           [org.slf4j/jul-to-slf4j "1.7.35"]
                           [org.slf4j/jcl-over-slf4j "1.7.35"]
                           [org.slf4j/log4j-over-slf4j "1.7.35"]]
            :min-lein-version "2.0.0"
            :resource-paths ["config", "resources"]
            :profiles {:dev {:aliases {"run-dev" ["trampoline" "run" "-m" "{{namespace}}.server/run-dev"]}
                             :dependencies [[io.pedestal/pedestal.service-tools "0.5.10"]]}
                       :uberjar {:aot [{{namespace}}.server]}}
            :main ^{:skip-aot true} {{namespace}}.server)
