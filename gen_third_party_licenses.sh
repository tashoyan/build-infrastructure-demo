#!/bin/sh

# A tool to generate a file with licenses of third party dependencies.
# The output file will be target/generated-sources/license/THIRD-PARTY.txt.
# The content of this file can be used for a report about third party components usage.
#
# Unfortunately, we cannot make this task a part of the build,
# we have to keep it in a separate script.
# This is a deficiency of the license-maven-plugin:
# https://github.com/mojohaus/license-maven-plugin/issues/45

set -o nounset
set -o errexit
set -o pipefail

mvn license:aggregate-add-third-party
