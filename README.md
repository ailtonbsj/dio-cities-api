# Cities API with Spring and Postgree

## Postgres

```bash
# Create Postgre docker container official
docker run --name cities-db -d -p 5433:5432 -e POSTGRES_USER=postgres -e POSTGRES_PASSWORD=password -e POSTGRES_DB=cities postgres

# List of docker containers running
docker ps

# Show logs of container
docker logs cities-db

# Acess container
docker exec -it cities-db /bin/bash
# psql -U postgres cities
```

## Populate

```bash
cd ./psql-cities

# Map current folder to /tmp inside all containers based on postgres image
docker run -it --rm --net=host -v $PWD:/tmp postgres /bin/bash

# Use external port of your container
psql -h localhost -p 5433 -U postgres cities -f /tmp/pais.sql
psql -h localhost -p 5433 -U postgres cities -f /tmp/estado.sql
psql -h localhost -p 5433 -U postgres cities -f /tmp/cidade.sql

# Connect to postgree using CLI
psql -h localhost -p 5433 -U postgres cities
# \d                         <-- show tables
# \d pais;                   <-- show columns of table pais
# select * from pais;        <-- select data

# Enable postgre features (see documentation in references)
CREATE EXTENSION cube; 
CREATE EXTENSION earthdistance;
```

> Note: On heroku change host, port and database to cli remote access.

## Requirements

* Linux
* Git
* Java 8
* Docker
* IntelliJ Community
* Heroku CLI

## References

* [Postgres Docker Hub](https://hub.docker.com/_/postgres)
* [Postgres Earth distance](https://www.postgresql.org/docs/current/earthdistance.html)
* [earthdistance--1.0--1.1.sql](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.0--1.1.sql)
* [OPERATOR <@>](https://github.com/postgres/postgres/blob/master/contrib/earthdistance/earthdistance--1.1.sql)
* [postgrescheatsheet](https://postgrescheatsheet.com/#/tables)
* [datatype-geometric](https://www.postgresql.org/docs/current/datatype-geometric.html)