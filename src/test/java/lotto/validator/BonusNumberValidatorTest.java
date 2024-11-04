package lotto.validator;

import java.util.List;
import lotto.model.Lotto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BonusNumberValidatorTest {

    private BonusNumberValidator bonusNumberValidator;

    @BeforeEach
    void beforeEach() {
        this.bonusNumberValidator = new BonusNumberValidator();
    }

    @Test
    @DisplayName("보너스 번호가 범위 밖의 숫자 일 경우")
    void 보너스_번호가_범위_밖의_숫자_일_경우() {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> bonusNumberValidator.validateBonusNumber(lotto, 46));
    }

    @Test
    @DisplayName("보너스 번호가 당첨 번호와 중복 되는 경우")
    void 보너스_번호가_당첨_번호와_중복_되는_경우() {
        Lotto lotto = Lotto.of(List.of(1, 2, 3, 4, 5, 6));
        Assertions.assertThrows(IllegalArgumentException.class,
                () -> bonusNumberValidator.validateBonusNumber(lotto, 2));
    }
}
