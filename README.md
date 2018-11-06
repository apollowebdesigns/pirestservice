# Raspberry Pi Pirestservice readme (and awesome Pi cheatsheet!)

Reference-style: 
![alt text][logo]

[logo]: https://cdn.sparkfun.com//assets/parts/1/2/8/2/8/14643-Raspberry_Pi_3_B_-02.jpg "Logo Title Text 2"

## Repositories needed

### Pi Database MySQL

https://github.com/apollowebdesigns/pirewinddatabase

### Pi Orders Database

https://github.com/apollowebdesigns/pipresentdirectiondatabase

## Starting the pi

Start a script on load

http://www.instructables.com/id/Raspberry-Pi-Launch-Python-script-on-startup/

Install Maven

maven needs to be installed from here.

check $PATH and move maven folder to /opt/ as this is where it should be for it to be found on path!!!

```
https://www.xianic.net/post/installing-maven-on-the-raspberry-pi/
```

Install PHP

```
sudo apt-get update
sudo apt-get install apache2 php5
```

Raspberry Pi Camera

http://elinux.org/RPi-Cam-Web-Interface#Basic_Installation

Getting scripts running

folder structure to be made

/home/pi/Documents/springpi/pirestservice

add using:

```
chmod 755 init.sh
chmod 755 update.sh
```

you will need to update.sh first as there will be no jar to run for init

```
sudo crontab -e
```

to update the crontab like in the tutorial and give seperate logs!

SSH problems

https://superuser.com/questions/421004/how-to-fix-warning-about-ecdsa-host-key

Install raspberrian

```
diskutil list

diskutil unmountDisk /dev/disk2

sudo dd if=~/Documents/[raspberianjessie].img of=/dev/rdisk2 bs=1m
```

## Cloning SD card

Use this link to [clone SD card](https://computers.tutsplus.com/articles/how-to-clone-raspberry-pi-sd-cards-using-the-command-line-in-os-x--mac-59911)

## Setting up ip addresses

On the raspberry pi, the ip address is emailed out.

```

##
# Host Database
#
# localhost is used to configure the loopback interface
# when the system is booting.  Do not change this entry.
##
127.0.0.1       localhost
255.255.255.255 broadcasthost
::1             localhost

```

use the file from
```
/etc/hosts
```
