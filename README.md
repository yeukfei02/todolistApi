# todolistApi

todolistApi

documentation: https://documenter.getpostman.com/view/3827865/Szmb7Kdz?version=latest

## Requirement:

 - install java (1.8+)

## Testing and run:

```
// build jar
$ ./gradlew build

// run jar
$ java -jar build/libs/todolistApi-1.0.0.jar

// start project - run MainApplication.java

// run test case - run MainApplicationTests.java
```

open project in intellij idea

open localhost:8080

## Docker:

- Dockerfile

build images and start container
```
docker build -t <username>/todolist-api:<tag> .
docker run -p 8080:8080 -d <username>/todolist-api:<tag>
docker exec -it <containerId> /bin/bash
docker logs <containerId>
```

check images and container
```
docker images
docker ps
docker ps -a
```

open localhost:8080

- docker-compose.yml

build images and start container
```
docker-compose build
docker-compose up
```

build images and start container in one line
```
docker-compose up -d --build
```

stop container
```
docker-compose stop
```

add tag to docker images
```
$ docker tag <imageId> <dockerHubUserName>/<imageName>:<tag>
```

push docker images to docker hub
```
$ docker push <dockerHubUserName>/<imageName>:<tag>
```

open localhost:8080

## Contributing

Please refer to [CONTRIBUTING.md](https://github.com/yeukfei02/todolistApi/blob/master/CONTRIBUTING.md)