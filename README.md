# Behaviour Driven Testing Framework 

## Tech stack

| Tools | Description |
| --- | --- |
| CucumberJVM | BDD layer |
| JUnit | Assertion library |
| Selenium-WebDriver | Test framework | 
| Java | Test scripting language |
| Rest Assured | API testing |
| Hamcrest | Assertion library |
| Maven | Build tool |


## Installations

- Git. Add the ssh keys to your profile on Gitlab
- An IDE, which supports Java and Gherkin(for Cucumber). The one used is IntelliJ. Add the - Gherkin and Cucumber for Java plugin to the IDE.
- Java JDK 7. Version used is 7.80
- Maven. Version used is 3.3.9

## Machine setup

#### For Mac
1. Open Terminal
2. Type vim `.bash_profile`
3. `export JAVA_HOME=$"/Library/Java/JavaVirtualMachines/jdk1.7.0_80.jdk/Contents/Home”`
4. `export PATH=$"/usr/local/bin:/usr/bin:/bin:/usr/sbin:/sbin:/Users/wamikas/Documents/apache-maven-3.3.9/bin”`
5. Click ESC then type :wq (save and quit in vim)
6. Then type `source .bash_profile`
7. `echo $JAVA_HOME`
8. `echo $PATH` if you see the path you are all set.

## Code Setup

`git clone https://github.com/Wamikas/Functional-tests.git`


## Running tests

To execute all tests `mvn test`


