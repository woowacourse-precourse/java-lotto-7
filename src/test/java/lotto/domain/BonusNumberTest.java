package lotto.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import lotto.validator.BonusNumberValidator;
import lotto.validator.DefaultDuplicateValidator;
import lotto.validator.DefaultRangeValidator;
import lotto.validator.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("BonusNumber 클래스 테스트")
public class BonusNumberTest {

    BonusNumberValidator bonusValidator = new BonusNumberValidator(new DefaultRangeValidator());
    LottoValidator lottoValidator = new LottoValidator(new DefaultRangeValidator(), new DefaultDuplicateValidator());
    Lotto lotto = new Lotto(List.of(1,2,3,4,5,6), lottoValidator);

    @Test
    void 보너스_번호가_정상_범위_밖이면_예외를_발생() {
        assertThatThrownBy(() -> BonusNumber.getInstance(60, lotto, bonusValidator))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 보너스_번호가_당첨_번호와_중복되면_예외를_발생() {
        assertThatThrownBy(() -> BonusNumber.getInstance(5, lotto, bonusValidator))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
