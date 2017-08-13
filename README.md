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

<code>https://www.xianic.net/post/installing-maven-on-the-raspberry-pi/</code>

Install PHP

<code>sudo apt-get update</code>
<br>
<code>sudo apt-get install apache2 php5</code>

Raspberry Pi Camera

http://elinux.org/RPi-Cam-Web-Interface#Basic_Installation

Getting scripts running

folder structure to be made

/home/pi/Documents/springpi/pirestservice

add using 

<code>chmod 755 init.sh</code>
<br>
<code>chmod 755 update.sh</code>

you will need to update.sh first as there will be no jar to run for init

<code>sudo crontab -e</code>

to update the crontab like in the tutorial and give seperate logs!

SSH problems

https://superuser.com/questions/421004/how-to-fix-warning-about-ecdsa-host-key

Install raspberrian

<code>
diskutil list

diskutil unmountDisk /dev/disk2

sudo dd if=~/Documents/[raspberianjessie].img of=/dev/rdisk2 bs=1m
</code>

Loading up Java

<code>
git clone https://github.com/apollowebdesigns/pirestservice.git
</code>