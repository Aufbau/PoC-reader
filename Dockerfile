FROM maven:3.6.1-jdk-8-alpine

#make source folder and switch to it
RUN mkdir -p /usr/src/app
WORKDIR /usr/src/app

# install maven dependency packages (keep in image)
COPY ./PoC-result/pom.xml /usr/src/app/
RUN mvn dependency:go-offline

# copy main application and compile
COPY ./PoC-result/.mvn /usr/src/app/.mvn
COPY ./PoC-result/mvnw /usr/src/app/
COPY ./PoC-result/mvnw.cmd /usr/src/app/
# main src
COPY ./PoC-result/src /usr/src/app/src
RUN mvn install

# run the app!
CMD ["java", "-jar", "./target/PoC-result.jar"]