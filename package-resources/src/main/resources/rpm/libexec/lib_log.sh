#!/bin/sh

if test -x "$(which logger)"
then
  have_syslog=true
else
  have_syslog=false
fi

function get_log_file {
  echo "$data_dir/log/$(basename "$0").log"
}

function get_date {
  date "+%Y/%m/%d %H:%M:%S"
}

function log {
  # Try to log to file, then to syslog and finally to console.
  local msg="${*:-}"
  local date_msg="$(get_date) $msg"
  if ! echo "$date_msg" >> "$(get_log_file)" 2>&1
  then
    if $have_syslog
    then
      logger -t "$(basename "$0")" "$msg" || echo "$msg"
    else
      echo "$msg"
    fi
  fi
}

function log_info {
  local msg="INFO:  ${*:-}"
  echo "$msg"
  log "$msg"
}

function log_error {
  local msg="ERROR: ${*:-}"
  echo "$msg"
  log "$msg"
}

function log_debug {
  local msg="DEBUG: ${*:-}"
  log "$msg"
}

function error_and_exit {
  log_error ${*:-}
  exit 1
}
