# [Hirsipuu](http://bit.ly/2pSkI97) with Clojure

## Installation

Download from [releases](https://github.com/JaniAnttonen/hirstree/releases).
You need to have a working installation of docker and docker-compose on your computer.
(Or you can just use leiningen if you're into that sort of stuff.)

## Development
Sources under src/hirstree/


```bash
make dev OR lein run
```

## Build
```bash
make build OR lein bin
```
Builds an executable to target/base+system+user+dev/

Mark as executable:

```chmod +x target/base+system+user+dev/*```

and run.
