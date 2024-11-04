package lotto.model.lotto;

import java.util.ArrayList;
import java.util.List;
import lotto.common.LottoConst;
import lotto.error.ErrorMessage;
import lotto.model.parseLotto.ParseLotto;
import lotto.model.util.CalculatorProfit;
import lotto.model.util.GeneraterLotto;

public class Lottos {
    private List<Lotto> lottos;

    private List<Integer> winNumbers;

    private int lottosCount;

    private int bonusNumber;

    private Winstatus winstatus;

    private double profitRate;

    private int buyAmount;

    public Lottos(List<String> winNumbersStr, int buyAmount, int bonusNumber) {

        this.buyAmount = buyAmount;
        winNumbers = ParseLotto.winNumberStrToInteger(winNumbersStr);
        lottos = new ArrayList<>();
        lottosCount = buyAmount / LottoConst.LOTTOPERAMOUNT.getLottoConst();

        validateOverlapBonusNumber(bonusNumber);

        this.bonusNumber = bonusNumber;
        winstatus = new Winstatus();
    }

    public void generateLotto() {
        GeneraterLotto.generateLotto(lottos, lottosCount);
    }

    public double calculateProfitRate() {
        return profitRate = CalculatorProfit.calProfitRate(winstatus.getStatus(), buyAmount);
    }

    private void validateOverlapBonusNumber(int bonusNumber){
        if (winNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(ErrorMessage.OVERLAPBONUSNUMBER.getMessage());
        }
    }


    public void lottosSort() {
        for (Lotto lotto : lottos) {
            lotto.numbersSort();
        }
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getLottosCount() {
        return lottosCount;
    }

    public List<Integer> getWinNumbers() {
        return winNumbers;
    }

    public int getBonusNumber() {
        return bonusNumber;
    }

    public Winstatus getWinstatus() {
        return winstatus;
    }

    public double getProfitRate() {
        return profitRate;
    }

}
