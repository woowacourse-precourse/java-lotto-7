package lotto.unit.util;

import lotto.util.LottoUtil;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class LottoUtilTest {
    @DisplayName("prettyPrint: 기능체크/3자리 미만숫자 1")
    @Test
    void prettyPrintTest1() {
        assertThat(LottoUtil.prettyPrint(1) ).isEqualTo("1");
    }

    @DisplayName("prettyPrint: 기능체크/3자리 미만숫자 2")
    @Test
    void prettyPrintTest2() {
        assertThat(LottoUtil.prettyPrint(10) ).isEqualTo("10");
    }

    @DisplayName("prettyPrint: 기능체크/3자리 숫자")
    @Test
    void prettyPrintTest3() {
        assertThat(LottoUtil.prettyPrint(100) ).isEqualTo("100");
    }

    @DisplayName("prettyPrint: 기능체크/3자리 초과숫자 1")
    @Test
    void prettyPrintTest4() {
        assertThat(LottoUtil.prettyPrint(10000) ).isEqualTo("10,000");
    }

    @DisplayName("prettyPrint: 기능체크/3자리 초과숫자 2")
    @Test
    void prettyPrintTest5() {
        assertThat(LottoUtil.prettyPrint(154322234) ).isEqualTo("154,322,234");
    }

    @DisplayName("prettyPrint: 기능체크/3자리 초과숫자 3")
    @Test
    void prettyPrintTest6() {
        assertThat(LottoUtil.prettyPrint(76854347) ).isEqualTo("76,854,347");
    }
}
