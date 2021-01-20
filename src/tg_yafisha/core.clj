(ns tg-yafisha.core
  (:require [clojure.core.async :refer [<!!]]
            [clojure.string :as str]
            [morse.polling :as p]
            [tg-yafisha.config :refer [token]]
            [tg-yafisha.handlers :refer [handlers]])
  (:gen-class))

(defn -main
  [& args]
  (when (str/blank? token)
    (println "Please provide token in TELEGRAM_TOKEN environment variable!")
    (System/exit 1))

  (println "Starting the tg-yafisha")
  (<!! (p/start token handlers)))
