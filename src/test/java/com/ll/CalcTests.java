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
        assertThat(Calc.run("10 + 2 * 3")).isEqualTo(16);
    }

    @Test
    @DisplayName("10 + 20 + 5 * 3 == 45")
    void t15() {
        assertThat(Calc.run("10 + 20 + 5 * 3")).isEqualTo(45);
    }

    @Test
    @DisplayName("10 * 20 + 10 + 5 * 3 == 225")
    void t16() {
        assertThat(Calc.run("10 * 20 + 10 + 5 * 3")).isEqualTo(225);
    }

    @Test
    @DisplayName("(10 + 20) == 30")
    void t17() {
        assertThat(Calc.run("(10 + 20)")).isEqualTo(30);
    }

    @Test
    @DisplayName("(((10 + 20))) == 30")
    void t18() {
        assertThat(Calc.run("(((10 + 20)))")).isEqualTo(30);
    }

    @Test
    @DisplayName("(((10 + 20))) + 5 == 35")
    void t19() {
        assertThat(Calc.run("(((10 + 20))) + 5")).isEqualTo(35);
    }

}