package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import lotto.controller.error.ErrorType;
import lotto.controller.generator.mock.MockNumberGenerator;
import lotto.model.Lotto;
import lotto.view.input.mock.MockInputView;
import lotto.view.output.mock.MockOutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class LottoControllerTest {

    @Nested
    @DisplayName("유효한 경우")
    class ValidCases {

        @Test
        @DisplayName("로또 구입 금액에 따른 로또 발행이 정상적으로 출력된다.")
        void displayPurchasedLottos() {
            // given
            MockInputView inputView = new MockInputView(List.of("8000", "1,2,3,4,5,6", "7"));
            MockOutputView outputView = new MockOutputView();
            MockNumberGenerator numberGenerator = new MockNumberGenerator();
            LottoController controller = new LottoController(inputView, outputView, numberGenerator);

            // when
            controller.start();
            List<String> output = outputView.getOutput();

            // then
            assertSoftly(softly -> {
                softly.assertThat(output.getFirst()).isEqualTo("8개를 구매했습니다.");
                softly.assertThat(output.subList(1, 9)).contains(
                        "[1, 2, 3, 4, 5, 6]",
                        "[1, 2, 3, 4, 5, 6]",
                        "[1, 2, 3, 4, 5, 6]",
                        "[1, 2, 3, 4, 5, 6]",
                        "[1, 2, 3, 4, 5, 6]",
                        "[1, 2, 3, 4, 5, 6]",
                        "[1, 2, 3, 4, 5, 6]",
                        "[1, 2, 3, 4, 5, 6]"
                );
            });
        }

        @Test
        @DisplayName("당첨 통계를 정상적으로 출력한다.")
        void displayResults() {
            // given
            MockInputView inputView = new MockInputView(List.of("8000", "1,2,3,4,5,6", "7"));
            MockOutputView outputView = new MockOutputView();
            MockNumberGenerator numberGenerator = new MockNumberGenerator();
            LottoController controller = new LottoController(inputView, outputView, numberGenerator);

            // when
            controller.start();
            List<String> output = outputView.getOutput();

            // then
            assertThat(output).contains(
                    "당첨 통계\n---",
                    "3개 일치 (5,000원) - 0개",
                    "4개 일치 (50,000원) - 0개",
                    "5개 일치 (1,500,000원) - 0개",
                    "5개 일치, 보너스 볼 일치 (30,000,000원) - 0개",
                    "6개 일치 (2,000,000,000원) - 8개",
                    "총 수익률은 200000000.0%입니다."
            );
        }
    }

    @Nested
    @DisplayName("유효하지 않은 경우")
    class InvalidCases {

        @Test
        @DisplayName("잘못된 구입 금액 입력 시 예외 메시지를 출력한다.")
        void purchaseAmountInvalidFormat() {
            // given
            String invalidAmount = "1500";
            MockInputView inputView = new MockInputView(List.of(invalidAmount, "8000", "1,2,3,4,5,6", "7"));
            MockOutputView outputView = new MockOutputView();
            LottoController controller = new LottoController(inputView, outputView, new MockNumberGenerator());

            // when
            controller.start();
            List<String> output = outputView.getOutput();
            // then

            assertThat(output.getFirst()).isEqualTo(ErrorType.INVALID_UNIT_AMOUNT.getMessage());
        }

        @Test
        @DisplayName("잘못된 당첨 번호 형식 입력 시 예외 메시지를 출력한다.")
        void winningNumberInvalidFormat() {
            // given
            String invalidLottoNumber = "1,2,3";
            MockInputView inputView = new MockInputView(List.of("0", invalidLottoNumber, "1,2,3,4,5,6", "7"));
            MockOutputView outputView = new MockOutputView();
            LottoController controller = new LottoController(inputView, outputView, new MockNumberGenerator());

            // when
            controller.start();
            List<String> output = outputView.getOutput();

            // then
            assertThat(output.get(1)).isEqualTo(ErrorType.INVALID_LOTTO_COUNT.getMessage());
        }

        @Test
        @DisplayName("잘못된 당첨 번호 형식 입력 시 예외 메시지를 출력한다.")
        void bonusNumberInvalidFormat() {
            // given
            String invalidBonusNumber = String.valueOf(Lotto.MAX_LOTTO_NUMBER + 1);
            MockInputView inputView = new MockInputView(List.of("0", "1,2,3,4,5,6", invalidBonusNumber, "7"));
            MockOutputView outputView = new MockOutputView();
            LottoController controller = new LottoController(inputView, outputView, new MockNumberGenerator());

            // when
            controller.start();
            List<String> output = outputView.getOutput();

            // then
            assertThat(output.get(1)).isEqualTo(ErrorType.OUT_OF_RANGE.getMessage());
        }
    }
}
