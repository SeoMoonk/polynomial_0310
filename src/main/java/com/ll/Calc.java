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
        //이 과정을 거치면 -> 더하기가 들어왔는지 빼기가 들어왔는지 이제 알 필요가 없다.

        //5단계 - 연산이 이제 3개가 아니라 몇개가 들어올지 모른다. 10개일지도...
        //ex) 10 + 10 - 10 + 10 - 10 ...

        boolean needToMulti = exp.contains("*");
        boolean needToPlus = !needToMulti;

        if(needToPlus)
        {
            exp = exp.replaceAll("- ", "+ -");

            String[] bits = exp.split(" \\+ ");

            int sum = 0;

            for(int i=0; i<bits.length; i++)
            {
                sum += Integer.parseInt(bits[i]);
            }

            return sum;

        }
        else if(needToMulti)
        {
            String[] bits = exp.split(" \\* ");

            int sum = 1;

            for(int i=0; i<bits.length; i++)
            {
                sum *= Integer.parseInt(bits[i]);
            }

            return sum;
        }

        return 0;

        // throw new RuntimeException("올바른 계산식이 아닙니다.");
    }
}