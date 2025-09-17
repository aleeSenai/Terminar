# Use uma imagem oficial do Java
FROM eclipse-temurin:21-jre

# Crie um diretório para a aplicação
WORKDIR /app

# Copie o jar gerado para dentro do container
COPY target/*.jar app.jar

# Exponha a porta padrão do Spring Boot
EXPOSE 8080

# Comando para rodar a aplicação
ENTRYPOINT ["java", "-jar", "app.jar"]