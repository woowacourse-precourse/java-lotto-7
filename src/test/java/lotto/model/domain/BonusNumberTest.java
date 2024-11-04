package lotto.model.domain;

import static org.junit.jupiter.api.Assertions.*;

import lotto.constant.ErrorMessage;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BonusNumberTest {
    @Test
    public void 보너스_번호_정상_생성_테스트() throws Exception {
        //given
        int inputBonusNumber = 5;
        //when
        BonusNumber bonusNumber = new BonusNumber(inputBonusNumber);

        //then
        assertEquals(bonusNumber.getBonusNumber(), inputBonusNumber);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 46})
    public void 보너스_번호_범위_초과시_예외_발생(int value) throws Exception {
        //given
        int inputBonusNumber = value;

        //when

        //then
        assertThrows(IllegalArgumentException.class, () -> new BonusNumber(inputBonusNumber),
                ErrorMessage.BONUS_NUMBER_RANGE_VALIDATOR.getMessage());
    }

}