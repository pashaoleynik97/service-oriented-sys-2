FROM gradle:8.1.1-jdk17 as builder

# Create app directory
WORKDIR /app

# Clone the GitHub project
RUN git clone https://github.com/pashaoleynik97/service-oriented-sys-2.git .

# Build the project
RUN gradle build --no-daemon

# Final lightweight image
FROM openjdk:17-slim
WORKDIR /app

# Copy built jar
COPY --from=builder /app/build/libs/*.jar app.jar

# Add entrypoint
COPY entrypoint.sh .
RUN chmod +x entrypoint.sh

ENTRYPOINT ["./entrypoint.sh"]
