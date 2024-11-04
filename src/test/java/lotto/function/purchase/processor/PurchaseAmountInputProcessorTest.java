package lotto.function.purchase.processor;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.io.input.Input;
import lotto.io.printer.prompt.PromptPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class PurchaseAmountInputProcessorTest {

    PurchaseAmountInputProcessor purchaseAmountInputProcessor;
    PromptPrinter promptPrinter;

    @BeforeEach
    void setUp() {
        promptPrinter = new PromptPrinter() {
            @Override
            public void printInputPurchaseAmountPrompt() {
            }

            @Override
            public void printPurchaseLottoCount(int lottoCount) {
            }

            @Override
            public void printInputLottoWinningNumbers() {
            }

            @Override
            public void printInputLottoBonusNumber() {
            }

            @Override
            public void printWinningStatistics() {

            }

            @Override
            public void printTotalReturn(double totalReturn) {
            }
        };
    }

    @ParameterizedTest
    @ValueSource(ints = {1000, 123000, 101000})
    public void 구입_금액을_입력받으면_검증_후_반환한다(int inputAmount) {
        Input input = new Input() {
            @Override
            public Integer readLineToInteger() {
                return inputAmount;
            }

            @Override
            public List<Integer> readLineToNumbersWithDelimiter(String delimiter) {
                return null;
            }
        };
        purchaseAmountInputProcessor = new PurchaseAmountInputProcessor(input, promptPrinter);
        int purchaseAmount = purchaseAmountInputProcessor.inputPurchaseAmount();
        assertThat(purchaseAmount).isEqualTo(inputAmount);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1000, 0, 100, 10101010, 100001000})
    public void Amount_객체_생성에_부합하지_못한_구입_금액을_입력받으면_예외를_발생한다(int inputAmount) {
        Input input = new Input() {
            @Override
            public Integer readLineToInteger() {
                return inputAmount;
            }

            @Override
            public List<Integer> readLineToNumbersWithDelimiter(String delimiter) {
                return null;
            }
        };
        purchaseAmountInputProcessor = new PurchaseAmountInputProcessor(input, promptPrinter);
        assertThatThrownBy(() -> purchaseAmountInputProcessor.inputPurchaseAmount())
                .isInstanceOf(IllegalArgumentException.class);
    }

}
