package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.common.LottoConfig;
import lotto.common.RandomNumberGenerator;

public class IssuedRandomLotto implements IssuedLotto {
    private final RandomNumberGenerator randomNumberGenerator;
    private final List<Lotto> issuedLottos = new ArrayList<>();
    private final int lottoPurchaseAmount;

    public IssuedRandomLotto(RandomNumberGenerator randomNumberGenerator, int lottoPurchaseAmount) {
        validate(lottoPurchaseAmount);
        this.randomNumberGenerator = randomNumberGenerator;
        this.lottoPurchaseAmount = lottoPurchaseAmount;
    }

    @Override
    public void generateIssuedLottos() {
        int quantity = calculateQuantity();
        for (int i = 0; i < quantity; i++) {
            Lotto issuedLotto = new Lotto(generateRandomLottoNumbers());
            issuedLottos.add(issuedLotto);
        }
    }

    public List<Lotto> getIssuedLottos() {
        return Collections.unmodifiableList(issuedLottos);
    }

    private int calculateQuantity() {
        return lottoPurchaseAmount / LottoConfig.LOTTO_PRICE.getValue();
    }

    private List<Integer> generateRandomLottoNumbers() {
        return randomNumberGenerator.generateUniqueRandomNumber();
    }

    private void validate(int lottoPurchaseAmount) {
        if (lottoPurchaseAmount % LottoConfig.LOTTO_PRICE.getValue() != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해주세요.");
        }
        if (lottoPurchaseAmount > LottoConfig.LOTTO_PURCHASE_LIMIT.getValue()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 10,000원 이하로 입력해주세요.");
        }
    }
}
