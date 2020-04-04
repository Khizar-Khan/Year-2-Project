package com.khizar.year2groupproject.models;

import com.khizar.year2groupproject.MySQLConnector;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Assessment {
    private static final int offset = 3;
    private String Code;
    private String Title;
    private String Type;
    private Date Deadline;
    private String Weight;

    public String getCode() {
        return Code;
    }
    public void setCode(String code) {
        Code = code;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public Date getDeadline() {
        return Deadline;
    }

    public String getWeight() {
        return Weight;
    }

    public String getType() {
        return Type;
    }

    public void setDeadline(Date deadline) {
        Deadline = deadline;
    }

    public void setWeight(String weight) {
        Weight = weight;
    }

    public void setType(String type) {
        Type = type;
    }

    public static ArrayList<Assessment> GetBeforeDeadline(MySQLConnector connector, Date date)
    {
        ArrayList<String> data = connector.readAssessmentInformation();
        ArrayList<Assessment> assessments = new ArrayList<Assessment>();

        for(int i = 0; i < data.size(); i+= offset)
        {
            Assessment assessment = new Assessment();
            String type = data.get(i);
            String deadline = data.get(i + 1);
            String weight = data.get(i + 2);

            try
            {
                Date deadlineDate = new SimpleDateFormat("dd/MM/yyyy")
                        .parse(deadline);
                if (deadlineDate.compareTo(date) < 0)
                {
                    assessment.setType(type);
                    assessments.add(assessment);
                    assessment.setDeadline(deadlineDate);
                    assessment.setWeight(weight + "%");
                }
            }
            catch(ParseException ex)
            {
                //ignore assessments with invalid dates
            }

        }

        return assessments;
    }
}
