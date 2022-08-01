package jp.suntech.s21030.constraintlayoutsample;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btClick = findViewById(R.id.btConfirm);
        HelloListener listener = new HelloListener();
        btClick.setOnClickListener(listener);
        Button btClear = findViewById(R.id.btClear);
        btClear.setOnClickListener(listener);
        Button btNClear = findViewById(R.id.btSend);
        btNClear.setOnClickListener(listener);

    }
    public void showDialog(View view){
        EditText input = findViewById(R.id.etName);
        EditText input1 = findViewById(R.id.etMail);
        EditText input2 = findViewById(R.id.etMtitle);
        EditText input3 = findViewById(R.id.etComment);
        String inputStr = input.getText().toString();
        String inputStr1 = input1.getText().toString();
        String inputStr2 = input2.getText().toString();
        String inputStr3 = input3.getText().toString();
        ConfirmationDialog confirmationDialog = new ConfirmationDialog();
        Bundle args = new Bundle();
        args.putString("show","送信者名："+inputStr+"\r\nメールアドレス："+inputStr1+"\r\nタイトル："+inputStr2+"\r\n本文："+inputStr3);
    }
    private class HelloListener implements View.OnClickListener{
        @Override
        public void onClick(View view){
            EditText input = findViewById(R.id.etName);
            EditText input1 = findViewById(R.id.etMail);
            EditText input2 = findViewById(R.id.etMtitle);
            EditText input3 = findViewById(R.id.etComment);
            String inputStr = input.getText().toString();
            String inputStr1 = input1.getText().toString();
            String inputStr2 = input2.getText().toString();
            String inputStr3 = input3.getText().toString();
            String show = "送信者名："+inputStr+"\r\nメールアドレス："+inputStr1+"\r\nタイトル："+inputStr2+"\r\n本文："+inputStr3;
            int id = view.getId();
            switch (id){
                case R.id.btConfirm:
                    ConfirmationDialog dialogFragment=new ConfirmationDialog();
                    dialogFragment.show(getSupportFragmentManager(),"ConfirmationDialog");
                case R.id.btSend:
                    Toast.makeText(MainActivity.this,show,Toast.LENGTH_LONG).show();
                    break;
                case R.id.btClear:
                    input.setText("");
                    input1.setText("");
                    input2.setText("");
                    input3.setText("");
                    break;

            }

        }
    }
}