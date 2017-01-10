package org.example

import spock.lang.Specification

class FooSpec extends Specification {

  private static final Foo foo = new Foo() {}

  def 'getRandomInteger always returns 4.'() {
    expect:
      foo.getRandomInteger() == 4
  }

}
