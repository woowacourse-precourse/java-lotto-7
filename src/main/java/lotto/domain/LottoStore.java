package lotto.domain;

import java.util.ArrayList;
import java.util.List;
import lotto.dto.LottoPaper;
import lotto.generator.LottoNumberGenerator;

public class LottoStore {
    private static final Won BASE_AMOUNT = new Won(1000);
    private final LottoNumberGenerator lottoNumberGenerator;

    public LottoStore(LottoNumberGenerator lottoNumberGenerator) {
        this.lottoNumberGenerator = lottoNumberGenerator;
    }

    public LottoPaper buy(Won fee) {
        validateMinimumAmount(fee);
        validateAmountIsInBaseUnit(fee);
        return new LottoPaper(fee, createLottos((int) fee.divide(BASE_AMOUNT)));
    }

    private void validateMinimumAmount(Won fee) {
        if (BASE_AMOUNT.isLessThan(fee)) {
            throw new IllegalArgumentException(String.format("금액이 %s보다 낮을 수 없습니다.", BASE_AMOUNT));
        }
    }

    private void validateAmountIsInBaseUnit(Won fee) {
        if (fee.hasChange(BASE_AMOUNT)) {
            throw new IllegalArgumentException(String.format("금액은 %s단위 여야합니다.", BASE_AMOUNT));
        }
    }

    private List<Lotto> createLottos(int count) {
        List<Lotto> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            result.add(Lotto.fromIntegers(lottoNumberGenerator.generate()));
        }
        return result;
    }
}
