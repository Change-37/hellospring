package com.changeun.bssm.hellospring.repository;

import com.changeun.bssm.hellospring.domain.Student;
import com.changeun.bssm.hellospring.service.StudentService;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class MemoryStudentRepository implements StudentRepository {
    private static Map<Long, Student> store = new HashMap<>();

    @Override
    public Student save(Student student) {
        store.put(student.getId(), student);
        return store.get(student.getId());
    }

    @Override
    public Student findById(Long id) {
        return store.get(id);
    }
}
