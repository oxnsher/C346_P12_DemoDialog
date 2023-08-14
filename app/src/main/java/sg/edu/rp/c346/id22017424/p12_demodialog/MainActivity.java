package sg.edu.rp.c346.id22017424.p12_demodialog;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    // Show Simple Dialog Box - Step 1a
    Button btnDemo1;

    // Dialog Box that contains Button’s control - Step 1a
    Button btnDemo2;
    TextView tvDemo2;

    // Dialog Box that contains a text input field - Step 1a
    Button btnDemo3;
    TextView tvDemo3;

    // Dialog Box that contains 2 number input fields & shows the sum of the 2 numbers in TextView - Step 1a
    Button btnEx3;
    TextView tvEx3;

    // Dialog Box that allows the user to select month, day and year in a Calendar - Step 1a
    Button btnDemo4;
    TextView tvDemo4;

    // Dialog Box that allows the user to select time - Step 1a
    Button btnDemo5;
    TextView tvDemo5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Show Simple Dialog Box - Step 1b
        btnDemo1 = findViewById(R.id.buttonDemo1);

        // Dialog Box that contains Button’s control - Step 1b
        btnDemo2 = findViewById(R.id.buttonDemo2);
        tvDemo2 = findViewById(R.id.textViewDemo2);

        // Dialog Box that contains a text input field - Step 1b
        btnDemo3 = findViewById(R.id.buttonDemo3);
        tvDemo3 = findViewById(R.id.textViewDemo3);

        // Dialog Box that contains 2 number input fields & shows the sum of the 2 numbers in TextView - Step 1b
        btnEx3 = findViewById(R.id.buttonExercise3);
        tvEx3 = findViewById(R.id.textViewExercise3);

        // Dialog Box that allows the user to select month, day and year in a Calendar - Step 1b
        btnDemo4 = findViewById(R.id.buttonDemo4);
        tvDemo4 = findViewById(R.id.textViewDemo4);

        // Dialog Box that allows the user to select time - Step 1b
        btnDemo5 = findViewById(R.id.buttonDemo5);
        tvDemo5 = findViewById(R.id.textViewDemo5);

        // Show Simple Dialog Box - Step 2
        btnDemo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create Dialog Builder
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);

                // Set Dialog Details
                /*
                myBuilder.setTitle("DEMO 1 - Simple Dialog");
                myBuilder.setMessage("I can develop Android Apps.");
                myBuilder.setCancelable(false);
                myBuilder.setPositiveButton("Close", null);
                */
                myBuilder.setTitle("Congratulations");
                myBuilder.setMessage("You have completed a simple Dialog Box!");
                myBuilder.setCancelable(true); // true allows it to be cancelled by allowing user to click outside the box
                myBuilder.setPositiveButton("Close", null);

                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        // Dialog Box that contains Button’s control - Step 2
        btnDemo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setTitle("Demo 2 Buttons Dialog");
                myBuilder.setMessage("Select one of the Buttons below");
                myBuilder.setCancelable(false);

                // Configure the 'negative' button
                myBuilder.setNegativeButton("NO", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Negative.");
                    }
                });

                // Configure the 'positive' button
                myBuilder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        tvDemo2.setText("You have selected Positive.");
                    }
                });

                // Configure the 'neutral' button
                myBuilder.setNeutralButton("Cancel", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        // Dialog Box that contains a text input field - Step 2
        btnDemo3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Inflate the input.xml layout file
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input, null);

                // Obtain the UI component in the input.xml layout
                // It needs to be defined as "final", so that it can used in the onClick() method later
                final EditText etInput = viewDialog.findViewById(R.id.editTextInput);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Demo 3-Text Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the text entered by the user
                        String message = etInput.getText().toString();
                        // Set the text to the TextView
                        tvDemo3.setText(message);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        // Dialog Box that contains 2 number input fields & shows the sum of the 2 numbers in TextView - Step 2
        btnEx3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Inflate the input2.xml layout file
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                View viewDialog = inflater.inflate(R.layout.input2, null);

                // Obtain the UI components in the input2.xml layout
                // They need to be defined as "final" so that they can be used in the onClick() method later
                final EditText etNum1 = viewDialog.findViewById(R.id.editTextNum1);
                final EditText etNum2 = viewDialog.findViewById(R.id.editTextNum2);

                AlertDialog.Builder myBuilder = new AlertDialog.Builder(MainActivity.this);
                myBuilder.setView(viewDialog);  // Set the view of the dialog
                myBuilder.setTitle("Exercise 3 - Number Input Dialog");
                myBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // Extract the numbers entered by the user
                        int num1 = Integer.parseInt(etNum1.getText().toString());
                        int num2 = Integer.parseInt(etNum2.getText().toString());

                        // Calculate the sum
                        int sum = num1 + num2;

                        // Set the sum to the TextView
                        tvEx3.setText("The sum is " + sum);
                    }
                });
                myBuilder.setNegativeButton("CANCEL", null);
                AlertDialog myDialog = myBuilder.create();
                myDialog.show();
            }
        });

        // Dialog Box that allows the user to select month, day and year in a Calendar - Step 2
        btnDemo4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a Calendar instance to get the current date
                Calendar calendar = Calendar.getInstance();
                int year = calendar.get(Calendar.YEAR);
                int month = calendar.get(Calendar.MONTH);
                int day = calendar.get(Calendar.DAY_OF_MONTH);

                // Create the Listener to set the date
                DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        tvDemo4.setText("Date: " + dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                    }
                };

                // Create the Date Picker Dialog with the current date as the default
                DatePickerDialog myDatePickerDialog = new DatePickerDialog(MainActivity.this, myDateListener, year, month, day);
                myDatePickerDialog.show();
            }
        });

        // Dialog Box that allows the user to select time - Step 2
        btnDemo5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create a Calendar instance to get the current time
                Calendar calendar = Calendar.getInstance();
                int hour = calendar.get(Calendar.HOUR_OF_DAY);
                int minute = calendar.get(Calendar.MINUTE);

                // Create the Listener to set the time
                TimePickerDialog.OnTimeSetListener myTimeListener = new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        tvDemo5.setText("Time: " + hourOfDay + ":" + minute);
                    }
                };

                // Create the Time Picker Dialog with the current time as the default
                TimePickerDialog myTimeDialog = new TimePickerDialog(MainActivity.this, myTimeListener, hour, minute, false);
                myTimeDialog.show();
            }
        });

    }
}