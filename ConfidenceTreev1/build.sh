#!/bin/bash


#make necessary dirs
mkdir -p bin/
mkdir -p build/

#Check length of arguments
if [ $# -eq 0 ]
  then
	echo "No arguments supplied - Compiling All"
	javac -d bin/ code/*.java
	jar cfm build/ConfidenceTree.jar META-INF/MANIFEST.MF -C bin/ /com/
else
	echo "Compiling - $1"
	javac -cp code/ -d bin/ $1
fi

