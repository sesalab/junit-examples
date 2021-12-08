# junit-examples
JUnit examples, also with Mockito and DBUnit, for teaching purposes

# Basic Examples

## Primo Esempio con CLI

1. Scaricare la classe di produzione `Calculator`, e piazzarla in `src/main/java/it/unisa/basic`
2. Scaricare il Platform Launcher (`https://mvnrepository.com/artifact/org.junit.platform/junit-platform-console-standalone`) e piazzarlo in `src/test/resources`
3. Creare una classe di test `CalculatorTest` in `src/test/java/it/unisa/basic`
4. Creare dei metodi di test per `add()`
5. Lanciare la classe di test tramite CLI
   1. Compilare la classe `Calculator`: `javac src/main/java/it/unisa/basic/Calculator.java -d target/classes/`
   2. Compilare la classe di test `CalculatorTest`: `javac -cp src/test/resources/junit-platform-console-standalone-1.8.2.jar:target/classes/ src/test/java/it/unisa/basic/CalculatorTest.java -d target/test-classes`
   3. Lanciare i test: `java -jar src/test/resources/junit-platform-console-standalone-1.8.2.jar -cp target/classes/:target/test-classes/ --scan-classpath`
6. Modificare `add()` introducendo un bug
7. Ricompilare la classe `Calculator` come prima
8. Rilanciare i test come prima

## Lancio tramite IDE
1. Aggiungere la dipendenza di JUnit Jupiter al `pom.xml` oppure tramite GUI dell'IDE. Scaricabile da qui:`https://mvnrepository.com/artifact/org.junit.jupiter/junit-jupiter`
2. Cliccare i "Play" verdi per lanciare i metodi di test, un'intera classe di test, oppure tutti i test.

## Uso di Test Parametrici

1. Creare una classe di test `CalculatorParameterizedTest` in `src/test/java/it/unisa/basic`
2. Modificare i metodi di test per farne uno unico parametrico
3. Lanciare i test

## Creazione di altri Casi di Test

1. Creare una classe di test `CalculatorDivideTest` in `src/test/java/it/unisa/basic`
2. Creare dei metodi di test per `divide()`
3. Lanciare i test
4. Creare la classe `CalculatorFixed` con il metodo `divide()` corretto
5. Creare la classe `CalculatorFixedDivideTest` identica a `CalculatorDivideTest` ma che invoca `CalculatorFixed`
6. Rilanciare i test finché non passano

## Creazione di una Test Suite

1. Creare una classe `TestAllSuite` in `src/test/java/it`
2. Aggiungere la dipendenza di JUPlatform Suite al `pom.xml` oppure tramite GUI dell'IDE. Scaricabile da qui:`https://mvnrepository.com/artifact/org.junit.platform/junit-platform-suite`
3. Lanciare

## Creazione di una Calcolatrice stateful

1. Creare una classe `CalculatorStateful` in `src/test/java/it/unisa/basic`
2. Assegnare una variabile di istanza `esito`, con valori EMPTY, OK, e ERROR, con metodo getter
3. Assegnare una variabile di istanza `valore`, con metodo getter
4. Aggiungere le 4 operazioni, inclusa la cancellazione
5. Definire lo statechart e creare tanti casi di test tali da coprire, almeno un volta, ogni transizione
6. Raccogliere la logica in comuni in metodi setup e teardown
7. Lanciare
8. Definire almeno un caso di test per le 4 operazioni
9. Lanciare
