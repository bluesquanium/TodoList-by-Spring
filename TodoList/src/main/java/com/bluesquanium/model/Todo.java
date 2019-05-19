package com.bluesquanium.model;

import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;
import java.util.Date;

@Getter @Setter
@NoArgsConstructor @AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Todo { // {id, priority, desc, content, targetDate, isDone}을 저장.
    private int id;

    @Min(value = 0, message = "Possible Priority Range : [0 ~ 999]") @Max(value = 999, message = "Possible Priority Range : [0 ~ 999]")
    private int priority;

    private String user;

    @Size(min = 1, message = "Enter at least 1 character")
    private String desc;

    private String content;

    @Temporal(TemporalType.DATE)
    private Date targetDate;

    private boolean isDone;

    public boolean getIsDone() {
        return isDone;
    }

    public void setIsDone(boolean isDone) {
        this.isDone = isDone;
    }

}
