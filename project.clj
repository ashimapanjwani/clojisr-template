(defproject clojisr-template/clojisr-template "1.0.1"
  :description "Template to get started with ClojisR - a wrapper library exposing APIs for calling R functions on R objects in Clojure"
  :url "https://github.com/ashimapanjwani/clojisr-template"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-tools-deps "0.4.5"]]
  :middleware [lein-tools-deps.plugin/resolve-dependencies-with-deps-edn]
  :lein-tools-deps/config {:config-files [:install :user :project]})
