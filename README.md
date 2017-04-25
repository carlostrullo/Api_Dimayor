# Api_Dimayor

### Siga instrucciones para utilizar el proyecto correctamente

##### 1. Cree un directorio de prueba con el comando mkdir your directory
##### 2. Ingrese al directorio cd your directory
##### 3. Clone el proyecto git clone https://github.com/carlostrullo/Api_Dimayor
##### 4. Desde una terminal ingrese como usuario root y cambie los permisos de sus directorio chmod 777 -R your directory
##### 4. Ingrese a la carpeta Api_Dimayor/Frontend y borre la carpeta node_modules, luego ingrese a Api_Dimayor/backend y borre la caperta target.
##### 5. En la carpeta Api_Dimayor/ mwb se encuentra un archivo .mwb carguelo en su servidor de base de datos con mysql Workbench
##### 6. En el archivo backend/src/main/resources/META-INF/persistence.xml modifique la conexión a la base de datos de acuerdo a su configuración
```xml
    <property name="javax.persistence.jdbc.url" value="jdbc:mysql://your conection?zeroDateTimeBehavior=convertToNull"/>
			<!-- <property name="javax.persistence.jdbc.url" value="jdbc:mysql://localhost:3306/COMPUNUBE_1" /> -->
			<property name="javax.persistence.jdbc.user" value="root"/>
			<property name="javax.persistence.jdbc.driver" value="com.mysql.jdbc.Driver" />
      <property name="javax.persistence.jdbc.password" value="your password"/>
```
##### 8. Abra una terminal e ingrese a Api_Dimayor/Backend ejecute el comando mvn appengine:devserver
##### 7. Abra otra terminal e ingrese a Api_Dimayor/Frontend ejecute el comando npm install y luego npm start
##### 8. Si por primera vez da click a cualquier botón se puede demorar un par de segundos en responder el servidor, debido a que apenas está creando la conexión con la base de datos.
