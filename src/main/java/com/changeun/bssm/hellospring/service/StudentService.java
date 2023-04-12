package com.changeun.bssm.hellospring.service;

import com.changeun.bssm.hellospring.domain.Student;
import com.changeun.bssm.hellospring.repository.MemoryStudentRepository;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    private final MemoryStudentRepository repository;

    public StudentService(MemoryStudentRepository repository) {
        this.repository = repository;
    }

    public Long edit(Student student){
        //1. 학번 중복 확인
        validateDuplicateStudent(student);
        //2. 학생등록
        Student saved = repository.save(student);
        System.out.println(saved.getId());
        return saved.getId();
    }

    private void validateDuplicateStudent(Student student) {
        if(repository.findById(student.getId()) != null) {
            throw new IllegalStateException("already exist");
        }
    }
}
