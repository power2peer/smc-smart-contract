== Dev database ==

To start mongodb temporarily for dev you can use docker

Use Daeomon mode:

    docker run -d --mount source=myvol,target=/bitnami -p 27017:27017 bitnami/mongodb:latest

== Prod database ==

Prod db is started with user 'test' pwd 'test' (see application-prod.properties)

When starting service on server, always use -Dspring.profiles.active=prod to use the authenticated db

by default local dev profile uses docker based db with db 'test' as per spring data mongodb defaults
    
== Start app service on server (after setting up systemctl) ==

    sudo systemctl restart transactionapi.service

systemctl should be setup to run soething like this

    java -Dspring.profiles.active=prod -jar jarFile.jar 

jarFile.jar is just the jar from build/libs
    
== Creating geospatial data in mongodb for registered users ==

    db.registeredUser.createIndex({location:"2dsphere"})
    db.registeredUser.updateMany({}, {$set: {location: {type: "Point", coordinates:[0,0]} }})

Now all users have a 0,0 location. But now you can upated each user if desired using a patch query like this in postman

    