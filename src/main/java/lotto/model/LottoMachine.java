package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.Constants.LOTTO_MAX_NUMBER;
import static lotto.Constants.LOTTO_MIN_NUMBER;
import static lotto.Constants.LOTTO_PRICE;
import static lotto.Constants.LOTTO_SIZE;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {

    private final List<Lotto> generatedLottos;

    public LottoMachine() {
        this(new ArrayList<>());
    }

    public LottoMachine(List<Lotto> generatedLottos) {
        this.generatedLottos = generatedLottos;
    }

    public List<Lotto> generateLotto(int purchaseAmount) {
        validate(purchaseAmount);
        int numberOfLottos = purchaseAmount / LOTTO_PRICE;

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> generatedNumbers = pickUniqueNumbersInRange(
                    LOTTO_MIN_NUMBER, LOTTO_MAX_NUMBER,
                    LOTTO_SIZE
            );
            generatedLottos.add(new Lotto(generatedNumbers));
        }
        return List.copyOf(generatedLottos);
    }

    private void validate(int purchaseAmount) {
        if (isNotPositive(purchaseAmount) || isNotValidPurchaseUnit(purchaseAmount)) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 천 원 단위여야 합니다.");
        }
    }

    private boolean isNotPositive(int purchaseAmount) {
        return purchaseAmount <= 0;
    }

    private boolean isNotValidPurchaseUnit(int purchaseAmount) {
        return purchaseAmount % LOTTO_PRICE != 0;
    }

    public LottoResult match(WinningNumbers winningNumbers) {
        return LottoResult.of(winningNumbers, generatedLottos);
    }
}
