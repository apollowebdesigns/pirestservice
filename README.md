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

Loading up Java

```
git clone https://github.com/apollowebdesigns/pirestservice.git
```

### Compiling Native Java code with JNI

This stuff is very hard and fiddly to get right, here are some instructions for the
raspberry pi!!!

For a HelloWorld example create

```
javac HelloWorld.java
```

Then, create a headers file for the C program, so the Java program can hook into it.

```
javah -jni HelloWorld
```

Create the C file with desired code in -

For a Hello World example, use this file

```
 #include <jni.h>
 #include <stdio.h>
 #include "HelloWorld.h"

 JNIEXPORT void JNICALL
 Java_HelloWorld_print(JNIEnv *env, jobject obj)
 {
     printf("Hello World!\n");
     return;
 }
```

Create a shared library for the C code to be accessed by Java

```
gcc -shared -I/usr/lib/jvm/jdk-8-oracle-arm32-vfp-hflt/include -I/usr/lib/jvm/jdk-8-oracle-arm32-vfp-hflt/include/linux  HelloWorld.c -o libHelloWorld.so
```

When in the current directory of the running file run for the HelloWorld example

```
java -Djava.library.path=. HelloWorld
```

Here is a website for more info

https://www.java-tips.org/other-api-tips-100035/148-jni/1378-simple-example-of-using-the-java-native-interface.html

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
