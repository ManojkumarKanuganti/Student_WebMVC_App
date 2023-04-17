package in.manoj.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import in.manoj.entity.StudentEntity;

public interface StudentRepository  extends JpaRepository<StudentEntity, Integer>{

}
