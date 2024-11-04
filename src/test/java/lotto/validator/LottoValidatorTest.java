package lotto.validator;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Test
    void 보너스번호_당첨번호_간에_공통수_있는경우_테스트(){
        int duplicateBonusNum = 25;
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 25);

        assertThatThrownBy(() -> LottoValidator.checkDuplicate(numList, duplicateBonusNum))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스번호_당첨번호_간에_다른경우_테스트() {
        int duplicateBonusNum = 26;
        List<Integer> numList = Arrays.asList(1, 2, 3, 4, 5, 25);

        assertThat(LottoValidator.checkDuplicate(numList, duplicateBonusNum)).isTrue();
    }



}