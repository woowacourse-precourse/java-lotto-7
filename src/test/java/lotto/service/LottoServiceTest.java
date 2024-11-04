package lotto.service;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

import lotto.constant.LottoTestConstant;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoServiceTest {

    LottoService lottoService = new LottoService();

    @ParameterizedTest
    @ValueSource(strings = {"7000j", "2024", "-1", "0", "\n", " "})
    public void 구입_금액_예외_테스트(String moneyInput) {
        assertThatIllegalArgumentException().isThrownBy(() -> lottoService.purchaseLotto(moneyInput))
                .withMessageContaining(LottoTestConstant.ERROR_MESSAGE_HEADER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,1,1,1,1,1", "1,2,3,4,5,46", "\n", " "})
    public void 로또_예외_테스트(String winningNumbersInput) {
        assertThatIllegalArgumentException().isThrownBy(() -> lottoService.setWinningLotto(winningNumbersInput))
                .withMessageContaining(LottoTestConstant.ERROR_MESSAGE_HEADER.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "\n", " ", "1번"})
    public void 보너스_숫자_예외_테스트(String bonusNumberInput) {
        assertThatIllegalArgumentException().isThrownBy(() -> lottoService.setBonusNumber(bonusNumberInput))
                .withMessageContaining(LottoTestConstant.ERROR_MESSAGE_HEADER.getMessage());
    }
}