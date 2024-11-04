package lotto.function.winning.register.processor;

import java.util.List;
import java.util.stream.Stream;
import lotto.domain.Lotto;
import lotto.io.input.Input;
import lotto.io.printer.prompt.PromptPrinter;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class WinningLottoNumbersInputProcessorTest {

    WinningLottoNumbersInputProcessor winningLottoNumbersInputProcessor;
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
    @MethodSource("inputNumbers")
    void 당첨_번호를_입력_받으면_1등_Lotto_객체를_생성한다(List<Integer> inputNumbers) {
        Input input = new Input() {
            @Override
            public Integer readLineToInteger() {
                return null;
            }

            @Override
            public List<Integer> readLineToNumbersWithDelimiter(String delimiter) {
                return inputNumbers;
            }
        };
        winningLottoNumbersInputProcessor =
                new WinningLottoNumbersInputProcessor(promptPrinter, input);

        Lotto firstPlaceLotto = winningLottoNumbersInputProcessor.inputWinningLottoNumbers();
        Assertions.assertThat(firstPlaceLotto.containsAll(inputNumbers)).isTrue();
    }

    public static Stream<Arguments> inputNumbers() {
        return Stream.of(
                Arguments.of(List.of(1, 2, 3, 4, 5, 6)),
                Arguments.of(List.of(10, 20, 30, 40, 16, 17))
        );
    }
}