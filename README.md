# junit-examples
JUnit examples, also with Mockito and DBUnit, for teaching purposes

# Primo Esempio con CLI

1. Scaricare la classe di produzione `Calculator`, e piazzarla in `src/main/java/it/unisa/example`
2. Aggiungere o scaricare la dipendenza di JUnit Jupiter: `https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter`
3. Creare una classe di test `CalculatorTest` in `src/test/java/it/unisa/example`
4. Creare dei metodi di test per `add()`
5. Lanciare la classe di test tramite CLI
   1. Compilare la classe `Calculator`: `javac src/main/java/it/unisa/example/Calculator.java  -d target/classes/`
   2. Compilare la classe di test `CalculatorTest`: `javac -cp src/test/resources/junit-platform-console-standalone-1.8.2.jar:target/classes/ src/test/java/it/unisa/example/CalculatorTest.java -d target/test-classes`
   3. Lanciare i test: `java -jar src/test/resources/junit-platform-console-standalone-1.8.2.jar -cp target/classes/:target/test-classes/ --scan-classpath`
6. Modificare `add()` introducendo un bug
7. Ricompilare la classe `Calculator` come prima
8. Rilanciare i test come prima

# Uso di Test Parametrici

1. Creare una classe di test `CalculatorParameterizedTest` in `src/test/java/it/unisa/example`
2. Modificare i metodi di test per farne uno unico parametrico
3. Lanciare tramite IDE

# Creazione di altri Casi di Test

1. Creare una classe di test `CalculatorDivideTest` in `src/test/java/it/unisa/example`
2. Creare dei metodi di test per `divide()`
3. Lanciare tramite IDE
4. Creare la classe `CalculatorFixed` con il metodo `divide()` corretto
5. Creare la classe `CalculatorFixedDivideTest` identica a `CalculatorDivideTest` ma che invoca `CalculatorFixed`
6. Rilanciare i test finché non passano

# Creazione di una Test Suite

1. Creare una classe `TestAllSuite` in `src/test/java/it`
2. Aggiungere o scaricare la dipendenza di JUnit Platform Suite: `https://mvnrepository.com/artifact/org.junit.platform/junit-platform-suite`
3. Lanciare tramite IDE
