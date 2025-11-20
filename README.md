taskqualitynanager

Proyecto en Java con un pipeline de **CI** integrado en GitHub Actions.  
Incluye: **Checkstyle**, **JUnit 5**, **JaCoCo** y validación automaica de cobertura mínima (80%).

---

 Ejecución del proyecto

### Compilar:
mvn compile



Ejecutar pruebas:
mvn test



Validación completa (linter + pruebas + cobertura):
mvn verify



El reporte de cobertura se genera en:
target/site/jacoco/index.html



GitHub Actions

El workflow está en:

.github/workflows/ci-quality.yml




Se ejecuta en cada push y pull request.  
Incluye los pasos: checkout → Java 17 → linter → pruebas → cobertura → verificación del umbral.

Si algo falla, el pipeline se detine.



Ejecutar CI localmente con act


 Comando:
act -j build







Esto ejecuta el mismo workflow de Github local
