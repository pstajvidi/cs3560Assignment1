## Getting Started

Welcome to the VS Code Java world. Here is a guideline to help you get started to write Java code in Visual Studio Code.

## Folder Structure

The workspace contains two folders by default, where:

- `src`: the folder to maintain sources
- `lib`: the folder to maintain dependencies

Meanwhile, the compiled output files will be generated in the `bin` folder by default.

> If you want to customize the folder structure, open `.vscode/settings.json` and update the related settings there.

## Dependency Management

The `JAVA PROJECTS` view allows you to manage your dependencies. More details can be found [here](https://github.com/microsoft/vscode-java-dependency#manage-dependencies).
# cs3560Assignment1
  Contains: 
  - `src`: the folder to maintain sources
  - `lib`: the folder to maintain dependencies

# File Strucutre
  Has: 
  -Student: object class that will create a Student with a random Student ID, will also have ability to submit an answer
  -Question: created as an interface that will get the question as a text, get the answer, and check if its valid answer
      -SingelChoice: implments Question interface and implments the methods from it
      -MultiChoice: implments Question interface and implments the methods from it
  -Voting Service: generates the strcutes that will store the answers as a HashMap, and will have the functions to print the              statistics and submit answers
  -SimulationDriver: will call following classes and simulate an example of students and answers
  
  
