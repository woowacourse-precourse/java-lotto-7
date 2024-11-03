package lotto.model;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;
import static lotto.constant.ExceptionMessage.INVALID_PURCHASE_UNIT;
import static lotto.constant.ExceptionMessage.IS_NOT_POSITIVE;
import static lotto.constant.LottoConstants.MAX_NUMBER;
import static lotto.constant.LottoConstants.MIN_NUMBER;
import static lotto.constant.LottoConstants.PRICE;
import static lotto.constant.LottoConstants.VALID_SIZE;

import java.util.ArrayList;
import java.util.List;

public class LottoMachine {
    private static final int ZERO = 0;
    private final List<Lotto> generatedLottos;

    public LottoMachine() {
        this(new ArrayList<>());
    }

    public LottoMachine(List<Lotto> generatedLottos) {
        this.generatedLottos = generatedLottos;
    }

    public List<Lotto> generateLotto(int purchaseAmount) {
        validate(purchaseAmount);
        int numberOfLottos = purchaseAmount / PRICE.getValue();

        for (int i = 0; i < numberOfLottos; i++) {
            List<Integer> generatedNumbers = pickUniqueNumbersInRange(
                    MIN_NUMBER.getValue(), MAX_NUMBER.getValue(), VALID_SIZE.getValue()
            );
            generatedLottos.add(new Lotto(generatedNumbers));
        }
        return List.copyOf(generatedLottos);
    }

    private void validate(int purchaseAmount) {
        if (isNotPositive(purchaseAmount)) {
            throw new IllegalArgumentException(IS_NOT_POSITIVE.getMessage());
        }
        if (isNotValidPurchaseUnit(purchaseAmount)) {
            throw new IllegalArgumentException(INVALID_PURCHASE_UNIT.getMessage());
        }
    }

    private boolean isNotPositive(int purchaseAmount) {
        return purchaseAmount <= ZERO;
    }

    private boolean isNotValidPurchaseUnit(int purchaseAmount) {
        return purchaseAmount % PRICE.getValue() != ZERO;
    }

    public LottoResult match(WinningNumbers winningNumbers) {
        return LottoResult.of(winningNumbers, generatedLottos);
    }
}
