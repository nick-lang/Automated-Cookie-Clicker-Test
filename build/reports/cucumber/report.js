$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("src/test/cucumber/cookieClick.feature");
formatter.feature({
  "name": "Click the cookie",
  "description": "  I want to use this template for my feature file",
  "keyword": "Feature"
});
formatter.scenario({
  "name": "Title of your scenario",
  "description": "",
  "keyword": "Scenario"
});
formatter.before({
  "status": "passed"
});
formatter.step({
  "name": "I am on the Cookie Clicker website",
  "keyword": "Given "
});
formatter.match({
  "location": "cookieClick_steps.groovy:7"
});
formatter.result({
  "error_message": "groovy.lang.MissingPropertyException: No such property: driver for class: cucumber.runtime.groovy.GroovyWorld\r\n\tat cucumber.runtime.groovy.GroovyWorld.findWorldWithProperty(GroovyWorld.java:47)\r\n\tat cucumber.runtime.groovy.GroovyWorld.getProperty(GroovyWorld.java:30)\r\n\tat cookieClick_steps$_run_closure1.doCall(cookieClick_steps.groovy:9)\r\n\tat ✽.I am on the Cookie Clicker website(src/test/cucumber/cookieClick.feature:5)\r\n",
  "status": "failed"
});
formatter.step({
  "name": "I click on the cookie",
  "keyword": "When "
});
formatter.match({
  "location": "cookieClick_steps.groovy:12"
});
formatter.result({
  "status": "skipped"
});
formatter.step({
  "name": "The number of cookies I have should increase",
  "keyword": "Then "
});
formatter.match({
  "location": "cookieClick_steps.groovy:21"
});
formatter.result({
  "status": "skipped"
});
});