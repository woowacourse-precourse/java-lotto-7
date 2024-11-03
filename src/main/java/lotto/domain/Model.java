package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.domain.util.AddBonusNumber;
import lotto.domain.util.CalculateRoi;
import lotto.domain.util.CreateLottoList;
import lotto.domain.util.CreateWinningMap;
import lotto.domain.util.CreateWinningNumber;

public class Model {

    private static final int LOTTO_PRICE = 1000;

    private final int amount;
    private final int count;
    private final List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private final Map<String, Integer> winningDetail;
    private long winningAmount;

    public Model(String amount) {
        this.amount = Integer.parseInt(amount);
        count = this.amount / LOTTO_PRICE;
        lottos = CreateLottoList.create(count);
        winningDetail = CreateWinningMap.create();
    }

    private void checkWinning() {
        for (Lotto lotto : lottos) {
            winningAmount += lotto.compareNumbers(winningNumbers, winningDetail);
        }
    }

    public String calculate() {
        return CalculateRoi.calculate(winningAmount, amount);
    }

    public void setWinningNumbers(String winningNumbers) {
        this.winningNumbers = CreateWinningNumber.create(winningNumbers);
    }

    public void appendBonusNumber(String bonusNumber) {
        AddBonusNumber.add(winningNumbers, bonusNumber);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getCount() {
        return count;
    }

    public Map<String, Integer> getWinningDetail() {
        checkWinning();
        return winningDetail;
    }
}
