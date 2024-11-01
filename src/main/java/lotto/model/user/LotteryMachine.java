package lotto.model;

import java.util.ArrayList;
import java.util.List;

import lotto.exception.user.LottoMaximumExceededException;
import lotto.exception.user.NotEnoughMoneyException;
import lotto.exception.NotNumberException;
import lotto.exception.user.NotThousandUnitException;
import lotto.util.ValidateUtil;

public class LotteryMachine {

    private static final int COST_UNIT = 1000;
    private static final int MAX_LOTTERY_COUNT = 100;

    private final List<LottoNumbers> lottoNumbersList;
    private final int lotteryCount;

    public LotteryMachine(final String insertedMoney) {
        lotteryCount = createLotteryCount(insertedMoney);
        lottoNumbersList = createLotteryNumbersList();
    }

    public List<String> getLottoResult() {
        return lottoNumbersList.stream().map(LottoNumbers::toPrettyString).toList();
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

        return funds / COST_UNIT;
    }

    private int parseToInt(final String insertedMoney) {
        try {
            return Integer.parseInt(insertedMoney);
        } catch (NumberFormatException e) {
            throw new LottoMaximumExceededException();
        }
    }

    private void validateMaxLotteryCount(final int funds) {
        if(funds > MAX_LOTTERY_COUNT * COST_UNIT) {
            throw new LottoMaximumExceededException();
        }
    }

    private void validateCostUnit(final int funds) {
        if(funds < COST_UNIT) {
            throw new NotEnoughMoneyException();
        }

        if(funds % COST_UNIT != 0) {
            throw new NotThousandUnitException();
        }
    }
}
