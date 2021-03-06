package org.auk.data;

import org.auk.models.Student;

import java.util.List;

public class StudentRepository implements DataSourceInterface<Student> {

    private FileDataSourceImpl dataSource;
    private List<Student> studentList;

    public StudentRepository(int numberOfStudents) {
//        studentList = Faker.buildMockStudentsFromCollection(numberOfStudents);
//        studentList = Faker.buildMockStudentsFromFile();
        dataSource = new FileDataSourceImpl();
        studentList = dataSource.readAll();
    }

    public void refreshList() {
        studentList = dataSource.readAll();
    }

    public int getNextRecordId() {
        return dataSource.getNextRecordId();
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

    public void add(String studentData, boolean appendToFile) {
        dataSource.write(studentData, appendToFile);
        refreshList();
    }
}
