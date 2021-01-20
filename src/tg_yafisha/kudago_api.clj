(ns tg-yafisha.kudago-api
  (require [clj-http.client :as http-client]
           [tg-yafisha.config :refer [base_api_url]]))

(defn get-kudago-events! [page]
  (get (http-client/get
        base_api_url
        {:query-params
         {:page page
          :lang "ru"
          :location "spb"
          :categories "concert"}
         :as :json}) :body))

(defn events-list->message [events-json]
  (reduce str (for [event events-json] (str (get event :title) " \n \n"))))

(defn get-message! [kudago-page]
  (-> (get-kudago-events! kudago-page)
      (get , :results)
      (events-list->message)))
