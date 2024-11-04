package lotto.service;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CustomLottoIssueServiceTest extends NsTest {

    @DisplayName("쉼포를 구분자로 6개의 숫자를 입력하면 Lotto 를 반환한다.")
    @Test
    void createLotto() {
        // given
        String inputLottoNums = "1,2,3,4,5,6";
        // when & then
        assertSimpleTest(
                () -> {
                    run(inputLottoNums);
                    assertThat(output()).isEqualTo("[1, 2, 3, 4, 5, 6]");
                }
        );
    }

    @DisplayName("숫자가 아닌 문자가 포함된 경우 예외가 발생한다.")
    @Test
    void numException() {
        // given
        String inputLottoNums = "1,2,3,4,5,ㅌ";
        // when & then
        assertSimpleTest(
                () -> {
                    runException(inputLottoNums);
                }
        );
    }

    @DisplayName("정수가 아닌 실수가 포함된 경우 예외가 발생한다.")
    @Test
    void integerException() {
        // given
        String inputLottoNums = "1,2,3,4,5,6.2";
        // when & then
        assertSimpleTest(
                () -> {
                    runException(inputLottoNums);
                }
        );
    }

    @DisplayName("1보다 작은 수가 포함된 경우 예외가 발생한다.")
    @Test
    void lessThanMinValue() {
        // given
        String inputLottoNums = "1,2,3,4,5,-3";
        // when & then
        assertSimpleTest(
                () -> {
                    runException(inputLottoNums);
                }
        );
    }

    @DisplayName("45보다 큰 수가 포함된 경우 예외가 발생한다.")
    @Test
    void moreThanMaxValue() {
        // given
        String inputLottoNums = "1,2,3,4,5,46";
        // when & then
        assertSimpleTest(
                () -> {
                    runException(inputLottoNums);
                }
        );
    }

    @DisplayName("숫자 개수가 6개 미만인 경우 예외가 발생한다.")
    @Test
    void lessThanSix() {
        // given
        String inputLottoNums = "1,2,3,4,5";
        // when & then
        assertSimpleTest(
                () -> {
                    runException(inputLottoNums);
                }
        );
    }

    @Override
    public void runMain() {
        CustomLottoIssueService service = new CustomLottoIssueService();
        System.out.println(service.issue(""));
    }
}