# cs3560Assignment1
  Contains: 
  - `src`: the folder to maintain sources
  - `lib`: the folder to maintain dependencies

# File/Class Strucutre
  Has: 
  - `Student`: object class that will create a Student with a random Student ID, will also have ability to submit an answer
  - `Question`: created as an interface that will get the question as a text, get the answer, and check if its valid answer
  - `SingelChoice:` implments Question interface and implments the methods from it inside the Question file
  - `MultiChoice`: implments Question interface and implments the methods from it inside the Question file
  - `Voting Service`: generates the strcutes that will store the answers as a HashMap, and will have the functions to print the statistics and submit answers
  - `SimulationDriver`: will call following classes and simulate an example of students and answers
  
  
