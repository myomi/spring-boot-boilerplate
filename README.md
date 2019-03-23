# Spring Boot Boilerplate
- Spring Boot2
- PostgreSQL11 with Docker
- Lombok
- Doma2

## How to create Spring Boot Project
### (1) init boot project
```
spring init --build=gradle --java-version=11 --dependencies="web,jdbc,devtools,postgresql" spring-boot-boilerplate
```

### (2) Create Database
- Dockerfile
- docker-compose.yml
- create-db.sh
- create ER diagram
- create sql file

startup:
```
docker-compose up -d --build
```

shutdown
```
docker-compose down -v
```

### (3) application.properties
```
spring.datasource.driver-class-name=org.postgresql.Driver
spring.datasource.url=jdbc:postgresql://localhost:5432/testdb
spring.datasource.username=db_user
spring.datasource.password=abcd1234
```

### (4) Lombok
https://projectlombok.org/setup/gradle

```
dependencies {
	compileOnly 'org.projectlombok:lombok:1.18.6'
	annotationProcessor 'org.projectlombok:lombok:1.18.6'
}
```

### (5) Doma
https://doma.readthedocs.io/en/stable/build/#build-with-gradle

```
task copyDomaResources(type: Sync)  {
    from sourceSets.main.resources.srcDirs
    into compileJava.destinationDir
    include 'doma.compile.config'
    include 'META-INF/**/*.sql'
    include 'META-INF/**/*.script'
}

compileJava {
    // Depend on the above task
    dependsOn copyDomaResources
    options.encoding = 'UTF-8'
}

compileTestJava {
    options.encoding = 'UTF-8'
    // Disable the annotation processors during the test run
    options.compilerArgs = ['-proc:none']
}

dependencies {
    annotationProcessor "org.seasar.doma:doma:2.24.0"
    implementation "org.seasar.doma:doma:2.24.0"
}
```

- Eclipse Setting
https://doma.readthedocs.io/en/stable/getting-started-eclipse/
https://doma.readthedocs.io/en/stable/annotation-processing/#setting-options-in-eclipse

### (6) Doma Gen
https://doma-gen.readthedocs.io/en/stable/gen/#run-with-gradle


- Create doma-template folder
- Add some settings as below
```
def dbUrl = 'jdbc:postgresql://127.0.0.1:5432/testdb'
def dbUser = 'db_user'
def dbPassword = 'abcd1234'
def basePackage = 'com.example.springbootboilerplate'

configurations {
    domaGenRuntime
}

dependencies {
	// Doma-Gen
	domaGenRuntime "org.seasar.doma:doma-gen:${domaVersion}"
    domaGenRuntime 'org.postgresql:postgresql'
}

task domaGen {
    group = 'doma-gen'
    doLast {
        ant.taskdef(resource: 'domagentask.properties',
            classpath: configurations.domaGenRuntime.asPath)
        ant.gen(
        	url: "${dbUrl}",
			user: "${dbUser}",
			password: "${dbPassword}",
			versionColumnNamePattern: 'version',
			templatePrimaryDir: 'doma-template'
        ) {
	        entityConfig(
				packageName: "${basePackage}.entity",
				overwrite: true,
				overwriteListener: true
			)
	        daoConfig(
				packageName: "${basePackage}.dao",
				overwrite: true,
			)
	        sqlConfig(
				overwrite: true,
			)
        }
    }
}

task domaGenTestCases {
    group = 'doma-gen'
    doLast {
        ant.taskdef(resource: 'domagentask.properties',
            classpath: configurations.domaGenRuntime.asPath)
        ant.gen(
        	url: "${dbUrl}",
			user: "${dbUser}",
			password: "${dbPassword}",
        ) {
            sqlTestCaseConfig {
                fileset(dir: 'src/main/resources') {
                    include(name: 'META-INF/**/*.sql')
                }
            }
        }
    }
}
```

doma-template/lib.ftl
```
<#assign annotationHash={ "ConfigAutowireable": "org.seasar.doma.boot.ConfigAutowireable" }>
```

doma-template/dao.ftl
```
<#list lib.annotationHash?values as annotationImportName>
import ${annotationImportName};
</#list>


<#list lib.annotationHash?keys as annotation>
@${annotation}
</#list>
```