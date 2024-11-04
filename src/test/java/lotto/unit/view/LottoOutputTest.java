package lotto.unit.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import lotto.view.LottoOutput;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoOutputTest {

    @DisplayName("prettyPrint: 기능체크/3자리 미만숫자 1")
    @Test
    void prettyPrintTest1() {
        assertThat(LottoOutput.prettyPrint(1) ).isEqualTo("1");
    }

    @DisplayName("prettyPrint: 기능체크/3자리 미만숫자 2")
    @Test
    void prettyPrintTest2() {
        assertThat(LottoOutput.prettyPrint(10) ).isEqualTo("10");
    }

    @DisplayName("prettyPrint: 기능체크/3자리 숫자")
    @Test
    void prettyPrintTest3() {
        assertThat(LottoOutput.prettyPrint(100) ).isEqualTo("100");
    }

    @DisplayName("prettyPrint: 기능체크/3자리 초과숫자 1")
    @Test
    void prettyPrintTest4() {
        assertThat(LottoOutput.prettyPrint(10000) ).isEqualTo("10,000");
    }

    @DisplayName("prettyPrint: 기능체크/3자리 초과숫자 2")
    @Test
    void prettyPrintTest5() {
        assertThat(LottoOutput.prettyPrint(154322234) ).isEqualTo("154,322,234");
    }

    @DisplayName("prettyPrint: 기능체크/3자리 초과숫자 3")
    @Test
    void prettyPrintTest6() {
        assertThat(LottoOutput.prettyPrint(76854347) ).isEqualTo("76,854,347");
    }
}
