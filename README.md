# [Hirsipuu](https://en.wikipedia.org/wiki/Hangman_%28game%29) with Clojure

## Installation

Download from [releases](https://github.com/JaniAnttonen/hirstree/releases).
You need to have a working installation of docker and docker-compose on your computer.
(Or you can just use leiningen if you're into that sort of stuff.)

## Development
Sources under src/hirstree/


```bash
make dev
```

## Build
```bash
make build
```
Builds an executable to target/base+system+user+dev/

## Run the built executable
```bash
make run 
```
On some operation systems this by default shows an error. In that case, execute ```make run``` with admin privileges, eg. ```sudo make run``` on an [UNIX system](https://www.reddit.com/r/itsaunixsystem/)
