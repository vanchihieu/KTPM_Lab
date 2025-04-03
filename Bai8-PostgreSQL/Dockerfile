FROM postgres:15

ENV POSTGRES_PASSWORD=mysecretpassword
ENV POSTGRES_USER=postgres
ENV POSTGRES_DB=postgres

COPY init.sql /docker-entrypoint-initdb.d/

EXPOSE 5432