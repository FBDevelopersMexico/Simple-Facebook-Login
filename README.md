# Simple-Facebook-Login
Simple Facebook Login usa el SDK de Facebook para tener acceso a los datos de la plataforma de una forma fácil y rápida. 

##Configuración 
Crear una aplicación nueva en https://developers.facebook.com -> My Apps -> Add a new app 
Sigue los pasos que se muestran y agrega los datos que se piden. 

**Generación de Key Hash**

Para lograr un uso exitoso del Facebook SDK se debe crear un key hash con los certificados (debug y/o producción)

  **MAC OS**
... 
keytool -exportcert -alias androiddebugkey -keystore ~/.android/debug.keystore | openssl sha1 -binary | openssl base64
...
  
  **Windows**
... 
keytool -exportcert -alias androiddebugkey -keystore %HOMEPATH%\.android\debug.keystore | openssl sha1 -binary | openssl     base64
...

Obteniedo la aplicación en la plataforma se puede tener el App Id el cuál debe de ser cambiado en el archivo values -> strings.xml 
...
<string name="facebook_app_id"></string>
...

Puedes reemplazar los datos de la aplicación recien creada dentro del proyecto
