🏆 Challenge Alura Latam - FórumHub API
Este proyecto es el resultado del desafío propuesto por Alura Latam y Oracle, donde se implementa una API REST de un foro (FórumHub), construida con Spring Boot 3, aplicando buenas prácticas de seguridad, documentación y arquitectura limpia.

Repositorio oficial del proyecto 👉 ivanfr12/Api-ForoHub

🚀 Tecnologías utilizadas
✅ Java 17

✅ Spring Boot 3

✅ Spring Data JPA

✅ Spring Security con JWT

✅ MySQL

✅ Flyway (migraciones automáticas)

✅ Lombok

✅ Swagger OpenAPI (springdoc-openapi para documentación)

✅ Insomnia / Postman (para pruebas de endpoints)

🎯 Funcionalidades principales
📌 Registro y autenticación de usuarios mediante JWT

📌 CRUD completo para tópicos: crear, listar, actualizar y eliminar

📌 Endpoints adicionales para gestionar usuarios y respuestas

🔐 Seguridad con token JWT para proteger todas las rutas excepto /login

📝 Documentación interactiva con Swagger UI

🔐 Seguridad y autenticación
Para acceder a los recursos protegidos, primero debes autenticarte con:
POST /login

Enviando json:
{
  "login": "tu_usuario",
  "password": "tu_password"
}

Obtendrás un token JWT, que debes incluir en el header Authorization en las siguientes solicitudes:
Authorization: Bearer <token>

📖 Documentación con Swagger
Una vez la aplicación esté corriendo, puedes acceder a la documentación interactiva en:
http://localhost:8080/swagger-ui/index.html
Desde allí podrás explorar los endpoints y probarlos directamente.

🛠 Cómo ejecutar el proyecto
1️⃣ Clona este repositorio:
git clone https://github.com/ivanfr12/Api-ForoHub.git
cd Api-ForoHub

2️⃣ Configura tu base de datos MySQL en src/main/resources/application.properties:
spring.datasource.url=jdbc:mysql://localhost:3306/challenge_topicos
spring.datasource.username=tu_usuario
spring.datasource.password=tu_password

./mvnw spring-boot:run
o directamente desde tu IDE (IntelliJ / Eclipse).

✅ Flyway ejecutará las migraciones y creará las tablas automáticamente.

🚀 Principales endpoints
Método	URL	Descripción
POST	/login	Autentica y genera el token JWT
GET	/topicos	Lista todos los tópicos
POST	/topicos	Crea un nuevo tópico
PUT	/topicos/{id}	Actualiza un tópico existente
DELETE	/topicos/{id}	Elimina un tópico por ID
GET	/usuarios	Lista usuarios
GET	/respuestas	Lista respuestas del foro

👨‍💻 Autor
Desarrollado por ivanfr12 como parte del Challenge Oracle + Alura Latam.

🏅 Licencia
Este proyecto está licenciado bajo la MIT License. Consulta el archivo LICENSE para más detalles.
<img width="1579" height="835" alt="Captura de pantalla 2025-07-12 154421" src="https://github.com/user-attachments/assets/3e62e2eb-c4b9-4349-907f-edb28d6e080f" />
<img width="1904" height="910" alt="Captura de pantalla 2025-07-12 155346" src="https://github.com/user-attachments/assets/806a4def-9b0d-4ac6-949c-5d9dd12e75dd" />
<img width="1898" height="918" alt="Captura de pantalla 2025-07-12 154444" src="https://github.com/user-attachments/assets/e4ae35f3-32c7-4532-a891-206a3daeeed5" />


<img width="1024" height="1536" alt="ChatGPT Image 12 jul 2025, 03_56_39 p m" src="https://github.com/user-attachments/assets/d873779f-81cb-40db-aca5-0ef4f2ac9cf1" />
