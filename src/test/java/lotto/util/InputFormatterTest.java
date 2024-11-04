package lotto.util;

import static org.assertj.core.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import lotto.constant.LottoTestConstant;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputFormatterTest {

    private final InputFormatter inputFormatter = new InputFormatter();

    @Test
    public void 금액_입력값_파싱_테스트() {
        String moneyInput = "5000";
        int expectedParsedMoneyInput = 5000;

        assertThat(inputFormatter.formatMoneyInput(moneyInput))
                .isEqualTo(expectedParsedMoneyInput);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1000원", "\n", "", " "})
    public void 금액_입력값_타입_예외_테스트(String moneyInput) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputFormatter.formatMoneyInput(moneyInput))
                .withMessageContaining(LottoTestConstant.ERROR_MESSAGE_HEADER.getMessage());
    }

    @Test
    public void 로또_입력값_파싱_테스트() {
        String winningNumbersInput = "1,2,3,4,5,6";
        List<Integer> expectedParsedLotto = Arrays.asList(1, 2, 3, 4, 5, 6);

        assertThat(inputFormatter.formatWinningNumbersInput(winningNumbersInput))
                .isEqualTo(expectedParsedLotto);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1번,2번,3번,4번,5번,6번", "\n", "", " "})
    public void 로또_입력값_타입_예외_테스트(String winningNumbersInput) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputFormatter.formatWinningNumbersInput(winningNumbersInput))
                .withMessageContaining(LottoTestConstant.ERROR_MESSAGE_HEADER.getMessage());
    }

    @Test
    public void 보너스_번호_입력값_파싱_테스트() {
        String winningNumbersInput = "7";
        int expectedParsedBonusNumber = 7;

        assertThat(inputFormatter.formatBonusNumberInput(winningNumbersInput))
                .isEqualTo(expectedParsedBonusNumber);
    }

    @ParameterizedTest
    @ValueSource(strings = {"7번", "\n", "", " "})
    public void 보너스_번호_입력값_타입_예외_테스트(String bonusNumberInput) {
        assertThatIllegalArgumentException().isThrownBy(() -> inputFormatter.formatBonusNumberInput(bonusNumberInput))
                .withMessageContaining(LottoTestConstant.ERROR_MESSAGE_HEADER.getMessage());
    }
}