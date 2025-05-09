#!/bin/bash
set -e

echo "Cleaning previous app source..."
rm -rf app-source

echo "Cloning fresh source code..."
git clone https://github.com/pashaoleynik97/service-oriented-sys-2.git app-source

echo "Waiting for PostgreSQL to be ready..."
until pg_isready -h "$ORDER_DB_HOST" -p "$ORDER_DB_PORT" -U "$ORDER_DB_USER"; do
  sleep 2
done

echo "PostgreSQL is ready. Building application..."
cd app-source
chmod +x gradlew
./gradlew bootJar

echo "Running the application..."
java -jar build/libs/orderservice-0.0.1-SNAPSHOT.jar