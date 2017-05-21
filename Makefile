.PHONY: dev build run lint

dev:
		docker-compose run --service-ports dev

build:
		docker-compose run --service-ports build

run:
		chmod +x target/base+system+user+dev/*
		./target/base+system+user+dev/hirstree-1.0

lint:
		docker-compose run --service-ports lint
