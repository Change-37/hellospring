package com.changeun.bssm.hellospring.repository;

import com.changeun.bssm.hellospring.domain.Student;

public interface StudentRepository {
    Student save(Student student);

    Student findById(Long id);
}
