## To build java client

    cd javaclient
    start ethereun network (See its local readme file for instructions)
    ./gradlew build 

tests should pass


## To build ONOS Java provider library

    cd power2peer.app
    mvn clean install

Follow instructions here to install the .oar file into ONOS

In ONOS CLI:

    app activate com.power2peer.app



