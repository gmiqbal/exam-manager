package com.gmiqbal.exammanager.repositories;

import com.gmiqbal.exammanager.entities.Exam;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExamRepo extends JpaRepository<Exam, Integer> {

}
