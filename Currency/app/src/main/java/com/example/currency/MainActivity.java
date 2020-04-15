package com.example.currency;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Button;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    List<ContactModel> models;
    ContactModel model1, model2;

    TextView textView1, textView2;

    double value1 = 0;
    double value2 = 0;

    int no_text = 1;
    String temp = "";
    boolean isFloat = false;

    DecimalFormat decimalFormat1;
    DecimalFormat decimalFormat2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView textView3 = findViewById(R.id.text_view_3);
        textView3.setText("");

        final ImageView imageView1 = findViewById(R.id.image_view_1);
        final ImageView imageView2 = findViewById(R.id.image_view_2);

        textView1 = findViewById(R.id.text_view_1);
        textView2 = findViewById(R.id.text_view_2);

        Button btn_0 = findViewById(R.id.btn_0);
        Button btn_1 = findViewById(R.id.btn_1);
        Button btn_2 = findViewById(R.id.btn_2);
        Button btn_3 = findViewById(R.id.btn_3);
        Button btn_4 = findViewById(R.id.btn_4);
        Button btn_5 = findViewById(R.id.btn_5);
        Button btn_6 = findViewById(R.id.btn_6);
        Button btn_7 = findViewById(R.id.btn_7);
        Button btn_8 = findViewById(R.id.btn_8);
        Button btn_9 = findViewById(R.id.btn_9);
        Button btn_ce = findViewById(R.id.btn_ce);
        ImageButton btn_bs = findViewById(R.id.btn_bs);
        Button btn_dot = findViewById(R.id.btn_dot);

        btn_0.setOnClickListener(this);
        btn_1.setOnClickListener(this);
        btn_2.setOnClickListener(this);
        btn_3.setOnClickListener(this);
        btn_4.setOnClickListener(this);
        btn_5.setOnClickListener(this);
        btn_6.setOnClickListener(this);
        btn_7.setOnClickListener(this);
        btn_8.setOnClickListener(this);
        btn_9.setOnClickListener(this);

        btn_ce.setOnClickListener(this);
        btn_dot.setOnClickListener(this);

        String pattern1 = "#########.##";
        String pattern2 = "######.############";

        decimalFormat1 = new DecimalFormat(pattern1);
        decimalFormat2 = new DecimalFormat(pattern2);

        btn_bs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(no_text == 1) {
                    String buffer = textView1.getText() + "";
                    if (buffer.length() <= 1) {
                        textView1.setText("0");
                        textView2.setText("0");
                    } else {
                        if (buffer.charAt(buffer.length() - 1) == '.') isFloat = false;
                        textView1.setText(buffer.substring(0, buffer.length() - 1));
                        value2 = Double.parseDouble(textView1.getText()+"")*model2.getRate()/model1.getRate();
                        textView2.setText(decimalFormat1.format(value2)+"");
                    }
                }
                else if(no_text == 2){
                    String buffer = textView2.getText() + "";
                    if (buffer.length() <= 1){
                        textView2.setText("0");
                        textView1.setText("0");
                    }
                    else {
                        if(buffer.charAt(buffer.length() - 1)=='.') isFloat = false;
                        textView2.setText(buffer.substring(0, buffer.length() - 1));
                        value1 = Double.parseDouble(textView2.getText()+"")*model1.getRate()/model2.getRate();
                        textView1.setText(decimalFormat1.format(value1)+"");
                    }
                }
                else{};
            }
        });

        models = new ArrayList<>();
        models.add(new ContactModel("United States", "dollar", "USD", R.drawable.ic_dollar, 1.0));
        models.add(new ContactModel("Vietnam", "Dong","VND", R.drawable.ic_dong, 23432.00));
        models.add(new ContactModel("China", "Yuan", "CNY", R.drawable.ic_yen, 7.0501));
        models.add(new ContactModel("Europe ","Euro", "EUR", R.drawable.ic_euro, 0.9168));
        models.add(new ContactModel("Korea", "Won","KRO", R.drawable.ic_korea, 1217.56));


        final SpinnerAdapter adapter = new SpinnerAdapter(models);

        Spinner spinner1 = findViewById(R.id.spinner_1);
        Spinner spinner2 = findViewById(R.id.spinner_2);

        spinner1.setAdapter(adapter);
        spinner2.setAdapter(adapter);

        model1 = models.get(0);
        model2 = models.get(0);

        textView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no_text = 1;
                ContactModel first = model1;
                ContactModel second = model2;
                textView1.setTypeface(null, Typeface.BOLD);
                textView2.setTypeface(null, Typeface.NORMAL);
                double r = Math.ceil(second.getRate()/first.getRate() * 10000000)/10000000;
                textView1.setText((textView1.getText()+"").replaceAll(",", "."));
                if((textView1.getText()+"").contains("."))
                    isFloat = true;
                else isFloat = false;
                textView3.setText("1 " + first.getAcronymCurrency() + " = " + decimalFormat2.format(r) + " "+ second.getAcronymCurrency() + "");
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                no_text = 2;
                ContactModel first = model2;
                ContactModel second = model1;
                textView1.setTypeface(null, Typeface.NORMAL);
                textView2.setTypeface(null, Typeface.BOLD);
                double r = Math.ceil(second.getRate()/first.getRate() * 10000000)/10000000;
                textView2.setText((textView2.getText()+"").replaceAll(",", "."));
                if((textView2.getText()+"").contains("."))
                    isFloat = true;
                else isFloat = false;
                textView3.setText("1 " + first.getAcronymCurrency() + " = " + decimalFormat2.format(r) + " "+ second.getAcronymCurrency() + "");
            }
        });


        spinner1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                model1 = (ContactModel) adapter.getItem(i);
                imageView1.setImageResource(model1.getSymbol());
                double r = Math.ceil(model2.getRate()/model1.getRate() * 10000000)/10000000;

                if(no_text == 1){
                    value2 = Double.parseDouble(textView1.getText() + "") * model2.getRate() / model1.getRate();
                    textView2.setText(decimalFormat1.format(value2) + "");
                }
                else{
                    value1 = Double.parseDouble(textView2.getText() + "") * model1.getRate() / model2.getRate();
                    textView1.setText(decimalFormat1.format(value1) + "");
                }

                textView3.setText("1 " + model1.getAcronymCurrency() + " = " + decimalFormat2.format(r) + " "+ model2.getAcronymCurrency() + "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int i, long id) {
                model2 = (ContactModel) adapter.getItem(i);
                imageView2.setImageResource(model2.getSymbol());
                double r = Math.ceil(model2.getRate()/model1.getRate() * 10000000)/10000000;

                if(no_text == 2){
                    value1 = Double.parseDouble(textView2.getText() + "") * model1.getRate() / model2.getRate();
                    textView1.setText(decimalFormat1.format(value1) + "");
                }
                else{
                    value2 = Double.parseDouble(textView1.getText() + "") * model2.getRate() / model1.getRate();
                    textView2.setText(decimalFormat1.format(value2) + "");
                }
                textView3.setText("1 " + model1.getAcronymCurrency() + " = " + decimalFormat2.format(r) + " "+ model2.getAcronymCurrency() + "");
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }



    @Override
    public void onClick(View v) {

        Button b;
        b = (Button) v;



        switch (b.getId()){
            case R.id.btn_0: {
                if (no_text == 1) {
                    if (no_text == 1) {
                        if (textView1.getText().equals("0")) textView1.setText("");
                        textView1.setText(textView1.getText() + "0" + "");
                        value2 = Double.parseDouble(textView1.getText() + "") * model2.getRate() / model1.getRate();
                        textView2.setText(decimalFormat1.format(value2) + "");
                    } else if (no_text == 2) {
                        if (textView2.getText().equals("0")) textView2.setText("");
                        textView2.setText(textView2.getText() + "0" + "");
                        value1 = Double.parseDouble(textView2.getText() + "") * model1.getRate() / model2.getRate();
                        textView1.setText(decimalFormat1.format(value1) + "");
                    } else {
                    }
                    ;
                    break;
                }
            }
            case R.id.btn_1: {
                if(no_text == 1){
                    if(textView1.getText().equals("0")) textView1.setText("");
                    textView1.setText(textView1.getText()+"1"+"");
                    value2 = Double.parseDouble(textView1.getText()+"")*model2.getRate()/model1.getRate();
                    textView2.setText(decimalFormat1.format(value2)+"");
                }else if(no_text == 2){
                    if(textView2.getText().equals("0")) textView2.setText("");
                    textView2.setText(textView2.getText()+"1"+"");
                    value1 = Double.parseDouble(textView2.getText()+"")*model1.getRate()/model2.getRate();
                    textView1.setText(decimalFormat1.format(value1)+"");
                }else{};
                break;
            }
            case R.id.btn_2: {
                if(no_text == 1){
                    if(textView1.getText().equals("0")) textView1.setText("");
                    textView1.setText(textView1.getText()+"2"+"");
                    value2 = Double.parseDouble(textView1.getText()+"")*model2.getRate()/model1.getRate();
                    textView2.setText(decimalFormat1.format(value2)+"");
                }else if(no_text == 2){
                    if(textView2.getText().equals("0")) textView2.setText("");
                    textView2.setText(textView2.getText()+"2"+"");
                    value1 = Double.parseDouble(textView2.getText()+"")*model1.getRate()/model2.getRate();
                    textView1.setText(decimalFormat1.format(value1)+"");
                }else{};
                break;
            }
            case R.id.btn_3: {
                if(no_text == 1){
                    if(textView1.getText().equals("0")) textView1.setText("");
                    textView1.setText(textView1.getText()+"3"+"");
                    value2 = Double.parseDouble(textView1.getText()+"")*model2.getRate()/model1.getRate();
                    textView2.setText(decimalFormat1.format(value2)+"");
                }else if(no_text == 2){
                    if(textView2.getText().equals("0")) textView2.setText("");
                    textView2.setText(textView2.getText()+"3"+"");
                    value1 = Double.parseDouble(textView2.getText()+"")*model1.getRate()/model2.getRate();
                    textView1.setText(decimalFormat1.format(value1)+"");
                }else{};
                break;
            }
            case R.id.btn_4: {
                if(no_text == 1){
                    if(textView1.getText().equals("0")) textView1.setText("");
                    textView1.setText(textView1.getText()+"4"+"");
                    value2 = Double.parseDouble(textView1.getText()+"")*model2.getRate()/model1.getRate();
                    textView2.setText(decimalFormat1.format(value2)+"");
                }else if(no_text == 2){
                    if(textView2.getText().equals("0")) textView2.setText("");
                    textView2.setText(textView2.getText()+"4"+"");
                    value1 = Double.parseDouble(textView2.getText()+"")*model1.getRate()/model2.getRate();
                    textView1.setText(decimalFormat1.format(value1)+"");
                }else{};
                break;
            }
            case R.id.btn_5: {
                if(no_text == 1){
                    if(textView1.getText().equals("0")) textView1.setText("");
                    textView1.setText(textView1.getText()+"5"+"");
                    value2 = Double.parseDouble(textView1.getText()+"")*model2.getRate()/model1.getRate();
                    textView2.setText(decimalFormat1.format(value2)+"");
                }else if(no_text == 2){
                    if(textView2.getText().equals("0")) textView2.setText("");
                    textView2.setText(textView2.getText()+"5"+"");
                    value1 = Double.parseDouble(textView2.getText()+"")*model1.getRate()/model2.getRate();
                    textView1.setText(decimalFormat1.format(value1)+"");
                }else{};
                break;
            }
            case R.id.btn_6: {
                if(no_text == 1){
                    if(textView1.getText().equals("0")) textView1.setText("");
                    textView1.setText(textView1.getText()+"6"+"");
                    value2 = Double.parseDouble(textView1.getText()+"")*model2.getRate()/model1.getRate();
                    textView2.setText(decimalFormat1.format(value2)+"");
                }else if(no_text == 2){
                    if(textView2.getText().equals("0")) textView2.setText("");
                    textView2.setText(textView2.getText()+"6"+"");
                    value1 = Double.parseDouble(textView2.getText()+"")*model1.getRate()/model2.getRate();
                    textView1.setText(decimalFormat1.format(value1)+"");
                }else{};
                break;
            }
            case R.id.btn_7: {
                if(no_text == 1){
                    if(textView1.getText().equals("0")) textView1.setText("");
                    textView1.setText(textView1.getText()+"7"+"");
                    value2 = Double.parseDouble(textView1.getText()+"")*model2.getRate()/model1.getRate();
                    textView2.setText(decimalFormat1.format(value2)+"");
                }else if(no_text == 2){
                    if(textView2.getText().equals("0")) textView2.setText("");
                    textView2.setText(textView2.getText()+"7"+"");
                    value1 = Double.parseDouble(textView2.getText()+"")*model1.getRate()/model2.getRate();
                    textView1.setText(decimalFormat1.format(value1)+"");
                }else{};
                break;
            }
            case R.id.btn_8: {
                if(no_text == 1){
                    if(textView1.getText().equals("0")) textView1.setText("");
                    textView1.setText(textView1.getText()+"8"+"");
                    value2 = Double.parseDouble(textView1.getText()+"")*model2.getRate()/model1.getRate();
                    textView2.setText(decimalFormat1.format(value2)+"");
                }else if(no_text == 2){
                    if(textView2.getText().equals("0")) textView2.setText("");
                    textView2.setText(textView2.getText()+"8"+"");
                    value1 = Double.parseDouble(textView2.getText()+"")*model1.getRate()/model2.getRate();
                    textView1.setText(decimalFormat1.format(value1)+"");
                }else{};
                break;
            }
            case R.id.btn_9: {
                if(no_text == 1){
                    if(textView1.getText().equals("0")) textView1.setText("");
                    textView1.setText(textView1.getText()+"9"+"");
                    value2 = Double.parseDouble(textView1.getText()+"")*model2.getRate()/model1.getRate();
                    textView2.setText(decimalFormat1.format(value2)+"");
                }else if(no_text == 2){
                    if(textView2.getText().equals("0")) textView2.setText("");
                    textView2.setText(textView2.getText()+"9"+"");
                    value1 = Double.parseDouble(textView2.getText()+"")*model1.getRate()/model2.getRate();
                    textView1.setText(decimalFormat1.format(value1)+"");
                }else{};
                break;
            }
            case R.id.btn_dot: {
                if (isFloat == false) {
                    isFloat = true;
                    if (no_text == 1) {
                        textView1.setText(textView1.getText() + "." + "");
                    } else if (no_text == 2) {
                        textView2.setText(textView2.getText() + "." + "");
                    }
                }
                break;
            }
            case R.id.btn_ce:{
                isFloat = false;
                textView1.setText("0");
                textView2.setText("0");
            }
        }
    }
}
