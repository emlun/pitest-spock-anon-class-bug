#!/bin/bash

./gradlew clean classes testClasses exportDependencies

java \
  -cp "$(for f in build/dependencies/*; do echo -n "${f}:"; done)build/classes/main:build/classes/test" \
  org.pitest.mutationtest.commandline.MutationCoverageReport \
  --reportDir build/reports/pitest-cli \
  --targetClasses org.example.* \
  --sourceDirs src/main/java \
  --verbose
