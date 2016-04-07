#!/bin/bash

set -e
cd "$(dirname "$0")"

rm -rf out
mkdir out
javac -source 1.5 -target 1.5 -cp "launchwrapper-1.12.jar" *.java -d out/ > build.log 2>&1
cd out
jar cvf ../OptiFineHack-1.jar * >> build.log 2>&1
