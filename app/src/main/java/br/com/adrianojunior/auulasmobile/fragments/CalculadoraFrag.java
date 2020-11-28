package br.com.adrianojunior.auulasmobile.fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import br.com.adrianojunior.auulasmobile.R;

public class CalculadoraFrag extends BaseFragment {

    private Button btnSoma, btnSub, btnDiv, btnMult, btnPOW, btnSQRT, btnX3, btnEXP, btnClear;
    private EditText firstNumber, secondNumber;
    private TextView resultadoTxt;

    String num1, num2;
    double firstNum, secondNum, result, result2;


    public CalculadoraFrag() {}

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_calculadora, container, false);

        btnSoma = view.findViewById(R.id.btn_soma);
        btnSub = view.findViewById(R.id.btn_sub);
        btnDiv = view.findViewById(R.id.btn_div);
        btnMult = view.findViewById(R.id.btn_mult);
        btnPOW = view.findViewById(R.id.btn_pow);
        btnSQRT = view.findViewById(R.id.btn_sqrt);
        btnX3 = view.findViewById(R.id.btn_x3);
        btnEXP = view.findViewById(R.id.btn_exp);
        btnClear = view.findViewById(R.id.clear_btn);

        firstNumber = view.findViewById(R.id.fisrt_number_text);
        secondNumber = view.findViewById(R.id.second_number_text);

        resultadoTxt = view.findViewById(R.id.result_txt);

        btnSoma.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                num1 = firstNumber.getText().toString().replaceAll(",", ".");
                num2 = secondNumber.getText().toString().replaceAll(",", ".");

                if (num1 != null && num2 != null && !num1.isEmpty() && !num2.isEmpty()) {
                    firstNum = Double.parseDouble(num1);
                    secondNum = Double.parseDouble(num2);
                    result = firstNum + secondNum;
                    resultadoTxt.setText("Resultado:\n" + firstNum + " + " + secondNum + " = " + result);
                    resultadoTxt.setTextColor(getResources().getColor(R.color.green));
                } else {
                    resultadoTxt.setTextColor(getResources().getColor(R.color.black));
                    resultadoTxt.setText("Resultado: ");
                    toast("Os valores não podem ser deixados em branco");
                }


            }
        });

        btnSub.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                num1 = firstNumber.getText().toString();
                num2 = secondNumber.getText().toString();

                if (num1 != null && num2 != null && !num1.isEmpty() && !num2.isEmpty()) {
                    firstNum = Double.parseDouble(num1);
                    secondNum = Double.parseDouble(num2);
                    result = firstNum - secondNum;
                    resultadoTxt.setText("Resultado:\n" + firstNum + " - " + secondNum + " = " + result);
                    resultadoTxt.setTextColor(getResources().getColor(R.color.green));
                } else {
                    resultadoTxt.setTextColor(getResources().getColor(R.color.black));
                    resultadoTxt.setText("Resultado: ");
                    toast("Os valores não podem ser deixados em branco");
                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                num1 = firstNumber.getText().toString();
                num2 = secondNumber.getText().toString();

                if (num1 != null && num2 != null && !num1.isEmpty() && !num2.isEmpty()) {
                    firstNum = Double.parseDouble(num1);
                    secondNum = Double.parseDouble(num2);
                    result = firstNum / secondNum;
                    resultadoTxt.setText("Resultado:\n" + firstNum + " / " + secondNum + " = " + result);
                    resultadoTxt.setTextColor(getResources().getColor(R.color.green));
                } else {
                    resultadoTxt.setTextColor(getResources().getColor(R.color.black));
                    resultadoTxt.setText("Resultado: ");
                    toast("Os valores não podem ser deixados em branco");
                }
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                num1 = firstNumber.getText().toString();
                num2 = secondNumber.getText().toString();

                if (num1 != null && num2 != null && !num1.isEmpty() && !num2.isEmpty()) {
                    firstNum = Double.parseDouble(num1);
                    secondNum = Double.parseDouble(num2);
                    result = firstNum * secondNum;
                    resultadoTxt.setText("Resultado:\n" + firstNum + " * " + secondNum + " = " + result);
                    resultadoTxt.setTextColor(getResources().getColor(R.color.green));
                } else {
                    resultadoTxt.setTextColor(getResources().getColor(R.color.black));
                    resultadoTxt.setText("Resultado: ");
                    toast("Os valores não podem ser deixados em branco");
                }
            }
        });

        btnPOW.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                num1 = firstNumber.getText().toString();
                num2 = secondNumber.getText().toString();

                if (num1 != null && num2 != null && !num1.isEmpty() && !num2.isEmpty()) {
                    firstNum = Double.parseDouble(num1);
                    secondNum = Double.parseDouble(num2);
                    result = Math.pow(firstNum, secondNum);
                    resultadoTxt.setText("Resultado:\n" + firstNum + " ^ " + secondNum + " = " + result);
                    resultadoTxt.setTextColor(getResources().getColor(R.color.green));
                } else {
                    resultadoTxt.setTextColor(getResources().getColor(R.color.black));
                    resultadoTxt.setText("Resultado: ");
                    toast("Os valores não podem ser deixados em branco");
                }
            }
        });

        btnSQRT.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                num1 = firstNumber.getText().toString();
                num2 = secondNumber.getText().toString();

                if (num1 != null && num2 != null && !num1.isEmpty() && !num2.isEmpty()) {
                    firstNum = Double.parseDouble(num1);
                    secondNum = Double.parseDouble(num2);
                    result = Math.sqrt(firstNum);
                    result2 = Math.sqrt(secondNum);
                    resultadoTxt.setText("Resultado:\n" + result + "\n" + result2);
                    resultadoTxt.setTextColor(getResources().getColor(R.color.green));
                } else {
                    resultadoTxt.setTextColor(getResources().getColor(R.color.black));
                    resultadoTxt.setText("Resultado: ");
                    toast("Os valores não podem ser deixados em branco");
                }
            }
        });

        btnX3.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                num1 = firstNumber.getText().toString();
                num2 = secondNumber.getText().toString();

                if (num1 != null && num2 != null && !num1.isEmpty() && !num2.isEmpty()) {
                    firstNum = Double.parseDouble(num1);
                    secondNum = Double.parseDouble(num2);
                    result = Math.pow(firstNum, 3);
                    result2 = Math.pow(secondNum, 3);
                    resultadoTxt.setText("Resultado:\n" + result + "\n" + result2);
                    resultadoTxt.setTextColor(getResources().getColor(R.color.green));
                } else {
                    resultadoTxt.setTextColor(getResources().getColor(R.color.black));
                    resultadoTxt.setText("Resultado: ");
                    toast("Os valores não podem ser deixados em branco");
                }
            }
        });

        btnEXP.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                num1 = firstNumber.getText().toString();
                num2 = secondNumber.getText().toString();

                if (num1 != null && num2 != null && !num1.isEmpty() && !num2.isEmpty()) {
                    firstNum = Double.parseDouble(num1);
                    secondNum = Double.parseDouble(num2);
                    result = firstNum*Math.pow(10, secondNum);
                    resultadoTxt.setText("Resultado:\n" + result);
                    resultadoTxt.setTextColor(getResources().getColor(R.color.green));
                } else {
                    resultadoTxt.setTextColor(getResources().getColor(R.color.black));
                    resultadoTxt.setText("Resultado: ");
                    toast("Os valores não podem ser deixados em branco");
                }
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resultadoTxt.setTextColor(getResources().getColor(R.color.black));
                resultadoTxt.setText("Resultado: ");
                firstNumber.setText("");
                secondNumber.setText("");
            }
        });

        return view;

    }
}