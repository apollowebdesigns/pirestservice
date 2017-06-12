#!/bin/sh
# init.sh
cd ~
cd /home/pi/
cd Documents/
cd springpi/
cd pirestservice/
/opt/apache-maven-3.2.5/bin/mvn clean install
cd target
sudo java -jar gs-rest-service-0.1.0.jar