#!/bin/bash

if [ -z "${SKY_HOME}" ]; then
  SKY_HOME=$(dirname $BASH_SOURCE)/..
fi

cd ${SKY_HOME}
nohup java -Dspring.config.location=file:conf/sky-server.properties -jar bin/sky-server.jar 1> /dev/null 2>&1 &