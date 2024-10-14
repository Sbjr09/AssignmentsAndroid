package com.sbjr.assignmentconvertdialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editText;
    private Button convertButton;
    private TextView textView;
    private Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListner();
    }

    private void initView() {
        editText = findViewById(R.id.edit_text);
        convertButton = findViewById(R.id.convert_button);
        textView = findViewById(R.id.text_view);
    }

    private void initListner(){

        convertButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog();
            }
        });
    }

    private void showDialog() {
        dialog = new Dialog(this);
        dialog.setContentView(R.layout.dialog_convert);

        RadioGroup radioGroup = dialog.findViewById(R.id.radio_group);
        CheckBox checkBox = dialog.findViewById(R.id.check_box);
        Button finishButton = dialog.findViewById(R.id.finish_button);

        finishButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectedId = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = dialog.findViewById(selectedId);

                String text = editText.getText().toString();

                if (radioButton.getText().toString().equals("Upper Case")) {
                    textView.setText(text.toUpperCase());
                } else if (radioButton.getText().toString().equals("Lower Case")) {
                    textView.setText(text.toLowerCase());
                } else if (radioButton.getText().toString().equals("Mixed Case")) {
                    textView.setText(text.substring(0, 1).toUpperCase() + text.substring(1).toLowerCase());
                }

                dialog.dismiss();
            }
        });

        dialog.show();
    }
}

//    private String convertToMixedCase(String input) {
//        StringBuilder mixedCase = new StringBuilder();
//        for (int i = 0; i < input.length(); i++) {
//            char ch = input.charAt(i);
//            mixedCase.append(i % 2 == 0 ? Character.toUpperCase(ch) : Character.toLowerCase(ch));
//        }
//        return mixedCase.toString();
//    }
//}
