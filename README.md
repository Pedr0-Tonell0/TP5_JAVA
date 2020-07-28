# TP5_JAVA

OBSERVACIONES1.
Crear un proyecto llamado TAREA5_GRUPO_X_LAB4
2.Debe  haber  una  clase  Principal  que  contenga  el  main  y SOLO  DEBE HABER UN MAIN EN TODO EL PROYECTO.
3.Crear el correcto diagrama de clases.
4.IMPORTANTE:   Para   aprobar   el   proyecto   tiene   que   tener   una organización de tipo tres capas(este tema fue visto en Programación III y tienen un ejemplo en el aula virtual llamado  Código: AppEscritorio_IV ,  para  que  investiguen  y  les  sirva  de  guía).
Se  pide  que  respeten  el nombre de los paquetes y utilicen interfaces.
5.Se  debe  utilizar  el  gestor  MySQL, ejecutar el  siguiente  script  sobre  el mismo:
CREATE DATABASE `bdPersonas`;USE bdPersonas;CREATE TABLE `Personas`(`Dni` varchar(20) NOT NULL,`Nombre` varchar(45) NOT NULL,`Apellido` varchar(45) NOT NULL,PRIMARY KEY (`Dni`));
Ejercicio
Se  pide  realizar  un  programa  que  lleve  un  registro  de  las  personas  que  se encuentran trabajando en la empresa.
En primer lugar, sedeberá generar un menú que contengan las siguientes opciones:
✓Agregar ✓Modificar✓Eliminar✓Listar.
Opción agregar
Si el usuario elije la opción agregar del menú, entonces se mostrarán cajas de texto para ingresar nombre, apellido y dni.
El  botón  aceptar  permite  guardar una  persona dentro  de la  base  de  datos, estos se guardarán solo si completaron los tres datos sino se le mostrará un mensaje aclaratorio.
Solo  se  podrán  ingresar  letras  sobre  el  JTextField  destinado  al  nombre  y apellido  de  la  persona. 
Solo  se  podrán  ingresar números sobre  el  JTextField destinado al dni de la persona. Para esto utilizarel evento keyListener,sobre las cajas de texto. 
Opción eliminar
El usuario podrá elegir un elemento del JList. Al hacer click sobre el botón eliminar, se eliminará el elemento seleccionadode la base y se lo quitará delJList.
Informar al usuario que el elemento se ha eliminado correctamente.
Opción modificar
Al  hacer  click  sobre  un  elemento  del  JList,  este  se  copiará  abajo  en  tres JTextField distintos uno para el nombre, otro para el apellido y el último para el  dni.  
Al  hacer  click  sobre  el  botón  modificar  se  guardarán  los  cambios realizadosen la base de datos y se limpiaron los JTextField.
Opción listar
Se mostrará la información de los usuarios sobre un JDataTable
