.PHONY: dev build run lint

dev:
		docker-compose run --rm --service-ports dev

build:
		docker-compose run --rm --service-ports build

run:
		chmod +x target/base+system+user+dev/*
		./target/base+system+user+dev/hirstree-1.1

lint:
		docker-compose run --rm --service-ports lint
