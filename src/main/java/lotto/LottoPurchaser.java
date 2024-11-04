package lotto;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickUniqueNumbersInRange;

public class LottoPurchaser {
    private final int lottoPurchaseCount;

    public LottoPurchaser(String purchaseAmountInput) {
        validatePurchaseAmount(purchaseAmountInput);
        this.lottoPurchaseCount = Integer.parseInt(purchaseAmountInput) / Constants.LOTTO_PRICE;
    }

    public List<Lotto> purchaseLotto() {
        List<Lotto> purchasedLottos = new ArrayList<>();
        for (int i = 0; i < lottoPurchaseCount; i++){
            purchasedLottos.add(generateLotto());
        }
        return purchasedLottos;
    }

    private Lotto generateLotto() {
        return new Lotto(pickUniqueNumbersInRange(1, 45, 6));
    }

    private void validatePurchaseAmount(String purchaseAmountInput) {
        validateIntegerInput(purchaseAmountInput);
        validateThousandUnit(purchaseAmountInput);
    }

    private void validateIntegerInput(String purchaseAmountInput) {
        boolean isInteger = purchaseAmountInput.chars().allMatch(Character::isDigit);
        if (!isInteger) {
            throw new IllegalArgumentException("[ERROR] 숫자가 아닌 값을 입력하셨습니다.");
        }
    }

    private void validateThousandUnit(String purchaseAmountInput) {
        int amount = Integer.parseInt(purchaseAmountInput);
        if (amount % Constants.LOTTO_PRICE != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1000원 단위여야 합니다.");
        }
    }
}
