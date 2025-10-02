# Educational Initiatives — Coding Exercises (Java)

This repository contains **two exercises** implemented in **Java**.  
The code is organized into two separate folders:

```
.
├── Exercise_1/
│   └── src/main/java/com/devpatel/designpatterns/...
│
└── Exercise_2/
    └── src/main/java/com/devpatel/vcm/...
```

---

## 🔹 Exercise 1: Design Patterns

Demonstrates **six different use cases** for design patterns:

- **Behavioral Patterns**
  - Strategy → Attendance validation strategies
  - Observer → Students notified when assignments are scheduled
- **Creational Patterns**
  - Factory Method → Classroom creation
  - Singleton → Configuration management
- **Structural Patterns**
  - Adapter → Legacy attendance system integration
  - Decorator → Notification service enhancement

Each pattern includes:
- A set of classes under `src/main/java/com/devpatel/designpatterns/...`

### Run Example

```bash
cd Exercise_1
mkdir out
Get-ChildItem -Recurse -Filter *.java -Path .\src\main\java | ForEach-Object { $_.FullName } > sources.txt
javac -d out (Get-Content sources.txt)
java -cp out com.devpatel.designpatterns.Main

```
---

## 🔹 Exercise 2: Virtual Classroom Manager (Console - Java)

A **terminal-based Virtual Classroom Manager** simulating the backend of an EdTech platform.

### Features
- Add / remove / list classrooms  
- Enroll students into classrooms  
- Schedule assignments per classroom  
- Submit assignments per student  
- Logging, exception handling, Command Pattern for parsing  
- Managers implemented as thread-safe **Singletons**  

### Commands
- `add_classroom <className>`
- `remove_classroom <className>`
- `list_classrooms`
- `add_student <studentId> <className>`
- `list_students <className>`
- `schedule_assignment <className> <assignmentTitle>`
- `list_assignments <className>`
- `submit_assignment <studentId> <className> <assignmentTitle>`
- `help`
- `exit`

### Run Example

```bash
cd Exercise_2
mkdir out
Get-ChildItem -Recurse -Filter *.java -Path .\src\main\java | ForEach-Object { $_.FullName } > sources.txt
javac -d out (Get-Content sources.txt)
java -cp out com.devpatel.vcm.Main
```
### Sample Session

> add_classroom Math101
Classroom Math101 has been created.

> add_student S001 Math101
Student S001 has been enrolled in Math101.

> schedule_assignment Math101 Homework1
Assignment for Math101 has been scheduled.

> submit_assignment S001 Math101 Homework1
Assignment submitted by Student S001 in Math101.
```

---

## 🏗️ Tech & Practices Used
- Language: **Java 18**
- Principles: **OOP, SOLID, Defensive Programming**
- Patterns: **Behavioral, Creational, Structural**
- Gold Standards: **Logging, Exception Handling, Retry/Transient Error Handling**

---