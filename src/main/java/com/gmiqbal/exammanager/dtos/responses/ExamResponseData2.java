package com.gmiqbal.exammanager.dtos.responses;

import com.gmiqbal.exammanager.constants.DifficultyType;
import com.gmiqbal.exammanager.constants.ExamStatus;
import lombok.Data;

import java.util.Date;

@Data
public class ExamResponseData2 {
    private Integer id;

    private String title;
    private String description;

    private DifficultyType difficulty;

    private ExamStatus status;

    private boolean isDeleted;

    private Date createdAt;

    private Date modifiedAt;
}
