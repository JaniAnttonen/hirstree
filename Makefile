.PHONY: dev build run

dev:
		docker-compose run --service-ports dev

build:
		docker-compose run --service-ports build

run:
		./target/base+system+user+dev/hirstree-0.1.0-SNAPSHOT