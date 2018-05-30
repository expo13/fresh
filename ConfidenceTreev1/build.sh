#!/bin/bash


#make necessary dirs
mkdir -p bin/
mkdir -p build/

#Check length of arguments
if [ $# -eq 0 ]
  then
	echo "No arguments supplied - Compiling All"
	javac -d bin/  code/com/expotek/confidencetreev1/*.java code/com/expotek/utils/*.java
	jar cfm build/ConfidenceTree.jar META-INF/MANIFEST.MF bin/com/
else
	echo "Compiling - $1"
	javac -cp code/ -d bin/ $1
fi

