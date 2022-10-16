(ns ^:figwheel-hooks getting-started.counter
  (:require
    [goog.dom :as gdom]
    [goog.events :as gevents]))

(defonce app-state
  (atom 0))

(def step-input
  (gdom/getElement "step-input"))

(def count-value
  (gdom/getElement "count-value"))

(def app-element
  (gdom/getElement "app"))

(defn get-step-input-value []
  (js/Number (.. step-input -value)))

(defn render-new-count [val]
  (when (and (< (js/Number (gdom/getTextContent count-value)) val)
             (= val 10))
    (js/alert "Hey, it's time to take a break!"))
  (gdom/setTextContent count-value val))

(defn increase-count [app-state]
  (swap! app-state inc))

(defn decrease-count [app-state]
  (swap! app-state dec))

(defn step-count [app-state]
  (swap! app-state + (get-step-input-value)))

(defonce is-initialized?
  (do
   (gevents/listen app-element
                   "click"
                   (fn [event]
                     (condp = (aget event "target" "id")
                       "minus" (decrease-count app-state)
                       "plus" (increase-count app-state)
                       "step" (step-count app-state)
                       nil)))
   (add-watch app-state :counter-watcher
              (fn [key atom old new]
                (render-new-count new)))
   true))
