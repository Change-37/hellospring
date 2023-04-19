package com.changeun.bssm.hellospring.service;

import com.changeun.bssm.hellospring.domain.Student;
import com.changeun.bssm.hellospring.repository.MemoryStudentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

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

    public List<Student> findStudents() {
        return repository.findAll();
    }

    public Student findById(Long id) {
        return repository.findById(id);
    }

    public void updateStudent(Student updateStudent) {
        // 1. store에서 student 찾아옴
        Student student = repository.findById(updateStudent.getId());

        student.setScore(updateStudent.getScore());
    }
}
