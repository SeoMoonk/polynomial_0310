package com.ll;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalcTests {

    @Test
    @DisplayName("1000 + 280 == 1280")
    void t4() {
        assertThat(Calc.run("1000 + 280")).isEqualTo(1280);
    }

    @Test
    @DisplayName("50 - 30 == 20")
    void t5() {
        assertThat(Calc.run("50 - 30")).isEqualTo(20);
    }

    @Test
    @DisplayName("10 + 20 + 30 == 60")
    void t8() {
        assertThat(Calc.run("10 + 20 + 30")).isEqualTo(60);
    }

    @Test
    @DisplayName("10 - 20 + 30 == 20")
    void t9() {
        assertThat(Calc.run("10 - 20 + 30")).isEqualTo(20);
    }

    @Test
    @DisplayName("10 - 10 + 10 - 10 + 10 == 10")
    void t10() {
        assertThat(Calc.run("10 - 10 + 10 - 10 + 10")).isEqualTo(10);
    }

    @Test
    @DisplayName("10 * 20 == 200")
    void t11() {
        assertThat(Calc.run("10 * 20")).isEqualTo(200);
    }

    @Test
    @DisplayName("10 * -20 == -200")
    void t12() {
        assertThat(Calc.run("10 * -20")).isEqualTo(-200);
    }

    @Test
    @DisplayName("10 * 10 * 10 == 1000")
    void t13() {
        assertThat(Calc.run("10 * 10 * 10")).isEqualTo(1000);
    }

    @Test
    @DisplayName("10 + 2 * 3 == 16")
    void t14() {
        //*을 탐지해서, 2*3을 먼저 처리하고, 10+6을 계산해야 하는데,
        //현재의 상황에서는 *을 탐지했을때 (10 + 2) * (3) 이렇게 나눠버린다.
        //sol -> 복합 연산인지를 검사하는 과정이 필요. "10" + ("2" * "3")

        assertThat(Calc.run("10 + 2 * 3")).isEqualTo(16);
    }


}