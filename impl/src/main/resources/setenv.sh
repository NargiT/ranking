#!/usr/bin/env bash

JAVA_ARGS="-XX:NativeMemoryTracking=detail \
    -XX:+AlwaysPreTouch \
    -XX:InitialRAMPercentage=25 \
    -XX:MaxRAMPercentage=25 \
    -XX:+UseParallelGC \
    -XX:MaxGCPauseMillis=200 \
    -XX:GCTimeRatio=19 \
    -XX:+PrintGCDetails"

JAVA_SYSTEM_ARGS="-Dcom.sun.management.jmxremote \
    -Dcom.sun.management.jmxremote.port=9010 \
    -Dcom.sun.management.jmxremote.rmi.port=9010 \
    -Dcom.sun.management.jmxremote.local.only=false \
    -Dcom.sun.management.jmxremote.authenticate=false \
    -Dcom.sun.management.jmxremote.ssl=false"

JAVA_TOOL_OPTIONS=""

JAVA_OPS="$JAVA_ARGS $JAVA_SYSTEM_ARGS"