#!/bin/bash

#Check length of arguments
if [ $# -eq 0 ]
  then
	echo "No arguments supplied - Compiling All"
	javac -d bin/ *.java

else
	echo "Compiling - $1"
	javac -d bin/ $1
fi

