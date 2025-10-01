package com.devpatel.vcm.manager;

import com.devpatel.vcm.model.Classroom;
import com.devpatel.vcm.model.Student;
import com.devpatel.vcm.model.Assignment;
import com.devpatel.vcm.util.LoggerUtil;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

public class ClassroomManager {
    private static volatile ClassroomManager instance;
    private final Map<String, Classroom> classrooms = new ConcurrentHashMap<>();
    private final Logger logger = LoggerUtil.getLogger();

    private ClassroomManager() {}

    public static ClassroomManager getInstance() {
        if (instance == null) {
            synchronized (ClassroomManager.class) {
                if (instance == null) instance = new ClassroomManager();
            }
        }
        return instance;
    }

    public Classroom createClassroom(String name) {
        logger.info("Creating classroom: " + name);
        Classroom c = new Classroom(name);
        classrooms.putIfAbsent(name, c);
        return classrooms.get(name);
    }

    public boolean removeClassroom(String name) {
        logger.info("Removing classroom: " + name);
        return classrooms.remove(name) != null;
    }

    public Collection<Classroom> listClassrooms() {
        return classrooms.values();
    }

    public Optional<Classroom> getClassroom(String name) {
        return Optional.ofNullable(classrooms.get(name));
    }

    public void enrollStudent(String studentId, String className) {
        Classroom c = classrooms.get(className);
        if (c == null) throw new IllegalArgumentException("Classroom not found: " + className);
        c.addStudent(new Student(studentId));
        logger.info("Student " + studentId + " enrolled in " + className);
    }

    public void scheduleAssignment(String className, String title) {
        Classroom c = classrooms.get(className);
        if (c == null) throw new IllegalArgumentException("Classroom not found: " + className);
        Assignment a = new Assignment(title);
        c.addAssignment(a);
        logger.info("Assignment scheduled in " + className + ": " + title);
    }

    public void submitAssignment(String studentId, String className, String title) {
        Classroom c = classrooms.get(className);
        if (c == null) throw new IllegalArgumentException("Classroom not found: " + className);
        Student s = c.getStudent(studentId);
        if (s == null) throw new IllegalArgumentException("Student not enrolled in class: " + studentId);
        Assignment a = c.getAssignment(title);
        if (a == null) throw new IllegalArgumentException("Assignment not found: " + title);
        s.submit(title);
        logger.info("Student " + studentId + " submitted assignment '" + title + "' in " + className);
    }
}
