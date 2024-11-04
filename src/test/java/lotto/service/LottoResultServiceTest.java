package lotto.service;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import lotto.domain.Prize;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.PublishLotto;
import lotto.validator.BonusNumberValidator;
import lotto.validator.DefaultDuplicateValidator;
import lotto.validator.DefaultRangeValidator;
import lotto.validator.LottoValidator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("LottoProfitCalculateService 클래스 테스트")
public class LottoResultServiceTest {

    private LottoResultService lottoResultService;
    private LottoValidator lottoValidator;
    private BonusNumberValidator bonusNumberValidator;

    @BeforeEach
    void setUp() {
        lottoResultService = new LottoResultService();
        lottoValidator = new LottoValidator(new DefaultRangeValidator(),
            new DefaultDuplicateValidator());
        bonusNumberValidator = new BonusNumberValidator(new DefaultRangeValidator());
    }

    @Test
    void 로또_결과를_정확히_계산한다() {
        // given
        Lotto winningLotto = new Lotto(List.of(1, 2, 3, 4, 5, 6), lottoValidator);
        BonusNumber bonusLotto = BonusNumber.getInstance(7, winningLotto, bonusNumberValidator);

        Set<PublishLotto> publishLottoList = new HashSet<>();
        publishLottoList.add(new PublishLotto(List.of(1, 2, 3, 8, 9, 10), lottoValidator));
        publishLottoList.add(new PublishLotto(List.of(4, 5, 6, 11, 12, 13), lottoValidator));
        publishLottoList.add(new PublishLotto(List.of(1, 2, 3, 4, 5, 6), lottoValidator));

        // when
        Map<Prize, Integer> calculatePrize = lottoResultService.calculatePrize(winningLotto,
            bonusLotto, publishLottoList);

        // then
        assertEquals(calculatePrize.get(Prize.FIRST), 1);
    }

}
