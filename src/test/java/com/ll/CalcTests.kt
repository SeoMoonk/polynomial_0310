package com.ll

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class CalcTests {

    @Test
    @DisplayName("1 + 1 == 2")
    void t1 (){
        assertThat(Calc.run("2 + 1"));
    }

}