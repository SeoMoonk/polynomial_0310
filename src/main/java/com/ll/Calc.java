package com.ll;

import java.util.Arrays;
import java.util.stream.Collectors;

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

        //6단계 - 곱하기(*, multiply가 들어온다면??)

        //7단계 - 더하기와 곱하기가 같이 나온다면? ( 10 + 2 * 3)

        //8단계 - 더하기와 곱하기가 같이 나오는데, 연산이 3개 이상이라면? (10 + 20 + 3 * 5)

        if(!exp.contains(" "))
            return Integer.parseInt(exp);

        boolean needToMulti = exp.contains("*");
        boolean needToPlus = exp.contains("+") || exp.contains(" - ");

        boolean needToCompound = needToMulti && needToPlus;

        if(needToCompound)
        {
            String[] bits = exp.split(" \\+ ");
            //분리하고 또 분리하는 방법 채택.
            // "10" + "2 * 3"
            // [0]  +  [1]

            //나눠서, 문장화를 다시 시키고, 또 연산한다..?
            String newExp = Arrays.stream(bits)
                    .mapToInt(Calc::run)
                    .mapToObj(e -> e + "")
                    .collect(Collectors.joining(" + "));

            return run(newExp);
        }

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