package lotto.model.user;

import static lotto.util.LottoConstant.COST_UNIT;
import static lotto.util.LottoConstant.MAX_LOTTERY_COUNT;

import java.util.ArrayList;
import java.util.List;

import java.util.Set;
import lotto.exception.user.LottoMaximumExceededException;
import lotto.exception.user.NotEnoughMoneyException;
import lotto.exception.user.NotThousandUnitException;
import lotto.util.ValidateUtil;

public class LotteryMachine {

    private final List<LottoNumbers> lottoNumbersList;
    private final int lotteryCount;

    public LotteryMachine(final String insertedMoney) {
        lotteryCount = createLotteryCount(insertedMoney);
        lottoNumbersList = createLotteryNumbersList();
    }

    public List<Set<Integer>> getLottoResults() {
        return lottoNumbersList.stream().map(LottoNumbers::getLotteryNumbers).toList();
    }

    public int getLotteryCount() {
        return lotteryCount;
    }

    private List<LottoNumbers> createLotteryNumbersList() {
        List<LottoNumbers> resultNumbersList = new ArrayList<>();
        for (int left = 0; left < lotteryCount; left++) {
            resultNumbersList.add(new LottoNumbers());
        }
        return resultNumbersList;
    }

    private int createLotteryCount(final String insertedMoney) {
        ValidateUtil.validateNumber(insertedMoney);
        final int funds = parseToInt(insertedMoney);
        validateMaxLotteryCount(funds);
        validateCostUnit(funds);

        return funds / COST_UNIT.getNumber();
    }

    private int parseToInt(final String insertedMoney) {
        try {
            return Integer.parseInt(insertedMoney);
        } catch (NumberFormatException e) {
            throw new LottoMaximumExceededException();
        }
    }

    private void validateMaxLotteryCount(final int funds) {
        if(funds > MAX_LOTTERY_COUNT.getNumber() * COST_UNIT.getNumber()) {
            throw new LottoMaximumExceededException();
        }
    }

    private void validateCostUnit(final int funds) {
        if(funds < COST_UNIT.getNumber()) {
            throw new NotEnoughMoneyException();
        }

        if(funds % COST_UNIT.getNumber() != 0) {
            throw new NotThousandUnitException();
        }
    }
}
