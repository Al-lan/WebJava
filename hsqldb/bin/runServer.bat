cd ..\data
@java -classpath ../lib/hsqldb.jar org.hsqldb.server.Server --database.0 file:prod --dbname.0 prod
