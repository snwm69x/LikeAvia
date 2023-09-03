# Используем базовый образ с установленной JDK 11
FROM maven:3.8.1-openjdk-17-slim

# Устанавливаем рабочую директорию
WORKDIR /likevavo

# Копируем файлы проекта в Docker-образ
COPY . .

# Собираем проект с помощью Maven
RUN mvn clean package


# Копируем скомпилированные файлы в Docker-образ
COPY target/likevavo-0.0.1-SNAPSHOT.jar .

# Устанавливаем переменные окружения для подключения к базе данных PostgreSQL
ENV POSTGRES_URL jdbc:postgresql://postgres:5432/blabla
ENV POSTGRES_USER postgres
ENV POSTGRES_PASSWORD admin

# Открываем порт 8080 для приложения
EXPOSE 8080

# Запускаем приложение при запуске Docker-образа
CMD ["java", "-jar", "likevavo-0.0.1-SNAPSHOT.jar"]