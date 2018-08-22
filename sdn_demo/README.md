## To build java client

First build this since the ONOS Java provider library depends on it.

    cd javaclient
    start ethereun network (See its local readme file for instructions)
    ./gradlew build install

tests should pass and your jar should be installed to your local maven repository


## To build ONOS Java provider library

Setup ONOS as per https://wiki.onosproject.org/display/ONOS/Developer+Quick+Start
Start ONOS system

    cd power2peer.app
    mvn clean install

Follow instructions here https://wiki.onosproject.org/display/ONOS/Template+Application+Tutorial to install the .oar file into ONOS. Something like this:

    onos-app localhost install target/foo-app-1.0-SNAPSHOT.oar

In ONOS CLI:

    app activate com.power2peer.app



