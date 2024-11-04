package lotto.service;

import lotto.util.NumberUtil;
import lotto.view.InputView;

public class LottoPurchaseService {
    public static final int LOTTO_PRICE = 1000;
    private final InputView inputView;

    public LottoPurchaseService(InputView inputView) {
        this.inputView = inputView;
    }

    public int getPurchasedLottoCount() {
        int lottoCount = repeatPromptPurchaseAmount();
        return calculateLottoCount(lottoCount);
    }

    public int repeatPromptPurchaseAmount() {
        int lottoCount;
        while (true) {
            try {
                String input = inputView.promptPurchaseAmount();
                lottoCount = NumberUtil.parsePositiveNumber(input);
                checkThousandUnit(lottoCount);
                return lottoCount;
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public boolean checkThousandUnit(int number) {
        if (number % 1000 == 0) {
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 구입금액은 1000원 단위여야 합니다.");
    }

    public int calculateLottoCount(int amount) {
        return amount / LOTTO_PRICE;
    }

}
