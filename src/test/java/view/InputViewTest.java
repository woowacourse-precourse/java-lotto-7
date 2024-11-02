package view;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static lotto.exception.Exception.LOTTO_NUMBER_OUT_OF_RANGE;
import static lotto.exception.Exception.LOTTO_NUMBER_SIZE_MUST_BE_SIX;
import static lotto.validator.LottoNumbersValidator.validate;
import static org.assertj.core.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import lotto.exception.Exception;
import lotto.view.InputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class InputViewTest {

    @Nested
    class 구입금액_입력_테스트 extends NsTest {

        @DisplayName("구입금액 입력 성공 테스트")
        @Test
        void inputPurchaseAmount_success() {
            assertSimpleTest(() -> {
                run("1000");
                assertThat(output()).isEqualTo("1000");
            });

        }

        @DisplayName("입력된 구입금액이 숫자가 아닐 때 예외")
        @Test
        void inputPurchaseAmount_fail() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("천원"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(Exception.ONLY_NUMERIC_INPUT_FOR_PURCHASE_AMOUNT.getMessage());
            });
        }

        @Override
        protected void runMain() {
            int input = InputView.inputPurchaseAmount();
            System.out.print(input);
        }
    }

    @Nested
    class 당첨번호_입력_테스트 extends NsTest {
        @DisplayName("당첨번호 입력 성공 테스트")
        @Test
        void inputWinningNumbers_success() {
            assertSimpleTest(() -> {
                run("1,2,3,4,5,6");
                assertThat(output()).isEqualTo("[1, 2, 3, 4, 5, 6]");
            });

        }

        @DisplayName("당첨번호 입력 개수 예외 테스트")
        @Test
        void inputWinningNumbers_fail_notSix() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("1,2,3,4,5,6,7"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(LOTTO_NUMBER_SIZE_MUST_BE_SIX.getMessage());
            });

        }

        @DisplayName("당첨번호 입력 1~45가 아닐 때 예외 테스트")
        @Test
        void inputWinningNumbers_fail_outOfRange() {
            assertSimpleTest(() -> {
                assertThatThrownBy(() -> runException("1,2,3,4,5,46"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage(LOTTO_NUMBER_OUT_OF_RANGE.getMessage());
            });

        }

        @Override
        protected void runMain() {
            List<Integer> numbers = InputView.inputWinningNumbers();
            System.out.println(numbers);
        }
    }
}