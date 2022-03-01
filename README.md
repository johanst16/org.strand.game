
### Build

mvn clean install

### Usage

#### FX GUI:

* mvn javafx:run

to use another figure change pom.xml :

* commandlineArgs octagon2 commandlineArgs

#### IntelliJ

* VM options :

--module-path
/path/to/openjfx-17.0.2_linux-x64_bin-sdk/javafx-sdk-17.0.2/lib
--add-modules=javafx.controls,javafx.fxml
-Dprism.order=sw

* Program arguments:

Octagon2

#### Console:

* mvn exec:java -Dexec.mainClass="org.strand.game.Main" -Dexec.args="octagon2 200 200"

or

* mvn exec:java -Dexec.mainClass="org.strand.game.Main" -Dexec.args="toad 200 200"
