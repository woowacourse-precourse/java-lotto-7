package lotto;

import camp.nextstep.edu.missionutils.test.NsTest;
import lotto.core.WinningNumbers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

class WinningNumbersTest extends NsTest {
    private static final String ERROR_MESSAGE = "[ERROR] ";

    @Test
    @DisplayName("예외 테스트 :: 당첨 번호가 빈값일 경우 예외 발생")
    void throwExceptionIfEmpty_1() {
        assertSimpleTest(() -> {
            runException(" ");
            assertThat(output()).contains(ERROR_MESSAGE + "숫자를 입력해주세요.");
        });
    }

    @Test
    @DisplayName("예외 테스트 :: 당첨 번호 중간에 빈값이 있을 경우 예외 발생 :: ex) 1,2,,4,5,6")
    void throwExceptionIfEmpty_2() {
        assertSimpleTest(() -> {
            runException("1,2,3,4,,6");
            assertThat(output()).contains(ERROR_MESSAGE + "숫자를 입력해주세요.");
        });
    }

    @Test
    @DisplayName("예외 테스트 :: 당첨 번호 중 숫자형이 아닌 값이 있을 경우 예외 발생")
    void throwExceptionIfContainsNonNumber() {
        assertSimpleTest(() -> {
            runException("1,2,3,4,str,6");
            assertThat(output()).contains(ERROR_MESSAGE + "숫자를 입력해주세요.");
        });
    }

    @Test
    @DisplayName("예외 테스트 :: 보너스 번호가 빈값일 경우 예외 발생")
    void throwExceptionIfEmpty_3() {
        assertSimpleTest(() -> {
            runException("1,2,3,4,5,6", " ");
            assertThat(output()).contains(ERROR_MESSAGE + "숫자를 입력해주세요.");
        });
    }

    @Test
    @DisplayName("예외 테스트 :: 보너스 번호가 숫자가 아닐 경우 예외 발생")
    void throwExceptionIfNotInteger() {
        assertSimpleTest(() -> {
            runException("1,2,3,4,5,6", "str");
            assertThat(output()).contains(ERROR_MESSAGE + "숫자를 입력해주세요.");
        });
    }

    @Test
    @DisplayName("예외 테스트 :: 보너스 번호가 1~45 범위를 벗어날 경우 예외 발생")
    void throwExceptionIfOutOfRange() {
        assertSimpleTest(() -> {
            runException("1,2,3,4,5,6", "59");
            assertThat(output()).contains(ERROR_MESSAGE + "로또 번호는 1부터 45 사이의 숫자여야 합니다.");
        });
    }

    @Test
    @DisplayName("예외 테스트 :: 보너스 번호가 당첨 번호와 중복될 경우 예외 발생")
    void throwExceptionIfAlreadyInWinningNumbers() {
        assertSimpleTest(() -> {
            runException("1,2,3,4,5,6", "3");
            assertThat(output()).contains(ERROR_MESSAGE + "보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        });
    }

    @Override
    protected void runMain() {
        new WinningNumbers();
    }
}
