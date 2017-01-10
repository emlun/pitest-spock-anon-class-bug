package org.example

import spock.lang.Specification

class SubFoo extends Foo {}

class FooSpec extends Specification {

  private static final Foo foo = new SubFoo()

  def 'getRandomInteger always returns 4.'() {
    expect:
      foo.getRandomInteger() == 4
  }

}
