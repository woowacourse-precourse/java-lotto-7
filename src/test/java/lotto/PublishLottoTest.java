package lotto;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import lotto.domain.PublishLotto;
import lotto.validator.DefaultDuplicateValidator;
import lotto.validator.DefaultRangeValidator;
import lotto.validator.LottoValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("PublishLotto 클래스 테스트")
public class PublishLottoTest {

    LottoValidator lottoValidator = new LottoValidator(new DefaultRangeValidator(), new DefaultDuplicateValidator());

    @Test
    void 발행_로또가_범위_중복_개수_검증을_모두_통과하는_테스트() {
        PublishLotto publishLotto = PublishLotto.from(lottoValidator);

        assertNotNull(publishLotto);
    }

}
