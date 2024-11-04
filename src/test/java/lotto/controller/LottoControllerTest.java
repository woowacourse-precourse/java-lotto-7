package lotto.controller;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.SoftAssertions.assertSoftly;

import java.util.List;
import lotto.controller.error.ErrorType;
import lotto.controller.generator.mock.MockNumberGenerator;
import lotto.model.Lotto;
import lotto.model.Rank;
import lotto.model.Statistics;
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
            List<Lotto> lottos = (List<Lotto>) outputView.getOutput().getFirst();

            // then
            assertSoftly(softly -> {
                softly.assertThat(lottos).hasSize(8);
                lottos.forEach(lotto ->
                        softly.assertThat(lotto.getNumbers()).containsExactly(1, 2, 3, 4, 5, 6));
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
            Statistics statistics = (Statistics) outputView.getOutput().get(1);

            // then
            assertSoftly(softly -> {
                softly.assertThat(statistics.getWinningResult().get(Rank.FIRST_PLACE)).isEqualTo(8);
                softly.assertThat(statistics.getYield()).isEqualTo("200000000.0");
            });
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
            MockNumberGenerator numberGenerator = new MockNumberGenerator();
            LottoController controller = new LottoController(inputView, outputView, numberGenerator);

            // when
            controller.start();
            String errorMessage = (String) outputView.getOutput().getFirst();

            // then
            assertThat(errorMessage).isEqualTo(ErrorType.INVALID_UNIT_AMOUNT.getMessage());
        }

        @Test
        @DisplayName("잘못된 당첨 번호 형식 입력 시 예외 메시지를 출력한다.")
        void winningNumberInvalidFormat() {
            // given
            String invalidLottoNumber = "1,2,3";
            MockInputView inputView = new MockInputView(List.of("0", invalidLottoNumber, "1,2,3,4,5,6", "7"));
            MockOutputView outputView = new MockOutputView();
            MockNumberGenerator numberGenerator = new MockNumberGenerator();
            LottoController controller = new LottoController(inputView, outputView, numberGenerator);

            // when
            controller.start();
            String errorMessage = (String) outputView.getOutput().get(1);

            // then
            assertThat(errorMessage).isEqualTo(ErrorType.INVALID_LOTTO_COUNT.getMessage());
        }

        @Test
        @DisplayName("잘못된 당첨 번호 형식 입력 시 예외 메시지를 출력한다.")
        void bonusNumberInvalidFormat() {
            // given
            String invalidBonusNumber = String.valueOf(Lotto.MAX_LOTTO_NUMBER + 1);
            MockInputView inputView = new MockInputView(List.of("0", "1,2,3,4,5,6", invalidBonusNumber, "7"));
            MockOutputView outputView = new MockOutputView();
            MockNumberGenerator numberGenerator = new MockNumberGenerator();
            LottoController controller = new LottoController(inputView, outputView, numberGenerator);

            // when
            controller.start();
            String errorMessage = (String) outputView.getOutput().get(1);

            // then
            assertThat(errorMessage).isEqualTo(ErrorType.OUT_OF_RANGE.getMessage());
        }
    }
}
