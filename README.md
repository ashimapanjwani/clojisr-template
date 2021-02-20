# ClojisR template

Template to get started with [ClojisR](https://github.com/scicloj/clojisr) - a wrapper library exposing APIs for calling R functions on R objects in Clojure

It contains a Dockerfile which has Clojure and all the dependencies for ClojisR.

## Usage

Clojure projects including ClojisR can now be created quickly in 2 ways from the latest stable template:


-   **without** clj-new installed in user deps.edn

```bash
# example
clj -Sdeps '{:deps {seancorfield/clj-new {:mvn/version "1.0.199"}}}' \
  -m clj-new.create clojisr-template <org-name>.<app-name>
```

-    **with** clj-new [installed](https://github.com/seancorfield/clj-new) in user deps.edn (recommended)

```bash 
# example
clj  -X:new :template clojisr-template :name <org-name>.<app-name>
```

   **NOTE**: this assumes you have `clj-new` configured in your `~/.clojure/deps.edn`
   profile. 

### Creating docker image
The template creates a Dockerfile in the project folder.
The docker image can be build with

```
cd <org-name>.<app-name>
docker build . -t <app-name>
```

The Dockerfile assumes that the local project directory gets mounted into a folder in the container and that it becomes the working directory. The docker image runs a nRepl on port 12345 which can be connected to by any other nRepl compatible client (including emacs+Cider)

A typical command line for running the nRepl server in a docker container is then this:

```
docker run -ti -p 12345:12345 <app-name>
 ```
 ### Using ClojisR in repl
 
 
 Now Emacs (or any other nRepl client) can be connected to localhost:12345.
 
 Example to use clj as nRepl client:
 ```
lein repl :connect 12345
 ```

 
 In this connected repl ClojisR works out of the box:
 
 ```
(require '[clojisr.v1.r :refer [r]])
(r "1+1")     
 ```
