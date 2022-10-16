### The project

This project aims to be my first experience with ClojureScript. It’s based on this [article](https://blog.stephcrown.com/building-an-application-with-clojurescript) from [@steph-crown](https://github.com/steph-crown).

![image](https://user-images.githubusercontent.com/42384045/196039030-d614c97a-5bf0-4c7e-92a7-7222242cab15.png)

### Running

To get an interactive development environment run:

```clj
clojure -A:fig:build
```

This will auto compile and send all changes to the browser without the
need to reload. After the compilation process is complete, you will
get a Browser Connected REPL. An easy way to try it is:

```clj
(js/alert "Am I connected?")
```

With that, you should see an alert in the browser window. Cool right?

### To production and beyond

To create a production build run:

```clj
rm -rf target/public
clojure -A:fig:min
```
