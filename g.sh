#!/bin/bash

# change to the directory of the project
cd /d/Projects/geoffrey/geoffrey

# build the project
mvn clean install

# run the project
mvn exec:java -Dexec.mainClass="com.geoffrey.Geoffrey"

