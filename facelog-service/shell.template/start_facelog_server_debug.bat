pushd %~dp0
java -Xrunjdwp:transport=dt_socket,server=y,address=8000,suspend=n -jar facelog-service-${project.version}-standalone.jar
popd