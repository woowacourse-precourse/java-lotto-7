package lotto;

import java.util.List;
import lotto.global.ErrorMessage;

public class LottoGame {
    private static final int MONEY_THRESHOLD = 1000;
    private final int inputMoney;
    private final LottoGroup lottoGroup;

    public LottoGame(int inputMoney, LottoGenerateStrategy lottoGenerateStrategy) {
        validate(inputMoney);
        this.inputMoney = inputMoney;
        this.lottoGroup = LottoGroup.from(lottoGenerateStrategy, convertToCount(inputMoney));
    }

    private void validate(int money){
        if (money % MONEY_THRESHOLD != 0){
            throw new IllegalArgumentException(ErrorMessage.INVALID_MONEY.getMessage());
        }
    }

    public float getEarningRate(List<Integer> choices, int bonusNumber) {
        int totalReward = lottoGroup.getTotalReward(choices, bonusNumber);
        float earningRate = (float) totalReward / inputMoney * 100;
        return Math.round(earningRate * 10) / 10.0f;
    }

    private int convertToCount(int money){
        return money / MONEY_THRESHOLD;
    }

    public String getPurchasedLotto(){
        return lottoGroup.toString();
    }

    public List<Prize> getPrizes(List<Integer> choices, int bonusNumber){
        return lottoGroup.getPrizes(choices, bonusNumber);
    }
}
