package lotto.validator;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ValidatorTest {
    @ParameterizedTest
    @ValueSource(strings = {"1000", "10000", "100000"})
    void 로또_구입_금액_유효성_검증_성공_테스트(String input) {
        Validator.validatePurchaseAmount(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"0", "1", "1500", "-1000", "abc", ",./", "10 00"})
    void 로또_구입_금액_유효성_검증_실패_테스트(String input) {
        assertThatThrownBy(() -> Validator.validatePurchaseAmount(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1, 2, 3, 4, 5, 6", "40,41,42,43,44,45"})
    void 당첨_번호_유효성_검증_성공_테스트(String input) {
        Validator.validateWinningNumbers(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {
            "0,1,2,3,4,5",
            "-1,1,2,3,4,5",
            "41,42,43,44,45,46",
            "1,2,3,4,5",
            "1.2.3.4.5.6",
            "a,b,c,d,e,f"})
    void 당첨_번호_유효성_검증_실패_테스트(String input) {
        assertThatThrownBy(() -> Validator.validateWinningNumbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"1", "25", "45"})
    void 보너스_번호_유효성_검증_성공_테스트(String input) {
        Validator.validateBonusNumber(input);
    }

    @ParameterizedTest
    @ValueSource(strings = {"-1", "0", "1, 2", "46", "a", "ab", "abcd"})
    void 보너스_번호_유효성_검증_실패_테스트(String input) {
        assertThatThrownBy(() -> Validator.validateBonusNumber(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 당첨_번호_중복_검증_성공_테스트() {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 7;
        Validator.checkDuplicateBonusNumbers(lottoNumbers, bonusNumber);
    }

    @Test
    void 당첨_번호_중복_검증_실패_테스트() {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 1, 2, 3, 4, 5));
        assertThatThrownBy(() -> Validator.checkDuplicateLottoNumbers(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호_중복_검증_실패_테스트() {
        List<Integer> lottoNumbers = new ArrayList<>(List.of(1, 2, 3, 4, 5, 6));
        int bonusNumber = 1;
        assertThatThrownBy(() -> Validator.checkDuplicateBonusNumbers(lottoNumbers, bonusNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}