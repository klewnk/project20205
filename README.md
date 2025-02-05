Clone project

git clone https://github.com/klewnk/project20205.git




Database
you can create a free postgres database on https://render.com/
you can run a postgres with docker

docker run --name ds-lab-pg --rm \
  -e POSTGRES_PASSWORD=pass123 \
  -e POSTGRES_USER=dbuser \
  -e POSTGRES_DB=students \
  -d --net=host \
  -v pgdata:/var/lib/postgresql/data \
  postgres:16

Fix database connection in application.properties

spring.datasource.url=jdbc:postgresql://localhost:5432/students
spring.datasource.username=dbuser
spring.datasource.password=pass123

Run the project
mvn spring-boot:run
