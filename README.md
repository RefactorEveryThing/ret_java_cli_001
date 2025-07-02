# Java Greeting CLI

```sh
touch .sdkmanrc
# load .sdkmanrc java version
sdk env
mvn --version

make init
make
make install
make run
make clean

```

```shell
java -cp "./target/ret_java_cli_001-1.0.jar:lib/*" com.nextjsvietnam.App
```

```shell
# shade only
java -jar ./target/ret_java_cli_001-1.0.jar
```

```shell
cp pom-basic.xml pom.xml
```

### Testing

```shell
mvn clean test

mvn -Dtest=DateUtilsTest test

mvn -Dtest=DateUtilsTest#week27Test test
```