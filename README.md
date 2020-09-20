# langtonAnt

langtonAnt is a spring boot api rest application, it will create a file with the langton ant algorithm following the stepNumber.

## Definition
Langton's ant is a two-dimensional universal Turing machine with a very simple set of rules but complex emergent behavior. It was invented by Chris Langton in 1986 and runs on a square lattice of black and white cells.[1] The universality of Langton's ant was proven in 2000.[2] The idea has been generalized in several different ways, such as turmites which add more colors and more states

Source : https://en.wikipedia.org/wiki/Langton%27s_ant

## Rules

Squares on a plane are colored variously either black or white. We arbitrarily identify one square as the "ant". The ant can travel in any of the four cardinal directions at each step it takes. The "ant" moves according to the rules below:

- At a white square, turn 90° clockwise, flip the color of the square, move forward one unit
- At a black square, turn 90° counter-clockwise, flip the color of the square, move forward one unit

Langton's ant can also be described as a cellular automaton, where the grid is colored black or white and the "ant" square has one of eight different colors assigned to encode the combination of black/white state and the current direction of motion of the ant.

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
in /target file a jar will be created after unit tests and IT tests will be launched (not forget to change application.properties values). This jar will be created langtonAnt-{version}, please rename it langtonAnt.jar and paste it where you want execute the project

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