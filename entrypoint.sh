#!/bin/bash
set -e

echo "Waiting for PostgreSQL to be ready..."
until pg_isready -h "$ORDER_DB_HOST" -p "$ORDER_DB_PORT" -U "$ORDER_DB_USER"; do
  sleep 2
done

echo "PostgreSQL is ready. Starting application..."
exec java -jar app.jar