FROM openjdk:8 as runtime
# config lang
ENV LANG en_US.UTF-8
ENV LC_ALL en_US.UTF-8

EXPOSE 8080
EXPOSE 8888

WORKDIR /basket-api
COPY ../ ./

RUN ./gradlew -version

RUN ./gradlew :Basket-API:build --build-cache -x test \
      && mv ./Basket-API/build/libs/basket-api-*.jar /basket-api/

COPY ./start.sh ./start.sh

RUN mkdir -p /var/log/basket-api

RUN chown -R eshopuser:eshopgroup /basket-api
RUN chown -R eshopuser:eshopgroup /var/log/basket-api

USER eshopuser

RUN chmod +x *.sh