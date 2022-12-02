package ru.hogwarts.schoolthree.Service;

import org.springframework.stereotype.Service;
import ru.hogwarts.schoolthree.Model.Faculty;
import ru.hogwarts.schoolthree.Model.Student;
import ru.hogwarts.schoolthree.Repositories.FacultyRepository;
import ru.hogwarts.schoolthree.Repositories.StudentRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Objects;

@Service
public class FacultyService {
    private final FacultyRepository facultyRepository;
    private final StudentRepository studentRepository;

    public FacultyService(FacultyRepository facultyRepository, StudentRepository studentRepository) {
        this.facultyRepository = facultyRepository;
        this.studentRepository = studentRepository;
    }

    public Faculty addFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public Faculty findFaculty(long id) {
        return facultyRepository.findById(id).get();
    }

    public Faculty editFaculty(Faculty faculty) {
        return facultyRepository.save(faculty);
    }

    public void deleteFaculty(long id) {
        facultyRepository.deleteById(id);
    }

    public Collection<Faculty> matchingFacultiesByColor(String color) {
        ArrayList<Faculty> resultFaculty = new ArrayList<>();
        for (Faculty faculty : facultyRepository.findAll()) {
            if (Objects.equals(faculty.getColor(), color)) {
                resultFaculty.add(faculty);
            }
        }
        return resultFaculty;
    }

    public Collection<Faculty> findByName(String name) {
        return facultyRepository.findFacultiesByNameIgnoreCase(name);
    }

    public Collection<Faculty> findByColor(String color) {
        return facultyRepository.findFacultiesByColorIgnoreCase(color);
    }

    public Collection<Student> listOfStudentsOfTheFaculty(long id) {
        Faculty faculty = findFaculty(id);
        return studentRepository.findByFacultiesId(faculty.getId());
    }
}
