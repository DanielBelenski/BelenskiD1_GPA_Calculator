package com.example.belenskid1_gpa_calculator;

import android.widget.EditText;

//class to validate a grade field
public class GradeValidator {

    //blank constructor
    public GradeValidator(){

    }

    //validation method
    //@param: EditText field to be evaluated
    //@return: boolean value of content validity
    public Boolean validate(EditText field){

        //getting text from object
        String gradeText = field.getText().toString();

        //getting numeric data from text
        double grade = Double.parseDouble(gradeText);

        //if there is no text
        if (gradeText.length() == 0)
            return false;

        //if number entered is too large
        else if (grade > 100)
            return false;

        //if number entered is too low
        else if (grade < 0)
            return false;

        //input is valid
        else
            return true;
    }
}
