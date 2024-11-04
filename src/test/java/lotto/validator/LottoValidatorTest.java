package lotto.validator;


import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class LottoValidatorTest {
    private LottoValidator lottoValidator;

    @BeforeEach
    void setup() {
        lottoValidator = new LottoValidator();
    }

    @Test
    void 로또_번호_중복_예외_테스트() {
        List<Integer> lottoNumbers = Arrays.asList(1, 5, 5, 7, 20, 25);

        Assertions.assertThatThrownBy(() -> lottoValidator.validateLottoNumbersDuplication(lottoNumbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호에 중복된 숫자가 있습니다.");
    }

    @Test
    void 보너스_번호_범위_검증_실패_테스트() {
        int invalidBonusNumber = 46;

        Assertions.assertThatThrownBy(() -> {
                    lottoValidator.validateBonusLottoRange(invalidBonusNumber);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 로또 번호는 1부터 45 사이의 정수여야 합니다. 잘못된 번호: 46");
    }

    @Test
    void 보너스_번호가_로또_번호에_있는지_검증_실패_테스트() {
        List<Integer> lottoNumbers = Arrays.asList(1, 5, 10, 20, 30, 45);
        int bonusNumber = 10;

        Assertions.assertThatThrownBy(() -> {
                    lottoValidator.validateBonusNumberInLottoNumber(lottoNumbers, bonusNumber);
                })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("[ERROR] 보너스 번호랑 로또 번호는 중복 불가합니다.");
    }
}
