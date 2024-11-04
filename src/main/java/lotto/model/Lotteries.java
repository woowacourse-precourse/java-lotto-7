package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotteries {
    private static final String UNIT_ERROR_MESSAGE = "[ERROR] 1000원 단위로 입력해 주세요.";
    private static final Integer LOTTERY_PRICE = 1000;
    private final List<Lotto> lotteries = new ArrayList<>();
    private final Integer totalMoney;

    public Lotteries(Integer totalMoney) {
        this.totalMoney = totalMoney;

        validateTotalMoney();

        for(int i = 0; i < totalMoney / LOTTERY_PRICE; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            numbers.sort(Comparator.naturalOrder());
            lotteries.add(new Lotto(numbers));
        }
    }

    private void validateTotalMoney() {
        if (totalMoney % LOTTERY_PRICE != 0) {
            throw new IllegalArgumentException(UNIT_ERROR_MESSAGE);
        }
    }

    public String formatOutput() {
        String output = "";
        output += String.format("\n%d개를 구매했습니다.\n", lotteries.size());
        for(Lotto lotto : lotteries) {
            output += lotto.formatNumbers();
        }

        return output;
    }

    public Prizes getPrizes(WinningLotto winningLotto) {
        Prizes prizes = new Prizes();

        for (Lotto lotto : lotteries) {
            Prize prize = winningLotto.getPrize(lotto);
            prizes.addPrize(prize);
        }

        return prizes;
    }
}

