package lotto.validator;

import org.junit.jupiter.api.Test;

import static lotto.validator.LottoValidator.stringToInt;
import static lotto.validator.LottoValidator.unitValidator;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class LottoValidatorTest {

    @Test
    void 올바른_유효_형식_테스트(){
        boolean result = unitValidator(10000);
        assertThat(result).isTrue();
    }

    @Test
    void 잘못된_유효_형식_테스트(){
        int result = 10300;
        assertThatThrownBy(() -> unitValidator(result)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_형식_테스트(){
        String number = "13000";
        int convertedNumber = stringToInt(number);
        assertThat(convertedNumber).isEqualTo(13000);
    }

    @Test
    void 잘못된_숫자_형식_테스트(){
        String number = "wrong format";
        assertThatThrownBy(() -> stringToInt(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 유효하지_않은_보너스번호_범위_테스트() {
        int invalidBonusNum = 50; // 1~45 범위를 벗어난 경우
        assertThatThrownBy(() -> LottoValidator.checkRangeLotto(invalidBonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }



}