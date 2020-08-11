FROM openjdk:8 as runtime
# config lang
ENV LANG en_US.UTF-8
ENV LC_ALL en_US.UTF-8

EXPOSE 8080
EXPOSE 8888

WORKDIR /basket-api

COPY ./ /basket-api/build-dir

RUN cd build-dir \
      && ./gradlew -version

RUN cd build-dir \
      && ./gradlew build --build-cache -x test \
      && mv ./build/libs/basket-api-*.jar ../ \
      && mv ./start.sh ../ \
      && cd .. \
      && rm -rf ./build-dir

RUN mkdir -p /var/log/basket-api

RUN groupadd -g 100001 eshopgroup && \
    useradd -r -m -g eshopgroup -u 100001 eshopuser

RUN chown -R eshopuser:eshopgroup /basket-api
RUN chown -R eshopuser:eshopgroup /var/log/basket-api

USER eshopuser

RUN chmod +x *.sh