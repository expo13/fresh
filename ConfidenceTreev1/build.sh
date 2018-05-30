#!/bin/bash


#make necessary dirs
mkdir -p bin/
mkdir -p build/

#Check length of arguments
if [ $# -eq 0 ]
  then
	echo "No arguments supplied - Compiling All"
	javac -cp bin/ -d bin/ *.java
	jar cfm build/ConfidenceTree.jar META-INF/MANIFEST.MF bin/com/
else
	echo "Compiling - $1"
	javac -cp bin/ -d bin/ $1
fi

