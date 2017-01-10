This is a bug report for [PIT][pitest].

Summary
===

Creating an anonymous subclass in a [Spock][spock] specification results in
Spock attempting to run the base class as a test class, and failing because it
is not a `Specification`. This happens in PIT, but not in standalone Spock.

Note that the code to mutate is written in Java; only the unit test is written
in Groovy.


Expectation
---

When the PIT commandline is run, it should run successfully.


Actual outcome
---

When the PIT commandline is run, it crashes while calculating coverage.


Workaround
---

Do not use anonymous subclasses in your Spock tests.


Reproduction
===

 1. Clone this repository.
 2. Check out the `bad` tag.
 3. Verify that Spock runs successfully standalone:

        $ ./gradlew clean test

 4. Verify that PIT crashes on the bad test:

        $ ./run-pitest.sh

 5. Check out the `good` tag.
 6. Verify that PIT now runs successfully:

        $ ./run-pitest.sh


Additional information
===

The same issue appears when using [gradle-pitest-plugin][gradle-pitest-plugin],
so it is likely that the issue is in the pitest core rather than the command
line module.


Conclusion
===

Since the Spock test runs successfully when run standalone, there is a bug in
PIT that causes Spock to try to run the wrong classes when a specification
contains an anonymous class.


[gradle-pitest-plugin]: http://gradle-pitest-plugin.solidsoft.info/
[pitest]: http://PIT.org/
[spock]: http://spockframework.org/
