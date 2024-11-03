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

    public void initializeWinningNumbers(String winningNumbers) {
        this.winningNumbers = CreateWinningNumber.create(winningNumbers);
    }

    public void appendBonusNumber(String bonusNumber) {
        AddBonusNumber.add(winningNumbers, bonusNumber);
        calculateTotalWinnings();
    }

    private void calculateTotalWinnings() {
        for (Lotto lotto : lottos) {
            winningAmount += lotto.compareNumbers(winningNumbers, winningDetail);
        }
    }

    public String computeRoi() {
        return CalculateRoi.calculate(winningAmount, amount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getCount() {
        return count;
    }

    public Map<String, Integer> getWinningDetail() {
        return winningDetail;
    }
}
