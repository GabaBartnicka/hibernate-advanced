#!/bin/bash

docker run -p 3306:3306 --name mariadb_for_hibernate_adv -e MYSQL_ROOT_PASSWORD=mypass -d mariadb
docker exec -it mariadb_for_hibernate_adv bash

#root@2dbec95fb762:/# mysql -u root -p
#Enter password:
#Welcome to the MariaDB monitor.  Commands end with ; or \g.
#Your MariaDB connection id is 10
#Server version: 10.4.6-MariaDB-1:10.4.6+maria~bionic mariadb.org binary distribution
#
#Copyright (c) 2000, 2018, Oracle, MariaDB Corporation Ab and others.
#
#Type 'help;' or '\h' for help. Type '\c' to clear the current input statement.
#
#MariaDB [(none)]> create database hibernate_adv;
#Query OK, 1 row affected (0.001 sec)
#
#MariaDB [(none)]> commit
#    -> ;
#Query OK, 0 rows affected (0.000 sec)

#jdbc:mariadb://localhost:3306/hibernate_adv
#user: root
