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
                .hasMessageMatching("\\[ERROR\\] 로또 번호에 중복된 숫자가 있습니다.");
    }
}
