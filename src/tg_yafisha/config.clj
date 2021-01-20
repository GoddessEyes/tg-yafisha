(ns tg-yafisha.config
  (require [dotenv :refer [env app-env]]))

(def token (env :TELEGRAM_TOKEN))
(def base_api_url "https://kudago.com/public-api/v1.4/events/")
