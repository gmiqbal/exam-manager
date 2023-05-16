package com.gmiqbal.exammanager.dtos.requests;

import com.gmiqbal.exammanager.constants.DifficultyType;
import com.gmiqbal.exammanager.constants.ExamStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ExamEditRequestData {

    private Integer id;

    private String title;

    private String description;

    private DifficultyType difficulty;

    private ExamStatus status;
}
