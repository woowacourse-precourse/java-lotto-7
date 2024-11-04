package lotto.function.winning.register.processor;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import lotto.domain.BonusLotto;
import lotto.io.input.Input;
import lotto.io.printer.prompt.PromptPrinter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusLottoNumberInputProcessorTest {

    BonusLottoNumberInputProcessor bonusLottoNumberInputProcessor;
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
    @ValueSource(ints = {1, 3, 45})
    void 보너스_번호를_입력_받으면_BonusLotto_객체를_생성한다(int bonusNumber) {
        Input input = new Input() {
            @Override
            public Integer readLineToInteger() {
                return bonusNumber;
            }

            @Override
            public List<Integer> readLineToNumbersWithDelimiter(String delimiter) {
                return null;
            }
        };
        bonusLottoNumberInputProcessor = new BonusLottoNumberInputProcessor(promptPrinter, input);

        BonusLotto bonusLotto = bonusLottoNumberInputProcessor.inputBonusLottoNumber();
        assertThat(bonusLotto.getBonusNumber()).isEqualTo(bonusNumber);
    }

}