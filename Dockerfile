FROM gradle:8-jdk21

WORKDIR /workspace
COPY . .

CMD ["./gradlew","clean","build"]