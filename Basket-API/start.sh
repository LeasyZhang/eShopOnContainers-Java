#!/bin/bash

cd /archiver || exit

DEFAULT_JAR_NAME="/basket-api/basket-api-*.jar"

# Default JMX port is 8888, you can override it using environment variable JMX_PORT or Marathon specific PORTX
JMX_PORT=${JMX_PORT:-8888}

# Default JMX RMI port is 8888, you can override it using environment variable JMX_RMI_PORT or Marathon specific PORTX
JMX_RMI_PORT=${JMX_RMI_PORT:-8888}

# Get HOSTNAME
HOST=${SERVER_IP}

# Default JMX configuration
DEFAULT_JMX_OPTS="-Dcom.sun.management.jmxremote \
                  -Dcom.sun.management.jmxremote.port=$JMX_PORT \
                  -Dcom.sun.management.jmxremote.rmi.port=$JMX_RMI_PORT \
                  -Dcom.sun.management.jmxremote.local.only=false \
                  -Dcom.sun.management.jmxremote.authenticate=false \
                  -Dcom.sun.management.jmxremote.ssl=false \
                  -Djava.rmi.server.hostname=$HOST"

# Default configuration for Garbage Collector
DEFAULT_GC_OPTS="-XX:-UseGCOverheadLimit  \
                    -XX:+UseConcMarkSweepGC \
                    -XX:+UseCMSInitiatingOccupancyOnly \
                    -XX:CMSInitiatingOccupancyFraction=70 \
                    -XX:+UseLargePagesInMetaspace \
                    -XX:+ScavengeBeforeFullGC \
                    -XX:+CMSScavengeBeforeRemark \
                    -XX:+DisableExplicitGC \
                    -XX:+HeapDumpOnOutOfMemoryError \
                    -XX:HeapDumpPath=/opt/basket-api"

# Default configuration for logging
DEFAULT_LOGGING_OPTS="-Dlogging.stdout=false \
                    -verbose:gc \
                    -XX:+PrintGC \
                    -XX:+PrintGCTimeStamps \
                    -XX:+PrintGCDateStamps \
                    -XX:+PrintGCDetails"

# memory
# https://bugs.openjdk.java.net/browse/JDK-8186315
DEFAULT_MEMORY_OPTS="-XX:+UseContainerSupport\
                      -XX:InitialRAMPercentage=${INITIAL_RAM_PERCENTAGE:-1.5625} \
                      -XX:MaxRAMPercentage=${MAX_RAM_PERCENTAGE:-50.0} \
                      -XX:MinRAMPercentage=${MIN_RAM_PERCENTAGE:-25.0}"
# Default agent
DEFAULT_JAVA_AGENT=""

JVM_OPTS=${JVM_OPTS:-$JAVA_OPTS ${JMX_OPTS:-$DEFAULT_JMX_OPTS} ${GC_OPTS:-$DEFAULT_GC_OPTS} ${LOGGING_OPTS:-$DEFAULT_LOGGING_OPTS} ${MEMORY_OPTS:-$DEFAULT_MEMORY_OPTS} ${JAVA_AGENT:-$DEFAULT_JAVA_AGENT} }

# runtime options
DEFAULT_RUNTIME_OPTS="-Dspring.profiles.active=prod"

# Environment
echo "== ENVIRONMENT =="
printenv
echo "====================="

RUNTIME_OPTS=${RUNTIME_OPTS:-$DEFAULT_RUNTIME_OPTS}
JAR_NAME=${JAR_NAME:-$DEFAULT_JAR_NAME}

JAVA_OPTIONS=${WORKER_JAVA_OPTIONS:-"${JVM_OPTS} ${RUNTIME_OPTS} -jar ${JAR_NAME}"}

echo "JAVA Options: $JAVA_OPTIONS"

echo "== Booting Basket API... =="

exec java $JAVA_OPTIONS
