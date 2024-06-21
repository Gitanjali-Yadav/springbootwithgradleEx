# springbootwithgradleEx

implementation 'org.springdoc:springdoc-openapi-starter-webmvc-ui:2.5.0'
implementation 'io.swagger.core.v3:swagger-annotations-jakarta:2.2.21'

Application.properties file : -

spring.datasource.driver-class-name=com.mysql.jdbc.Driver
spring.datasource.url=jdbc:mysql://localhost:3306/springbootgradledb?createDatabaseIfNotExist=true
spring.datasource.username=
spring.datasource.password=
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQL8Dialect
spring.jpa.generate-ddl=true
spring.jpa.hibernate.ddl-auto=update
spring.jpa.hibernate.ddl=true
spring.jpa.show-sql=true