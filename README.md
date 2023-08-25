# test_gl
Este test es un proyecto Spring Boot

Ocupé Spring Boot 2.7.14 porque no se especificaba version y traté de usar algo compatible con Java 8, que si se solicitaba.

No me quedó claro si la solicitud de usar Java 8 significaba usar exclusivamente esa versión o se refería a "cualquier versión posterior a Java 8", ya que esa versión incorporó un montón de nuevas funcionalidades. Opté por usar sourceCompatibility = '1.8' y aunque en mi entorno tengo Java 15, esa opción se asegura de que el código sea compatible.
En la única ocasión que encontré algo que versiones posteriores de Java 8 hacian mejor, lo dejé comentado a modo de ejemplo.

El proyecto lo realicé en IntelliJ Ultimate, con H2 in memory (no persiste después de reiniciar el proyecto, lo que permite no ensuciar la base de datos al probarlo)
