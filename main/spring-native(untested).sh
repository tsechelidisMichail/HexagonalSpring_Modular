#!/bin/bash


# TODO: UNTESTED - needs testing for proper generation of executable

# Get metadata of produced native .jar
parentDir=".."

name=$(./$parentDir/mvnw help:evaluate -Dexpression=project.name -q -DforceStdout)
version=$(./$parentDir/mvnw help:evaluate -Dexpression=project.version -q -DforceStdout)

jarName="$name-$version"

# Extract .jar (Spring Boot structured) into native folder
if [ -d "target/native" ]; then
    rm -rf target/native
fi

mkdir -p target/native
cd target/native
jar -xvf "../$jarName.jar"
cp -r META-INF BOOT-INF/classes

classpath="BOOT-INF/classes"

for jarFile in BOOT-INF/lib/*.jar; do
    classpath="$classpath:$jarFile"
done

# Use the extracted files
native-image -H:IncludeResources=".*.properties$" -H:Name=$jarName -cp "$classpath" main.Main

# Add execute permissions to the .sh file
chmod +x "$jarName.sh"