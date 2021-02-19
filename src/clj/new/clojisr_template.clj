(ns clj.new.clojisr-template
  (:require [clj.new.templates :refer [renderer project-name name-to-path ->files]]))

(def render (renderer "clojisr_template"))

(defn file-map->files [data file-map]
  (apply ->files data (seq file-map)))

(defn clojisr-template! [name & {force :force? dir :dir}]
  (let [data         {:name      (project-name name)
                      :base      (clojure.string/replace
                                  (project-name name)
                                  #"(.*?)[.](.*$)"
                                  "$1")
                      :suffix    (clojure.string/replace
                                  (project-name name)
                                  #"(.*?)[.](.*$)"
                                  "$2")
                      :sanitized (name-to-path name)}
        {base :base} data]

    (println (str  "Generating clojisr template for "
                   (:name data) " at " (:sanitized data) ".\n\n"
                   ))

    (with-bindings {#'clj.new.templates/*force?* force
                    #'clj.new.templates/*dir*    dir}
      (file-map->files
       data
       {"Dockerfile"                                           (render "Dockerfile" data)
        "deps.edn"                                            (render "deps.edn" data)}))))


(defn clojisr-template
  ([name] (clojisr-template! name))
  ([name & args] (clojisr-template name)))

(comment
  (newline)
  (clojisr-template!
   "mydomain.myapp"
   :dir "testdir"
   :force? true)
  )
