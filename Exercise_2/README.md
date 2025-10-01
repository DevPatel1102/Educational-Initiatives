# Virtual Classroom Manager (Console - Java)

Terminal-based Virtual Classroom Manager. Features:
- Add / remove / list Classrooms
- Enroll students into classrooms
- Schedule assignments for classrooms
- Submit assignments for students
- Logging, exception handling, Command pattern to parse user commands
- Managers implemented as thread-safe Singletons

Run (Maven):
```
mvn clean package
java -jar target/virtual-classroom-manager-1.0-SNAPSHOT-jar-with-dependencies.jar
```

Commands:
- add_classroom <className>
- remove_classroom <className>
- list_classrooms
- add_student <studentId> <className>
- list_students <className>
- schedule_assignment <className> <assignmentTitle>
- list_assignments <className>
- submit_assignment <studentId> <className> <assignmentTitle>
- help
- exit
