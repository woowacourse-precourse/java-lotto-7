package lotto.service;

import lotto.util.NumberUtil;
import lotto.view.InputView;

public class LottoGeneratorService {
    private final InputView inputView;

    public LottoGeneratorService(InputView inputView) {
        this.inputView = inputView;
    }

    public int lottoPurchase() {
        String input = inputView.promptPurchaseAmount();
        int number = NumberUtil.parsePositiveNumber(input);
        return number;
    }

    public boolean checkThousandUnit(int number) {
        if (number % 1000 == 0) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 합니다.");
    }

}
