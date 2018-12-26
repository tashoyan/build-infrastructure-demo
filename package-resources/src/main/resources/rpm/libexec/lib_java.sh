#!/bin/sh

# Requires lib_log.sh to be already loaded

required_java_version="@{compiler.java.version}"

if test "${JAVA_HOME:-x}" != "x"
then
  if "$JAVA_HOME/bin/java" -version 2>/dev/null
  then
    if "$JAVA_HOME/bin/java" -version 2>&1 | grep -E '\s+version\s+' | grep -qE "$required_java_version"
    then
      JAVA="$JAVA_HOME/bin/java"
    else
      error_and_exit "JAVA_HOME points to version of java different than $required_java_version "
    fi
  else
    error_and_exit "Cannot execute java from JAVA_HOME: $JAVA_HOME/bin/java"
  fi
else
  log_debug "JAVA_HOME is not set, trying java from PATH"
  if java -version 2>/dev/null
  then
    log_debug "Found java in PATH"
    if java -version 2>&1 | grep -E '\s+version\s+' | grep -qE "$required_java_version"
    then
      log_debug "java in PATH is $required_java_version, using it"
      JAVA=java
    else
      error_and_exit "JAVA_HOME is not set and java found in PATH is not version $required_java_version"
    fi
  else
    error_and_exit "JAVA_HOME is not set and java was not found in PATH"
  fi
fi
