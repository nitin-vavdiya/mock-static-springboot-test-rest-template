## Mock static method om spring boot application while testing with TestRestTemplate

### Reproduce the issue
1. run `./gradlew test`

**Actual result:** Test case is getting failed even we are mocking `StaticClass.getMessage()` method

**Expected result:** Test case should be pass
