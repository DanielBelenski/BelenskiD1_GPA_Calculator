package com.example.belenskid1_gpa_calculator;

import android.widget.EditText;

public class GradeValidator {
    public GradeValidator(){

    }
    public Boolean validate(EditText field){
        String gradeText = field.getText().toString();
        double grade = Double.parseDouble(gradeText);
        if (gradeText.length() == 0)
            return false;
        else if (grade > 100)
            return false;
        else if (grade < 0)
            return false;
        else
            return true;
    }
}
