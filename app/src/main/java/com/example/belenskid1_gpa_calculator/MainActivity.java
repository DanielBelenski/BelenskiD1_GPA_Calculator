package com.example.belenskid1_gpa_calculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //variable to remember if the screen fields are empty or not
    Boolean cleared = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //check method runs validation on all fields on the screen before computing the GPA
    public void check(View view){

        //validator to check the fields
        GradeValidator validator = new GradeValidator();

        //creating an object for each field and button
        EditText course1 = (EditText) findViewById(R.id.course1EditText);
        EditText course2 = (EditText) findViewById(R.id.course2EditText);
        EditText course3 = (EditText) findViewById(R.id.course3EditText);
        EditText course4 = (EditText) findViewById(R.id.course4EditText);
        EditText course5 = (EditText) findViewById(R.id.course5EditText);
        Button clearAndCompute = (Button) findViewById(R.id.clearAndComputeButton);
        TextView gpa = (TextView) findViewById(R.id.GPATextView);

        //booleans to store what fields are valid and which are not
        Boolean c1 = validator.validate(course1);
        Boolean c2 = validator.validate(course2);
        Boolean c3 = validator.validate(course3);
        Boolean c4 = validator.validate(course4);
        Boolean c5 = validator.validate(course5);

        //if fields were empty to start with
        if (cleared){

            //if all fields are currently valid and clear errors
            if (c1 && c2 && c3 && c4 &&c5){
                course1.setError(null);
                course2.setError(null);
                course3.setError(null);
                course4.setError(null);
                course5.setError(null);
                clearAndCompute.setText("Clear");
                compute(view);
                cleared = !cleared;
            }

            //else show what fields are no valid
            else{
                if(!c1){
                    course1.setError("Please input a valid grade");
                }
                if(!c2){
                    course2.setError("Please input a valid grade");
                }
                if(!c3){
                    course3.setError("Please input a valid grade");
                }
                if(!c4){
                    course4.setError("Please input a valid grade");
                }
                if(!c5){
                    course5.setError("Please input a valid grade");
                }
            }
        }

        //else clear all fields
        else{
            ConstraintLayout background = findViewById(R.id.background);
            course1.setText("");
            course2.setText("");
            course3.setText("");
            course4.setText("");
            course5.setText("");
            clearAndCompute.setText("Compute GPA");
            background.setBackgroundColor(Color.WHITE);
            gpa.setText("GPA");

            cleared = !cleared;
        }
    }

    //compute method to collect grade information and calculate the final average
    public void compute(View view){

        //creating objects for relevant fields
        EditText course1 = (EditText) findViewById(R.id.course1EditText);
        EditText course2 = (EditText) findViewById(R.id.course2EditText);
        EditText course3 = (EditText) findViewById(R.id.course3EditText);
        EditText course4 = (EditText) findViewById(R.id.course4EditText);
        EditText course5 = (EditText) findViewById(R.id.course5EditText);
        TextView gpa = (TextView) findViewById(R.id.GPATextView);
        ConstraintLayout background = findViewById(R.id.background);

        //getting the numeric grades from strings
        double grade1 = Double.parseDouble(course1.getText().toString());
        double grade2 = Double.parseDouble(course2.getText().toString());
        double grade3 = Double.parseDouble(course3.getText().toString());
        double grade4 = Double.parseDouble(course4.getText().toString());
        double grade5 = Double.parseDouble(course5.getText().toString());

        //calculating GPA
        double average = (grade1 + grade2 + grade3 + grade4 + grade5) / 5.0;
        gpa.setText(Double.toString(average));

        //evaluating response to the result
        if(average < 60)
            background.setBackgroundColor(Color.RED);
        else if(average < 80)
            background.setBackgroundColor(Color.YELLOW);
        else
            background.setBackgroundColor(Color.GREEN);
    }
}
