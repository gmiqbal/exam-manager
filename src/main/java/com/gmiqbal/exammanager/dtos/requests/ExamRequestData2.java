package com.gmiqbal.exammanager.dtos.requests;

import com.gmiqbal.exammanager.constants.DifficultyType;
import com.gmiqbal.exammanager.constants.ExamStatus;
import lombok.Data;

@Data
public class ExamRequestData2 {
    private String title;
    private String description;
    private DifficultyType difficulty;
    private ExamStatus status;
}
