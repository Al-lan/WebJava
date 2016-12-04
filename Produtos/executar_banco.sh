#!/bin/sh
cd data
java -cp hsqldb.jar org.hsqldb.server.Server -database.0 ﬁle:prod --dbname.0 prod
