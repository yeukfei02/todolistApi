# todolistApi

todolistApi

documentation: <https://documenter.getpostman.com/view/3827865/Szmb7Kdz?version=latest>

## Requirement

- install java (1.8+)

## Testing and run

```zsh
// build jar
$ ./gradlew build

// run jar
$ java -jar build/libs/todolistApi-1.0.0.jar

// start project
- run MainApplication.java

// run test case
- run MainApplicationTests.java
```

open project in intellij idea

open localhost:8080

## Docker

```zsh
// build images and start container in one line
docker-compose up -d --build

// go inside container
docker exec -it <containerId> /bin/bash

// check container logs
docker logs <containerId>

// remove and stop container
docker-compose down
```

open localhost:8080

## Contributing

Please refer to [CONTRIBUTING.md](https://github.com/yeukfei02/todolistApi/blob/master/CONTRIBUTING.md)
