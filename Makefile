# Variables
MVN = ./mvnw

ifeq ($(OS),Windows_NT)
	MVN = ./mvnw.cmd
endif

JAVA = java
JAR_FILE = target/car-manager-0.0.1.jar
MAIN_CLASS = io.github.dmgtechlabs.App

# Default goal
.DEFAULT_GOAL := help

compile: ## Compile the project
	$(MVN) clean compile

package: ## Package the project into a jar
	$(MVN) clean package

run: package ## Run the project
	$(JAVA) -jar $(JAR_FILE)

clean: ## Clean up compiled files
	$(MVN) clean

test: ## Run tests
	$(MVN) test

install: ## Install the package to local Maven repository
	$(MVN) install

help: ## Display help message
	@echo "Available commands:"
	@grep -E '^[a-zA-Z_-]+:.*?## .*$$' $(MAKEFILE_LIST) | awk 'BEGIN {FS = ":.*?## "}; {printf "\033[36m%-20s\033[0m %s\n", $$1, $$2}'

.PHONY: compile package run clean test install help
