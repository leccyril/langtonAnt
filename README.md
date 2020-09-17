# langtonAnt

langtonAnt is a spring boot api rest application, it will create a file with the langton ant algorithm following the stepNumber.

## Installation

prerequisite:

- Java 8 jdk

- Maven environment

- Git

Clone project to your environment with git :

```bash
git clone #project url
```

## Usage

Build the jar, at the root of project where pom.xml is located

```bash
mvn clean install
```
in /target file a jar will be created after unit tests and IT tests will be launched (not forget to change application.properties values). This jar will be created langtonAnt-0.0.1-SNAPSHOT, please rename it langtonAnt.jar and paste it where you want execute the project

then copy the file application.properties in the same folder and change values

 - server.port
 - application.file.path

then in command line in the jar folder

```bash
java -jar langtonAnt.jar
```

## Api rest usage

you can access to the api documentation here

http://localhost:{port}/swagger-ui.html

json documentation

http://localhost:{port}/v2/api-docs

with {port} the port you configured before

then make a put on the api (with curl command or a tool like postman)

http://localhost:{port}/api/{stepNumber}

where the {stepNumber} is the ant step, you will see the highway from 11000 steps.

then you can download file here 

http://localhost:{port}/api/download

the file is an infinite grid and will be resized following step number and size of cells walked

## Customization

Several properties are customizables

application.ant.orientation # ant first orientation
application.grid.color #the grid base color

application.grid.x.size #first grid size
application.grid.y.size #first grid size

server.port # server access port

application.file.path
application.file.name
application.file.format # result file conf


## Contributing
It is free project please not contribute. for bug please open ticket

## License
[MIT](https://choosealicense.com/licenses/mit/)