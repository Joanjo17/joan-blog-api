## Configuración de base de datos y Ejecución Local
La base de datos y la aplicación backend se ejecutan dentro de contenedores Docker. La
configuración completa se encuentra en el docker-compose.yml.

Configura las variables de entorno para que pueda funcionar correctamente.
La Base de Datos (MySQL) se expone en el puerto 3307 y la API en el 8080.

Antes de ejecutar la aplicación, debes tener Docker y Docker Compose instalados.

Para ejecutar la API:
```
# Construye las imágenes y levanta los servicios
docker compose up --build

# Para ejecutar en segundo plano (detached):
# docker compose up -d

```