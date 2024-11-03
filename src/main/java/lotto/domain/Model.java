package lotto.domain;

import java.util.List;
import java.util.Map;
import lotto.domain.util.AddBonusNumber;
import lotto.domain.util.CalculateRoi;
import lotto.domain.util.CreateLottoList;
import lotto.domain.util.CreateWinningMap;
import lotto.domain.util.CreateWinningNumber;
import lotto.validator.AmountValidator;
import lotto.validator.Validator;

public class Model {

    private static final int LOTTO_PRICE = 1000;

    private final int amount;
    private final int count;
    private final List<Lotto> lottos;
    private List<Integer> winningNumbers;
    private final Map<String, Integer> winningMap;
    private long winningAmount;

    public Model(String amount) {
        validate(amount);
        this.amount = Integer.parseInt(amount);
        count = this.amount / LOTTO_PRICE;
        lottos = CreateLottoList.create(count);
        winningMap = CreateWinningMap.create();
    }

    private void totalWinningAmount() {
        for (Lotto lotto : lottos) {
            winningAmount += lotto.winningCount(winningNumbers, winningMap);

        }
    }

    private void validate(String amount) {
        Validator validator = new AmountValidator();
        validator.validate(amount);
    }

    public String calculate() {
        return CalculateRoi.calculate(winningAmount, amount);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int getCount() {
        return count;
    }

    public Map<String, Integer> getWinningMap() {
        totalWinningAmount();
        return winningMap;
    }

    public void setWinningNumbers(String winningNumbers) {
        this.winningNumbers = CreateWinningNumber.create(winningNumbers);
    }

    public void setBonusNumber(String bonusNumber) {
        AddBonusNumber.add(winningNumbers, bonusNumber);
    }

}
