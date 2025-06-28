# Load environment vars from .env (must be in KEY=VALUE format)
-include .env

# Default to 'local' if ENVIRONMENT isn't set in .env
ENVIRONMENT ?= local

# Project root
ROOT_DIR := $(shell pwd)

# Maven command
MVN := mvn

# Your main class
MAIN_CLASS := com.nextjsvietnam.App

# Phony targets
.PHONY: all install run clean package init

# Default target
all: install

init:  ## Init pom
	@cp pom-basic.xml pom.xml

install:  ## Install dependencies and build the project
	@cp pom-basic.xml pom.xml
	@echo "[$(ENVIRONMENT)] Installing and building in $(ROOT_DIR)"
	@$(MVN) clean install

run: install  ## Build and run the application
	@echo "[$(ENVIRONMENT)] Running application"
	@$(MVN) clean package exec:java -Dexec.mainClass=$(MAIN_CLASS)

clean:  ## Clean up build artifacts
	@echo "[$(ENVIRONMENT)] Cleaning project"
	@$(MVN) clean

package:  install ## Clean up build artifacts
	@echo "[$(ENVIRONMENT)] Package project"
	@$(MVN) package