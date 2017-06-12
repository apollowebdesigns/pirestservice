#!/bin/sh
# init.sh
cd ~
cd Documents/
cd springpi/
cd pirestservice/
git pull
mvn clean install
cd target
sudo java -jar gs-rest-service-0.1.0.jar