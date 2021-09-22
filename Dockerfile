FROM maven:3.2.5-jdk-8

ADD . /data/

WORKDIR /data

RUN mvn clean package

# NOTE: install Jetty libs so they are included in the Docker image
RUN mvn jetty:start

VOLUME /root/.m2
VOLUME /data/solr_home

EXPOSE 8080

CMD ["mvn", "jetty:run", "-Dsolr.port=8080"]
