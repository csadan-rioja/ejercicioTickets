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

## Abrir proyecto en Eclipse

1. Abrimos el cuadro de dialogo para crear un proyecto Java (File > New > Java Project) 
2. Ponemos el nombre que queramos al proyecto (Project name)
3. Deseleccionamos el checkbox Use default location. En location buscaremos la carpeta donde se ha descargado el proyecto de github. Es importante que selecciones la carpeta padre de *src*.  
4. Una vez seleccionado correctamente la localización del proyecto, ya podemos hacer clic en finalizar. 

Al crearse el proyecto es normal que salgan errores. Esto es debido a dos cosas:
* las dependencias (lombock.jar) no se encuentran en el repositorio. Debes descargarlas e importarlas correctamente. 
* la versión de java puede que no sea la que tienes instalada en tu ordenador. 

Ambos problemas los puedes resolver haciendo clic derecho sobre el proyecto en Eclipse > Build path > Configure Build Path... y entrando en la pestaña Libraries. Desde aquí puedes cambiar la versión de Java a la que tu desees y seleccionar la ruta donde se encuentra lombok.jar. 
