package lotto.domain;

import java.util.ArrayList;
import java.util.List;
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
        int quantity = lottoPurchaseAmount / 1000;
        for (int i = 0; i < quantity; i++) {
            Lotto issuedLotto = new Lotto(generateRandomLottoNumbers());
            issuedLottos.add(issuedLotto);
        }
    }

    public List<Lotto> getIssuedLottos() {
        return issuedLottos;
    }

    private List<Integer> generateRandomLottoNumbers() {
        return randomNumberGenerator.generateUniqueRandomNumber();
    }

    private void validate(int lottoPurchaseAmount) {
        if (lottoPurchaseAmount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 1,000원 단위로 입력해주세요.");
        }
        if (lottoPurchaseAmount > 10000) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 10,000원 이하로 입력해주세요.");
        }
    }
}
