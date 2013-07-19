package uk.gov.gds.guice

import org.scalatest.{GivenWhenThen, FunSuite}
import com.google.inject.Singleton
import org.scalatest.matchers.ShouldMatchers

class DependencyInjectionProviderTest
  extends FunSuite
  with GivenWhenThen
  with ShouldMatchers {

  test("can pull a dependancy out of Guice using DependencyInjectionProvider") {
    Given("we have a class Foo that can be injected and Guice is initialised")
    GuiceContainer.initialize()

    When("we try to resolve Foo using DependencyInjectionProvider")
    new DependencyInjectionProvider {
      dependency[TestFoo].success should be("You pass")
    }
  }
}

@Singleton
class TestFoo() {
  def success = {
    "You pass"
  }
}