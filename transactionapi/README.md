== Dev database ==

To start mongodb temporarily for dev you can use docker

Use Daeomon mode:

    docker run -d --mount source=myvol,target=/bitnami -p 27017:27017 bitnami/mongodb:latest

    
    
== Start app service ==

    sudo systemctl restart transactionapi.service

    
== Creating geospatial index in db ==

    db.registeredUser.createIndex({location:"2dsphere"})

