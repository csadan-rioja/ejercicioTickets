# Especificación Ejercicio Tickets

Version Java: JavaSE-10

Dependencias: 
* lombok: https://tidelift.com/subscription/pkg/maven-org-projectlombok-lombok?utm_source=maven-org-projectlombok-lombok&utm_medium=referral&campaign=website

## Descargar repositorio en nuestro ordenador
Para realizar los siguientes pasos primero debes instalar Git en tu ordenador (https://git-scm.com/book/es/v2/Inicio---Sobre-el-Control-de-Versiones-Instalaci%C3%B3n-de-Git)

1. Crear la carpeta donde queremos clonar el repositorio, es decir, la carpeta que queremos que contenga el código fuente que se encuentra en el repositorio.
2. Una vez situado dentro de la carpeta, ejecuta el siguiente comando para clonar el repositorio remoto:

```shell
git clone https://github.com/CarlosCSCJ/ejercicioTickets.git
```

Nota: internamente este comando ejecutará las instrucciones: (1) `git init` para inicializar el repositorio local; (2) `git remote add origin <url>` para asignarle un repositorio remoto; y (3) `git pull origin master` para traer el contenido del repositorio remoto.
