package com.gmiqbal.exammanager.controllers;

import com.gmiqbal.exammanager.dtos.requests.ExamEditRequestData;
import com.gmiqbal.exammanager.entities.Exam;
import com.gmiqbal.exammanager.repositories.ExamRepo;
import com.gmiqbal.exammanager.repositories.ExamRepo2;
import io.swagger.annotations.ApiOperation;
import com.gmiqbal.exammanager.dtos.requests.ExamRequestData;
import com.gmiqbal.exammanager.dtos.requests.ExamRequestData2;
import com.gmiqbal.exammanager.dtos.responses.ExamResponseData;
import com.gmiqbal.exammanager.dtos.responses.ExamResponseData2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/exams")

public class ExamController {

    @Autowired
    ExamRepo2 examRepo2;

    @Autowired
    ExamRepo examRepo;   //ExamRepo examRepo = new ExamRepo();


    @ApiOperation(value = "create exam")
    @PostMapping("")
    //need method
    public ExamResponseData createExam(@RequestBody @Valid ExamRequestData examRequestData) {


        Exam exam = new Exam();
        exam.setTitle(examRequestData.getTitle());
        exam.setDescription(examRequestData.getDescription());
        exam.setDifficulty(examRequestData.getDifficulty());
        exam.setStatus(examRequestData.getStatus());

        System.out.println(exam.getDifficulty());

        //exam holo bag of data tobe sent to mr. database

        //examRepo deliverPerson who will take 'exam'(bag) to mr. database

        Exam savedExamPhotographFromDeliveryPerson = examRepo.save(exam);

//        System.out.println(savedExamPhotographFromDeliveryPerson.getId());
//        System.out.println(savedExamPhotographFromDeliveryPerson.getCreatedAt());
//        System.out.println(savedExamPhotographFromDeliveryPerson.getTitle());

        Exam savedExam = savedExamPhotographFromDeliveryPerson;


        ExamResponseData examResponseData = new ExamResponseData();

        examResponseData.setCreatedAt(savedExam.getCreatedAt());
        examResponseData.setDescription(savedExam.getDescription());
        examResponseData.setId(savedExam.getId());
        examResponseData.setStatus(savedExam.getStatus());
        examResponseData.setTitle(savedExam.getTitle());
        examResponseData.setDifficulty(savedExam.getDifficulty());

        return examResponseData;
    }


    @PostMapping("/exams2")
    public ExamResponseData2 createExam2(@RequestBody @Valid ExamRequestData2 examRequestData2) {
        Exam exam2 = new Exam();
        exam2.setTitle(examRequestData2.getTitle());
        exam2.setDescription(examRequestData2.getDescription());
        exam2.setDifficulty(examRequestData2.getDifficulty());
        exam2.setStatus(examRequestData2.getStatus());

        Exam examSaved = examRepo2.save(exam2);

        ExamResponseData2 examResponseData2 = new ExamResponseData2();
        examResponseData2.setId(examSaved.getId());
        examResponseData2.setTitle(examSaved.getTitle());
        examResponseData2.setDescription(examSaved.getDescription());
        examResponseData2.setStatus(examSaved.getStatus());
        examResponseData2.setDifficulty(examSaved.getDifficulty());
        examResponseData2.setCreatedAt(examSaved.getCreatedAt());

        return examResponseData2;
    }

    @GetMapping("")
    public List<ExamResponseData> viewExam() {
        //return kora jinish ke assign korte hobe

        List<Exam> examList = examRepo.findAll();

        List<ExamResponseData> examResponseDataList = new ArrayList<>();
        for (Exam savedExam : examList) {

            ExamResponseData examResponseData = new ExamResponseData();

            examResponseData.setCreatedAt(savedExam.getCreatedAt());
            examResponseData.setDescription(savedExam.getDescription());
            examResponseData.setId(savedExam.getId());
            examResponseData.setStatus(savedExam.getStatus());
            examResponseData.setTitle(savedExam.getTitle());
            examResponseData.setDifficulty(savedExam.getDifficulty());

            examResponseDataList.add(examResponseData);
        }

        return examResponseDataList;

    }


    @PutMapping("")
    //need method
    public ExamResponseData editExam(@RequestBody ExamEditRequestData examEditRequestData) {

        Exam currentlySavedExam = examRepo.findById(examEditRequestData.getId()).orElse(null);

        if (currentlySavedExam == null) {
            ExamResponseData examResponseData = new ExamResponseData();
            //empty object return
            return examResponseData;
        } else {
            if (examEditRequestData.getTitle() != null) {
                currentlySavedExam.setTitle(examEditRequestData.getTitle());
            }
            if (examEditRequestData.getDescription() != null) {
                currentlySavedExam.setDescription(examEditRequestData.getDescription());
            }
            if (examEditRequestData.getDifficulty() != null) {
                currentlySavedExam.setDifficulty(examEditRequestData.getDifficulty());
            }
            if (examEditRequestData.getStatus() != null) {
                currentlySavedExam.setStatus(examEditRequestData.getStatus());
            }

            Exam updatedExam = examRepo.save(currentlySavedExam);


            ExamResponseData examResponseData = new ExamResponseData();

            examResponseData.setCreatedAt(updatedExam.getCreatedAt());
            examResponseData.setDescription(updatedExam.getDescription());
            examResponseData.setId(updatedExam.getId());
            examResponseData.setStatus(updatedExam.getStatus());
            examResponseData.setTitle(updatedExam.getTitle());
            examResponseData.setDifficulty(updatedExam.getDifficulty());

            return examResponseData;

        }

    }

    @DeleteMapping("/{id}")

    public String deleteExam(@PathVariable("id") int id) {

        Exam currentlySavedExam = examRepo.findById(id).orElse(null);

        if (currentlySavedExam == null) {
            return "Sorry db does not have any exam row with this id";
        } else {
            examRepo.delete(currentlySavedExam);
            return "Exam row with id " + id + " succesfully deleted from database";
        }

    }
}
