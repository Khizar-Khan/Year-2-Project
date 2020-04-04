package com.khizar.year2groupproject.models;

import com.khizar.year2groupproject.MySQLConnector;
import com.khizar.year2groupproject.Utils.DateUtil;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Assessment {
    private static final int offset = 5;
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

    public static ArrayList<Assessment> GetBetween(MySQLConnector connector, Date startDate, Date endDate)
    {
        ArrayList<String> data = connector.readAllAssessmentInformation();
        ArrayList<Assessment> assessments = new ArrayList<Assessment>();

        for(int i = 0; i < data.size(); i+= offset)
        {
            Assessment assessment = new Assessment();
            String code = data.get(i);
            String title = data.get(i + 1);
            String type = data.get(i + 2);
            String deadline = data.get(i + 3);
            String weight = data.get(i + 4);

            Date deadlineDate = DateUtil.GetDate(deadline, null);
            if (DateUtil.IsDateInRange(deadlineDate, startDate, endDate))
            {
                assessment.setCode(code);
                assessment.setTitle(title);
                assessment.setType(type);
                assessment.setDeadline(deadlineDate);
                assessment.setWeight(weight + "%");
                assessments.add(assessment);
            }
        }

        return assessments;
    }
}
