(ns leiningen.spec
  (:use
    [speclj.running :only (*runner* report)]
    [speclj.run.standard :only (new-standard-runner)]
    [speclj.reporting :only (active-reporter)]
    [leiningen.compile :only [eval-in-project]])
  (:import
    [java.io File]))

(defn spec [project & args]
  (let [exec-form `(~'do (~'use 'speclj.main)(~'run '~@args))]
    (eval-in-project project exec-form nil nil nil)))
