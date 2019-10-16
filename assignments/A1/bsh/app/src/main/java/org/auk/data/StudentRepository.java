package org.auk.data;

import org.auk.models.Student;
import org.auk.utils.Faker;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository implements DataSourceInterface<Student> {

    private List<Student> studentList;

    public StudentRepository(int numberOfStudents) {
//        studentList = Faker.buildMockStudentsFromCollection(numberOfStudents);
        studentList = Faker.buildMockStudentsFromFile(numberOfStudents);
    }

    public StudentRepository() {
        studentList = new ArrayList<>() ;
        //Faker.writeStudentsInFiles(studentList);
    }

    @Override
    public Student getById(int id) {
        for (Student s : studentList) {
            if (s.getId() == id) {
                return s;
            }
        }

        return null;
    }

    @Override
    public List<Student> getAll() {
        return studentList;
    }

    @Override
    public void add(Student s) {
        studentList.add(s);
    }

    @Override
    public void remove(int id) {
        studentList.remove(id);
    }
}
