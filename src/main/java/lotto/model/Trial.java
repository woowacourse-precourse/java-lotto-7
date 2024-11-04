package lotto.model;

import static lotto.util.Constant.LOTTO_PRICE;

public class Trial {

    private final int trial;

    public Trial(int money) {
        this.trial = money / LOTTO_PRICE;
    }

    public int getTrial() {
        return trial;
    }
}
