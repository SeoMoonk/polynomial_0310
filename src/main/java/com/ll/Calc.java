package com.ll;

public class Calc {


    public static int run(String exp) {

        //1단계 - 기본 더하기 연산이 들어오면, 기본 연산을 수행할 수 있어야 한다.

        //2단계 - 이제 어떤 연산이 들어왔는지 (+,-,*,/) 구별하고,
        //각각 다르게 수행할 수 있어야 한다.

        //3단계 - 연산이 두개가 연달아 들어와도 수행할 수 있어야 한다.
        //ex) 10 + 20 + 30 == 60

        //4단계 - 연산이 여러개 들어오는데, 각각 다른 연산이 들어와도 수행할 수 있어야 한다.
        //ex) 10 + 20 - 30 == 0
        //sol => replace를 통해 10 - 20 을 10 + -20과 같이 고친다.
        // "- " => "+ -"
        exp.replaceAll("- ", "+ -");
        //이 과정을 거치면 -> 더하기가 들어왔는지 빼기가 들어왔는지 이제 알 필요가 없다.

        boolean needToPlus = exp.contains("+");
        boolean needToMinus = exp.contains("-");
        boolean needToMultiply = exp.contains("*");
        boolean needToDivide = exp.contains("/");

        String[] bits = null;
        int a, b;

        if (needToPlus) {
            bits = exp.split(" \\+ ");
            a = Integer.parseInt(bits[0]);
            b = Integer.parseInt(bits[1]);

            return a + b;
        } else if (needToMinus) {
            bits = exp.split(" - ");
            a = Integer.parseInt(bits[0]);
            b = Integer.parseInt(bits[1]);

            return a - b;
        } else if (needToMultiply) {
            bits = exp.split(" \\* ");
            a = Integer.parseInt(bits[0]);
            b = Integer.parseInt(bits[1]);

            return a * b;
        } else if (needToDivide) {
            bits = exp.split(" / ");
            a = Integer.parseInt(bits[0]);
            b = Integer.parseInt(bits[1]);

            return a / b;
        } else {
            throw new RuntimeException("올바른 계산식이 아닙니다.");

        }
    }
}

    /*
    //static의 장점 => 객체화를 안하고 바로 쓸 수 있다.
    public static int plus(String exp) {
        String[] bits = exp.split(" \\+ ");

        int a = Integer.parseInt(bits[0]);
        int b = Integer.parseInt(bits[1]);

        return a + b;
    }


    public static int minus(String exp) {

        String[] bits = exp.split(" - ");

        int a = Integer.parseInt(bits[0]);
        int b = Integer.parseInt(bits[1]);

        return a - b;
    }

    public static int multiply(String exp) {

        String[] bits = exp.split(" \\* ");

        int a = Integer.parseInt(bits[0]);
        int b = Integer.parseInt(bits[1]);

        return a * b;
    }


    public static int divide(String exp) {

        String[] bits = exp.split(" / ");

        int a = Integer.parseInt(bits[0]);
        int b = Integer.parseInt(bits[1]);

        return a / b;
    }

     */