package lotto;

import org.assertj.core.util.Arrays;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class LottoControllerTest {

    @DisplayName("로또 구매 후 결과를 제대로 계산한다.")
    @Test
    void 로또_구매_후_결과를_제대로_계산한다() {
        // Arrange
        Input inputHandler = new Input() {
            @Override
            public int inputPayment() {
                return 2000; // 2000원으로 2장의 로또 구매
            }

            @Override
            public List<Integer> inputWinningNumbers() {
                return List.of(1, 2, 3, 4, 5, 6); // 당첨 번호
            }

            @Override
            public int inputBonusNumber() {
                return 7; // 보너스 번호
            }
        };

        LottoGenerator generator = new RandomLottoGenerator(); // 로또 번호 생성기
        LottoPurchase lottoPurchase = new LottoPurchase(generator);
        LottoMatcher lottoMatcher = new LottoMatcher();
        ResultCalculator resultCalculator = new ResultCalculator(lottoMatcher);
        Output outputHandler = new Output() {
            @Override
            public void printLottoNumberList(List<Lotto> lottos) {
            }

            @Override
            public void printTotalResult(int[] results) {
            }

            @Override
            public void printProfit(float profit) {
            }
        };

        LottoController controller = new LottoController(inputHandler, lottoPurchase, resultCalculator, outputHandler);
        controller.play();
    }

    @DisplayName("구매 금액이 1000원 단위가 아닐 때 예외가 발생한다.")
    @Test
    void 구매_금액이_1000원_단위가_아닐때_예외가_발생한다() {
        // Arrange
        Input inputHandler = new Input() {
            @Override
            public int inputPayment() {
                return 1500; // 1500원으로 잘못된 금액 입력
            }

            @Override
            public List<Integer> inputWinningNumbers() {
                return List.of(1, 2, 3, 4, 5, 6);
            }

            @Override
            public int inputBonusNumber() {
                return 7;
            }
        };

        LottoGenerator generator = new RandomLottoGenerator();
        LottoPurchase lottoPurchase = new LottoPurchase(generator);
        LottoMatcher lottoMatcher = new LottoMatcher();
        ResultCalculator resultCalculator = new ResultCalculator(lottoMatcher);
        Output outputHandler = new Output() {
            @Override
            public void printLottoNumberList(List<Lotto> lottos) {
            }

            @Override
            public void printTotalResult(int[] results) {
            }

            @Override
            public void printProfit(float profit) {
            }
        };

        LottoController controller = new LottoController(inputHandler, lottoPurchase, resultCalculator, outputHandler);
        assertThatThrownBy(controller::play)
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("금액은 1000원단위로 떨어져야합니다."); // 예외 메시지 검증
    }
}
