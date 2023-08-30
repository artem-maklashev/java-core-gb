FROM bellsoft/liberica-openjdk-alpine:17.0.7 as BuildProject

WORKDIR /app
COPY ./java ./src

RUN mkdir ./out
RUN javac -sourcepath ./src -d out src/ru/study/lesson1/sample/Main.java

#FROM scratch as OutputFiles
#COPY --from=BuildProject /app/out /dest
CMD java -classpath ./out ru.study.lesson1.sample.Main
