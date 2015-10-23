package com.vtrifonov.geekhub;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.math.BigInteger;

public class TaskTwoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_task_two);

        Button btnFibonacci = (Button) findViewById(R.id.btn_fibonacci);
        Button btnFactorial = (Button) findViewById(R.id.btn_factorial);

        btnFibonacci.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView fibonacciAnswer = (TextView) findViewById(R.id.fibonacci_answer);
                EditText fibonacciInput = (EditText) findViewById(R.id.fibonacci_input);

                try {
                    int number = Integer.parseInt(fibonacciInput.getText().toString());
                    fibonacciAnswer.setText(String.format("%s: %s", getString(R.string.answer), String.valueOf(fibonacci(number))));
                } catch (Exception e) {
                    e.printStackTrace();
                    fibonacciAnswer.setText(String.format("%s: %s", getString(R.string.error), e.getMessage()));
                }
            }
        });

        btnFactorial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TextView factorialAnswer = (TextView) findViewById(R.id.factorial_answer);
                EditText factorialInput = (EditText) findViewById(R.id.factorial_input);

                try {
                    int number = Integer.parseInt(factorialInput.getText().toString());
                    factorialAnswer.setText(String.format("%s: %s", getString(R.string.answer), String.valueOf(factorial(number))));
                } catch (Exception e) {
                    e.printStackTrace();
                    factorialAnswer.setText(String.format("%s: %s", getString(R.string.error), e.getMessage()));
                }
            }
        });
    }

    public static int fibonacci(int a) throws Exception {
        int fib1 = 1, fib2 = 1, fib = 1;

        BigInteger tmp;
        BigInteger maxInteger = BigInteger.valueOf(Integer.MAX_VALUE);

        if (a == 0) return 0;

        if (a == 1 || a == 2) return 1;

        for (int i = 3; i <= a; i++) {
            tmp = BigInteger.valueOf(fib1).add(BigInteger.valueOf(fib2));
            if (tmp.compareTo(maxInteger) == 1)
                throw new ArithmeticException("Overflow");

            fib = fib1 + fib2;
            fib1 = fib2;
            fib2 = fib;
        }

        return fib;
    }

    public static long factorial(int a) throws Exception {
        long fac = 1L;

        BigInteger tmp;
        BigInteger maxLong = BigInteger.valueOf(Long.MAX_VALUE);

        if (a == 0) return 1;

        for (int i = 1; i < a; i++) {
            tmp = BigInteger.valueOf(fac).multiply(BigInteger.valueOf(i + 1));
            if (tmp.compareTo(maxLong) == 1)
                throw new ArithmeticException("Overflow");

            fac *= (i + 1);
        }

        return fac;
    }

}
