(ns tg-yafisha.handlers
  (:require [morse.handlers :as h]
            [tg-yafisha.config :refer [token]]
            [morse.api :as t]
            [tg-yafisha.kudago-api :refer [get-message!]]))

(def handlers
  (h/defhandler handler
    (h/command-fn "start"
                  (fn [{{id :id :as chat} :chat}]
                    (t/send-text token id "Welcome to <%raw-name%>!")))
    (h/message msg
               (t/send-text token (get-in msg [:chat :id]) (get-message! (get msg :text))))))
