(defproject clojisr-template/clj-template "1.1.1"
  :description "Template to get started with using ClojisR"
  :url "https://github.com/ashimapanjwani/clojisr-template"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :plugins [[lein-tools-deps "0.4.5"]]
  :middleware [lein-tools-deps.plugin/resolve-dependencies-with-deps-edn]
  :lein-tools-deps/config {:config-files [:install :user :project]})
