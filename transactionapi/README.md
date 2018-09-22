== Dev database ==

To start mongodb temporarily for dev you can use docker

    docker run --mount source=myvol,target=/bitnami -p 27017:27017 bitnami/mongodb:latest
    
