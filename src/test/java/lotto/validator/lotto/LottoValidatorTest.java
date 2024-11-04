package lotto.validator.lotto;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.error.lotto.LottoErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class LottoValidatorTest {

    @DisplayName("구입금액을 위한 입력은 양수여야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000"})
    void 구입금액_양수_입력값_테스트(String purchaseAmount) {
        //given
        LottoValidator lottoValidator = new LottoValidator();

        //when //then
        lottoValidator.validatePurchaseAmount(purchaseAmount);
    }

    @DisplayName("구입금액을 위한 입력이 양수외의 값은 들어올 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000a", "b", "1000 "})
    void 구입금액_양수_외_입력값_테스트(String purchaseAmount) {
        //given
        LottoValidator lottoValidator = new LottoValidator();

        //when //then
        Assertions.assertThatThrownBy(() -> {
                    lottoValidator.validatePurchaseAmount(purchaseAmount);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.INPUT_DATA_IS_NOT_POSITIVE);
    }

    @DisplayName("구입금액은 정책에 맞춘 단위어야 한다.")
    @ParameterizedTest
    @ValueSource(strings = {"1000", "2000"})
    void 구입금액_정책_테스트(String purchaseAmount) {
        //given
        LottoValidator lottoValidator = new LottoValidator();

        //when //then
        lottoValidator.validatePurchaseAmount(purchaseAmount);
    }

    @DisplayName("정책에 맞지 않는 구입금액은 안된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1500", "100"})
    void 구입금액_정책_외_테스트(String purchaseAmount) {
        //given
        LottoValidator lottoValidator = new LottoValidator();

        //when //then
        Assertions.assertThatThrownBy(() -> {
                    lottoValidator.validatePurchaseAmount(purchaseAmount);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.INVALID_PURCHASE_POLICY);
    }

    @DisplayName("당첨번호는 중복을 고려해 정책에 맞지않는 개수는 안된다.")
    @ParameterizedTest
    @ValueSource(strings = {"1,2,3,4,5", "1,2,3,4,5,6,7", "1,2,3,4,5,1"})
    void 당첨번호_중복되지않은_개수_외_테스트(String winningNumbers) {
        //given
        LottoValidator lottoValidator = new LottoValidator();

        //when //then
        Assertions.assertThatThrownBy(() -> {
                    lottoValidator.validateWinningNumbers(winningNumbers);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.INPUT_DATA_IS_NOT_PATTERN);
    }

    @DisplayName("1~45 외의 당첨번호는 안된다.")
    @ParameterizedTest
    @ValueSource(strings = {"0,1,2,3,4", "1,2,3,4,46"})
    void 당첨번호_범위_외_테스트(String winningNumbers) {
        //given
        LottoValidator lottoValidator = new LottoValidator();

        //when //then
        Assertions.assertThatThrownBy(() -> {
                    lottoValidator.validateWinningNumbers(winningNumbers);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.INPUT_DATA_IS_NOT_PATTERN);
    }

    @DisplayName("담청번호는 6개의 번호가 중복되지 않으며 1~45 사이의 값이다.")
    @Test
    void 당첨번호_검증_통합_테스트() {
        //given
        LottoValidator lottoValidator = new LottoValidator();
        String winningNumbers = "1,2,3,4,5,45";

        //when //then
        lottoValidator.validateWinningNumbers(winningNumbers);
    }

    @DisplayName("보너스번호는 한개의 숫자 외의 입력은 안된다.")
    @ParameterizedTest
    @ValueSource(strings = {"a", "1,2"})
    void 보너스번호_정책_외_테스트(String bonusNumber) {
        //given
        LottoValidator lottoValidator = new LottoValidator();
        Set<Integer> winningNumbers = new HashSet<>(List.of(1, 2, 3, 4, 5));

        //when //then
        Assertions.assertThatThrownBy(() -> {
                    lottoValidator.validateBonusNumber(winningNumbers, bonusNumber);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.INPUT_DATA_IS_NOT_POSITIVE);
    }

    @DisplayName("1~45 외의 보너스번호는 안된다.")
    @ParameterizedTest
    @ValueSource(strings = {"0", "46", "-1"})
    void 보너스번호_범위_외_테스트(String bonusNumber) {
        //given
        LottoValidator lottoValidator = new LottoValidator();
        Set<Integer> winningNumbers = new HashSet<>(List.of(1, 2, 3, 4, 5));

        //when //then
        Assertions.assertThatThrownBy(() -> {
                    lottoValidator.validateBonusNumber(winningNumbers, bonusNumber);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.INPUT_DATA_IS_NOT_PATTERN);
    }

    @DisplayName("보너스번호는 당첨번호와 중복될 수 없다.")
    @Test
    void 보너스번호_중복_테스트() {
        //given
        LottoValidator lottoValidator = new LottoValidator();
        Set<Integer> winningNumbers = new HashSet<>(List.of(1, 2, 3, 4, 5));
        String bonusNumber = "1";

        //when //then
        Assertions.assertThatThrownBy(() -> {
                    lottoValidator.validateBonusNumber(winningNumbers, bonusNumber);
                }).isInstanceOf(IllegalArgumentException.class)
                .hasMessage(LottoErrorMessage.INPUT_DATA_IS_NOT_PATTERN);
    }

    @DisplayName("보너스번호는 1개의 번호가 당첨번호와 중복되지 않으며 1~45 사이의 값이다.")
    @Test
    void 보너스번호_검증_통합_테스트() {
        //given
        LottoValidator lottoValidator = new LottoValidator();
        Set<Integer> winningNumbers = new HashSet<>(List.of(1, 2, 3, 4, 5));
        String bonusNumber = "6";

        //when //then
        lottoValidator.validateBonusNumber(winningNumbers, bonusNumber);
    }
}
