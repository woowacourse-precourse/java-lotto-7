package lotto.model.lotto;

import static lotto.util.CommonValidator.validateMultipleOf;
import static lotto.util.CommonValidator.validatePositiveAmount;
import static lotto.util.LottoConstants.LOTTO_PURCHASE_AMOUNT;

import java.util.ArrayList;
import java.util.List;
import lotto.model.lotto.generator.LottoGenerator;
import lotto.model.lotto.generator.RandomLottoGenerator;

public class LottoStore {
    private final List<Lotto> lottoNumbers = new ArrayList<>();

    public LottoStore(Long purchaseAmount) {
        this(new RandomLottoGenerator(), purchaseAmount);
    }

    public LottoStore(LottoGenerator lottoGenerator, long purchaseAmount) {
        validatePurchaseAmount(purchaseAmount);
        generateLottos(lottoGenerator, purchaseAmount);
    }

    private void generateLottos(LottoGenerator lottoGenerator, long purchaseAmount) {
        int lottoCount = (int) (purchaseAmount / LOTTO_PURCHASE_AMOUNT);
        for (int i = 0; i < lottoCount; i++) {
            lottoNumbers.add(new Lotto(lottoGenerator.generateLotto()));
        }
    }

    public List<Lotto> getLottoNumbers() {
        return List.copyOf(lottoNumbers);
    }

    private void validatePurchaseAmount(long purchaseAmount) {
        validatePositiveAmount(purchaseAmount);
        validateMultipleOf(purchaseAmount, LOTTO_PURCHASE_AMOUNT);
    }
}
