# Build Infrastructure Demo

[![Main](https://github.com/tashoyan/build-infrastructure-demo/actions/workflows/main.yml/badge.svg)](https://github.com/tashoyan/build-infrastructure-demo/actions/workflows/main.yml)

A demo project that illustrates how to apply the `Fail Fast` approach to the build infrastructure.

The project has a dummy piece of software written in two languages: Scala and Java.
It demonstrates the following activities embedded into the build process:
* Automatically format the code - Java, Scala as well as pom-files and XML resources
* Enforce build environment: JDK version, Maven version
* Check that the multi-module configuration is correct
* Check that all Maven plugins have their versions specified
* Enforce dependency convergence
* Prohibit usage of banned dependencies
* Prohibit snapshot dependencies for a release
* Check that all used dependencies are declared and no unused dependencies are declared
* Fail the build in case of compiler warnings
* Make static code analysis a part of the build process and fail the build in case of violations
* Make unit testing a part of the build process and fail the build in case of test failures

In addition, this project demonstrates how to:
* Build the rpm package
* Build source code and API documentation packages
* Comply with open-source policies:
  * Include the source of open-source dependencies to the product package
  * Provide a document with licensing information about open-source dependencies
