package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    private static final Pattern PASSWORD_PATTERN =
            Pattern.compile("^" +
                    "(?=.*[@#$%^&+=])" +     // at least 1 special character
                    "(?=\\S+$)" +            // no white spaces
                    ".{6,}" +                // at least 4 characters
                    "$");
    private static final String FILE_NAME = "MY_FILE_NAME";
    Button onClick;
    EditText editText;
    EditText editText2;
    EditText editText3;
    EditText editText4;
    EditText editText5;
    EditText editText6;
    SharedPreferences mySP;
    SharedPreferences.Editor editor;
    Button btnSave;
    Button btnLoad;
    final String SAVE_TEXT = "save text";
    final String SAVE_TEXT1 = "save text1";
    final String SAVE_TEXT2 = "save text2";
    final String SAVE_TEXT3 = "save text3";
    final String SAVE_TEXT4 = "save text4";
    final String SAVE_TEXT5 = "save text5";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.et_name);
        editText2 = (EditText) findViewById(R.id.et_lastname);
        editText3 = (EditText) findViewById(R.id.patronymic);
        editText4 = (EditText) findViewById(R.id.et_email);
        editText5 = (EditText) findViewById(R.id.et_password);
        editText6 = (EditText) findViewById(R.id.et_replay);


    }
    private boolean validateEmail() {

        // Extract input from EditText
        String emailInput = editText4.getText().toString().trim();

        // if the email input field is empty
        if (emailInput.isEmpty()) {
            editText4.setError("Поле не может быть пустым");
            return false;
        }

        // Matching the input email to a predefined email pattern
        else if (!Patterns.EMAIL_ADDRESS.matcher(emailInput).matches()) {
            editText4.setError("Please enter a valid email address");
            return false;
        } else {
            editText4.setError(null);
            return true;
        }
    }



    private boolean validatePassword() {
        String passwordInput = editText5.getText().toString().trim();

        if (passwordInput.isEmpty()) {
            editText5.setError("Поле не может быть пустым");
            return false;
        }

        else if (!PASSWORD_PATTERN.matcher(passwordInput).matches()) {
            editText5.setError("Пароль слишком слабый");
            return false;
        } else {
            editText5.setError(null);
            return true;

        }
    }
    void savePref() {
        mySP = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor ed = mySP.edit();
        ed.putString(SAVE_TEXT, editText.getText().toString());
        ed.putString(SAVE_TEXT1, editText2.getText().toString());
        ed.putString(SAVE_TEXT2, editText3.getText().toString());
        ed.putString(SAVE_TEXT3, editText4.getText().toString());
        ed.putString(SAVE_TEXT4, editText5.getText().toString());
        ed.putString(SAVE_TEXT5, editText6.getText().toString());
        ed.commit();
        String password =  editText5.getText().toString();
        String password2 =  editText6.getText().toString();

        if (password.equals(password2) & password.length() != 0 & password2.length() != 0){     // проверка паролей на соответствии друг с другом и наличие его
            // data get database
        }else {
            Toast.makeText(getApplicationContext(),"Введенные пароли не совпадают", Toast.LENGTH_SHORT).show();
        }
        if (editText.getText().toString().isEmpty() || editText2.getText().toString().isEmpty() || editText3.getText().toString().isEmpty() || editText4.getText().toString().isEmpty() || editText5.getText().toString().isEmpty() || editText6.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Пустые поля", Toast.LENGTH_SHORT).show();
        }

        else  {
            Toast.makeText(this, "Text Save", Toast.LENGTH_SHORT).show();
        }

    }

    void loadPref() {
        mySP = getPreferences(MODE_PRIVATE);
        String save_Text = mySP.getString(SAVE_TEXT, "");
        String save_Text1 = mySP.getString(SAVE_TEXT1, "");
        String save_Text2 = mySP.getString(SAVE_TEXT2, "");
        String save_Text3 = mySP.getString(SAVE_TEXT3, "");
        String save_Text4 = mySP.getString(SAVE_TEXT4, "");
        String save_Text5 = mySP.getString(SAVE_TEXT5, "");
        editText.setText(save_Text);
        editText2.setText(save_Text1);
        editText3.setText(save_Text2);
        editText4.setText(save_Text3);
        editText5.setText(save_Text4);
        editText6.setText(save_Text5);
        String password =  editText5.getText().toString();
        String password2 =  editText6.getText().toString();
        if (password.equals(password2) & password.length() != 0 & password2.length() != 0){     // проверка паролей на соответствии друг с другом и наличие его
            // data get database
        }else {
            Toast.makeText(getApplicationContext(),"Введенные пароли не совпадают", Toast.LENGTH_SHORT).show();
        }
        if (editText.getText().toString().isEmpty() || editText2.getText().toString().isEmpty() || editText3.getText().toString().isEmpty() || editText4.getText().toString().isEmpty() || editText5.getText().toString().isEmpty() || editText6.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Пустые поля", Toast.LENGTH_SHORT).show();
        }

        else {
            Toast.makeText(this, "Text Load", Toast.LENGTH_SHORT).show();
        }
    }


    public void save(View view) {

        String password =  editText5.getText().toString();
        String password2 =  editText6.getText().toString();
        if (password.equals(password2) & password.length() != 0 & password2.length() != 0){     // проверка паролей на соответствии друг с другом и наличие его
            // data get database
        }else {
            Toast.makeText(getApplicationContext(),"Введенные пароли не совпадают", Toast.LENGTH_SHORT).show();
        }
        if (editText.getText().toString().isEmpty() || editText2.getText().toString().isEmpty() || editText3.getText().toString().isEmpty() || editText4.getText().toString().isEmpty() || editText5.getText().toString().isEmpty() || editText6.getText().toString().isEmpty()) {
            Toast.makeText(MainActivity.this, "Пустые поля", Toast.LENGTH_SHORT).show();
        }
        if (!validateEmail() | !validatePassword()) {
            return;
        }

        savePref();

    }

    public void load(View view) {
        loadPref();
    }

}