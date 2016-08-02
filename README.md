# springtestspockissue

Reproducing Spring context not injected when using new @SpringbootTest 
annotation from Spring boot 1.4 in combination with Spock test.

Junit test added and there the injection works fine.

Update:

    thanks to the tip from Dan Sayer on the Spring boot I tried with
    Spock 1.1-groovy-2.4-rc-1 and now it works. :<)

Update 2:
    With a little workaround it works for spock 1.0 as well. instead
    of using @SpringbootTest you have to use the deprecated annotations:

    @SpringApplicationConfiguration(TestConfiguration)
    @WebIntegrationTest(randomPort = true)

    TestConfiguration is a @Configuration bean where a TestRestTemplate
    is created code borrowed from [SpringBootTestContextCustomizer](https://github.com/spring-projects/spring-boot/blob/bf8a8167aaafbdb568f178b7d9afe9b3bf94ea3a/spring-boot-test/src/main/java/org/springframework/boot/test/context/SpringBootTestContextCustomizer.java)

A working sample for spock1.0 can be found in branch... [spock1.0](https://github.com/bendh/springtestspockissue/tree/spock1.0) ;<)


