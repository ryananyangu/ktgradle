# todo use the same image openjdk as the gipod image for worksapce
# so as to have a common workspace image
FROM openjdk:17.0.2-jdk as builder

WORKDIR /ktgradle

COPY . .

RUN microdnf install findutils && ./gradlew build --no-daemon

# Todo consider usign JRE image
FROM openjdk:17-alpine AS runner

COPY --from=builder /ktgradle/build/libs/ktgradle-0.0.1-SNAPSHOT.jar ./ktgradle.jar

CMD ["java", "-jar", "ktgradle.jar"]