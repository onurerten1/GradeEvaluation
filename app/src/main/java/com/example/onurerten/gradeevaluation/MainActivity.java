package com.example.onurerten.gradeevaluation;

import android.content.Intent;
import android.renderscript.Double2;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputFilter;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText grade_1,grade_2,grade_final,per_1,per_2,per_final;
    TextView result_grade;
    Button button_calculate, button_refresh;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        grade_1=(EditText) findViewById(R.id.editText);
        grade_1.setFilters(new InputFilter[]{ new MinMax("0","100")});
        grade_2=(EditText) findViewById(R.id.editText5);
        grade_2.setFilters(new InputFilter[]{ new MinMax("0","100")});
        grade_final=(EditText) findViewById(R.id.editText7);
        grade_final.setFilters(new InputFilter[]{ new MinMax("0","100")});


        per_1=(EditText) findViewById(R.id.editText2);
        per_1.setFilters(new InputFilter[]{ new MinMax("1","100")});
        per_2=(EditText) findViewById(R.id.editText6);
        per_2.setFilters(new InputFilter[]{ new MinMax("1","100")});
        per_final=(EditText) findViewById(R.id.editText8);
        per_final.setFilters(new InputFilter[]{ new MinMax("1","100")});

        result_grade=(TextView) findViewById(R.id.textView6);

        button_calculate=(Button) findViewById(R.id.button);
        button_refresh=(Button) findViewById(R.id.button2);

    }

    public void evaluate(View view){
        calculate();
    }

    public void calculate(){
        Double value_g1 = Double.parseDouble(grade_1.getText().toString());
        Double value_g2 = Double.parseDouble(grade_2.getText().toString());
        Double value_gf = Double.parseDouble(grade_final.getText().toString());

        Double value_p1 = Double.parseDouble(per_1.getText().toString());
        Double value_p2 = Double.parseDouble(per_2.getText().toString());
        Double value_pf = Double.parseDouble(per_final.getText().toString());



        if(value_p1+value_p2+value_pf==100) {
            Double evaluatedValue = (value_g1 * value_p1 / 100) +
                    (value_g2 * value_p2 / 100) + (value_gf * value_pf / 100);

            result_grade.setText(evaluatedValue.toString());
        }
        else{
            result_grade.setText("Sum of percentages must be equal to 100");
        }


    }

    public void sendback(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }


}
