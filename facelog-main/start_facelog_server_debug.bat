pushd %~dp0
java -Xrunjdwp:transport=dt_socket,server=y,address=8000,suspend=n -jar target\facelog-main-1.0-SNAPSHOT-standalone.jar
popd