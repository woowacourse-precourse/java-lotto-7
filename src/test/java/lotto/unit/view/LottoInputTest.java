package lotto.unit.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.Application;
import lotto.domain.Lotto;
import lotto.constant.LottoErrorMessage;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static camp.nextstep.edu.missionutils.test.Assertions.*;

class LottoInputTest extends NsTest {

    @DisplayName("getIssueCount: 형식체크/문자혼용입력1")
    @Test
    void getIssueCountTest1() {
        assertSimpleTest(() -> {
            runException("1000J");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_PRICE_FORMAT_ERROR);
        });
    }

    @DisplayName("getIssueCount: 형식체크/문자혼용입력2")
    @Test
    void getIssueCountTest2() {
        assertSimpleTest(() -> {
            runException("10A00");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_PRICE_FORMAT_ERROR);
        });
    }

    @DisplayName("getIssueCount: 형식체크/문자혼용입력3")
    @Test
    void getIssueCountTest3() {
        assertSimpleTest(() -> {
            runException("A1000");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_PRICE_FORMAT_ERROR);
        });
    }

    @DisplayName("getIssueCount: 형식체크/소수입력")
    @Test
    void getIssueCountTest4() {
        assertSimpleTest(() -> {
            runException("10.16");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_PRICE_FORMAT_ERROR);
        });
    }

    @DisplayName("getIssueCount: 값체크/1000미만단위")
    @Test
    void getIssueCountTest5() {
        assertSimpleTest(() -> {
            runException("1200");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_PRICE_ERROR);
        });
    }

    @DisplayName("getIssueCount: 값체크/int범위초과")
    @Test
    void getIssueCountTest6() {
        assertSimpleTest(() -> {
            runException("120210120210120120210210");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_PRICE_FORMAT_ERROR);
        });
    }

    @DisplayName("getWinNumber: 형식체크/당첨번호개수")
    @Test
    void getWinNumberTest1() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6,7,8", "40");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_WIN_NUMBER_FORMAT_ERROR);
        });
    }

    @DisplayName("getWinNumber: 형식체크/비정상문자혼용입력1")
    @Test
    void getWinNumberTest2() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6a", "40");
            System.out.println("-----------output--------------------");
            System.out.println(output());
            System.out.println("-----------output--------------------");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_WIN_NUMBER_FORMAT_ERROR);
        });
    }

    @DisplayName("getWinNumber: 형식체크/비정상문자혼용입력2")
    @Test
    void getWinNumberTest3() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3|4,5,6", "40");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_WIN_NUMBER_FORMAT_ERROR);
        });
    }

    @DisplayName("getWinNumber: 형식체크/비정상문자혼용입력3")
    @Test
    void getWinNumberTest4() {
        assertSimpleTest(() -> {
            runException("1000", "1|2,3,4|5,6", "40");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_WIN_NUMBER_FORMAT_ERROR);
        });
    }

    @DisplayName("getWinNumber: 값체크/범위초과1")
    @Test
    void getWinNumberTest5() {
        assertSimpleTest(() -> {
            runException("1000", "500,12,45,223,21,13", "40");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_NUMBER_RANGE_ERROR);
        });
    }

    @DisplayName("getWinNumber: 값체크/범위초과2")
    @Test
    void getWinNumberTest6() {
        assertSimpleTest(() -> {
            runException("1000", "500,1,2,3,4,5", "40");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_NUMBER_RANGE_ERROR);
        });
    }

    @DisplayName("getWinNumber: 값체크/중복값예외처리1")
    @Test
    void getWinNumberTest7() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,5", "40");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR);
        });
    }

    @DisplayName("getWinNumber: 값체크/중복값예외처리2")
    @Test
    void getWinNumberTest8() {
        assertSimpleTest(() -> {
            runException("1000", "1,2,3,4,5,6", "1");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_NUMBER_DUPLICATE_ERROR);
        });
    }

    @DisplayName("getWinNumber: 형식체크/보너스번호 다중입력1")
    @Test
    void getWinNumberTest9() {
        assertSimpleTest(() -> {
            runException("1000", "10,20,3,4,5,6", "1,2");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_BONUS_NUMBER_FORMAT_ERROR);
        });
    }

    @DisplayName("getWinNumber: 형식체크/보너스번호 다중입력2")
    @Test
    void getWinNumberTest10() {
        assertSimpleTest(() -> {
            runException("1000", "10,20,3,4,5,6", "1 2");
            assertThat(output()).contains(LottoErrorMessage.LOTTO_BONUS_NUMBER_FORMAT_ERROR);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}