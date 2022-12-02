package ru.hogwarts.schoolthree.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.schoolthree.Model.Faculty;
import ru.hogwarts.schoolthree.Model.Student;
import ru.hogwarts.schoolthree.Repositories.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class StudentService {
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public Student addStudent(Student student) {
        return studentRepository.save(student);
    }

    public Student findStudent(long id) {
        return studentRepository.findById(id).get();
    }

    public Student editStudent(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Collection<Student> coincidencesStudentsByAge(int age) {
        ArrayList<Student> resultStudent = new ArrayList<>();
        for (Student student : studentRepository.findAll()) {
            if (student.getAge() == age) {
                resultStudent.add(student);
            }
        }
        return resultStudent;
    }

    public Collection<Student> findByAgeBetween(int min, int max) {
        return studentRepository.findByAgeBetween(min, max);
    }

    public String listOfFacultiesOfTheStudent(long id) {
        Student student = findStudent(id);
        Faculty faculty = student.getFaculties();
        return faculty.getName();
    }
}
