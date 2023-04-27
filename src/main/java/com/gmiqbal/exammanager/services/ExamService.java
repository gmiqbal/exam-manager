package com.gmiqbal.exammanager.services;

import com.gmiqbal.exammanager.constants.ExamStatus;
import com.gmiqbal.exammanager.entities.Exam;

import java.util.List;

public interface ExamService {
    Exam save(Exam exam);
    Exam getByID(Integer id);
    void delete(Exam exam);
    Exam saveWithExamStatus(Exam exam, ExamStatus examStatus);
    List<Exam> getAllBy (ExamStatus status);
}
