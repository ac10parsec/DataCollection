#!/bin/sh

##DATE=%(date +%Y%m%d)
#mv test.txt $DATE.txt

wget -r "ftp://fs@192.168.3.240/" --ftp-password="1234"

exit 0
