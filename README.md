# junit-examples
JUnit examples, also with Mockito and DBUnit, for teaching purposes

# Primo Esempio con CLI

1. Creare classe di produzione `Calculator` con il metodo `add()` in `src/main/java/it/unisa/example`
2. Aggiungere o scaricare la dipendenza di tutto JUnit Jupiter: `https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter`
3. Creare una classe di Test `CalculatorTest` in `src/test/java/it/unisa/example`
4. Creare i metodi di test per `add()`
5. Lanciare tramite CLI
   1. Compilare la classe `Calculator`: `javac src/main/java/it/unisa/example/Calculator.java  -d target/classes/`
   2. Compilare la classe di test: `javac -cp src/test/resources/junit-platform-console-standalone-1.8.2.jar:target/classes/ src/test/java/it/unisa/example/CalculatorTest.java -d target/test-classes`
   3. Lanciare i test: `java -jar src/test/resources/junit-platform-console-standalone-1.8.2.jar -cp target/test-classes/:target/classes --scan-classpath`
6. Modificare `add()` introducendo un bug
7. Ricompilare la classe `Calculator` come prima
8. Rilanciare i test come prima, evidenziando le failure

# Creazione di ulteriori Casi di Test



# Uso di Test Parametrici

# Creazione di una Test Suite
