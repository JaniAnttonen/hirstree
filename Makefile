.PHONY: dev build

dev:
		docker-compose run --service-ports dev

build:
		docker-compose run --service-ports build