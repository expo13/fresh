#!/bin/bash

#Check length of arguments
if [ $# -eq 0 ]
  then
	echo "No arguments supplied - Compiling All"
	javac -cp bin/ -d bin/ *.java

else
	echo "Compiling - $1"
	javac -cp bin/ -d bin/ $1
fi

