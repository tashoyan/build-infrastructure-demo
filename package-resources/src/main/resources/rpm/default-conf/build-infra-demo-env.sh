#!/bin/sh
# Original version: @{distribution.version}

set -o nounset
set -o errexit
set -o pipefail

# Path to Apache Groovy distribution.
export GROOVY_HOME="$install_dir/@{distribution.groovy.install.dir}"
