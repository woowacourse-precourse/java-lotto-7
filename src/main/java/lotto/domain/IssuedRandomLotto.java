package lotto.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lotto.common.LottoConfig;
import lotto.common.RandomNumberGenerator;
import lotto.common.validator.IssuedLottoValidator;

public class IssuedRandomLotto implements IssuedLotto {
    private final RandomNumberGenerator randomNumberGenerator;
    private final int lottoPurchaseAmount;
    private List<Lotto> issuedLottos = new ArrayList<>();

    public IssuedRandomLotto(RandomNumberGenerator randomNumberGenerator, int lottoPurchaseAmount) {
        IssuedLottoValidator.validate(lottoPurchaseAmount);
        this.randomNumberGenerator = randomNumberGenerator;
        this.lottoPurchaseAmount = lottoPurchaseAmount;
    }

    public IssuedRandomLotto(RandomNumberGenerator randomNumberGenerator, List<Lotto> issuedLottos,
                             int lottoPurchaseAmount) {
        IssuedLottoValidator.validate(lottoPurchaseAmount);
        this.randomNumberGenerator = randomNumberGenerator;
        this.issuedLottos = new ArrayList<>(issuedLottos);
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

    @Override
    public List<Lotto> getIssuedLottos() {
        return Collections.unmodifiableList(issuedLottos);
    }

    @Override
    public int getLottoPurchaseAmount() {
        return lottoPurchaseAmount;
    }

    private int calculateQuantity() {
        return lottoPurchaseAmount / LottoConfig.LOTTO_PRICE.getValue();
    }

    private List<Integer> generateRandomLottoNumbers() {
        return randomNumberGenerator.generateUniqueRandomNumber();
    }
}
