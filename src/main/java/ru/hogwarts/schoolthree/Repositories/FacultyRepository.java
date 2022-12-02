package ru.hogwarts.schoolthree.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.hogwarts.schoolthree.Model.Faculty;

import java.util.Collection;

public interface FacultyRepository extends JpaRepository<Faculty, Long> {

    Collection<Faculty> findFacultiesByNameIgnoreCase(String name);

    Collection<Faculty> findFacultiesByColorIgnoreCase(String color);
}
