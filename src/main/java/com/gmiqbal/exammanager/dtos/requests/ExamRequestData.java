package com.gmiqbal.exammanager.dtos.requests;

import com.gmiqbal.exammanager.constants.DifficultyType;
import com.gmiqbal.exammanager.constants.ExamStatus;
import lombok.Data;

import javax.validation.constraints.NotNull;

@Data
public class ExamRequestData {
    @NotNull
    private String title;
    @NotNull
    private String description;
    @NotNull
    private DifficultyType difficulty;
    @NotNull
    private ExamStatus status;
}
