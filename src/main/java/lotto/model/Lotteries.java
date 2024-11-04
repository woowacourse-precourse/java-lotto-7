package lotto.model;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Lotteries {
    private final List<Lotto> lotteries = new ArrayList<>();

    public void buyLotteries(Integer amount) {
        for(int i = 0; i < amount; i++) {
            List<Integer> numbers = new ArrayList<>(Randoms.pickUniqueNumbersInRange(1, 45, 6));
            numbers.sort(Comparator.naturalOrder());
            lotteries.add(new Lotto(numbers));
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

    public Prizes getPrizes(List<Integer> winningNumbers, Integer bonusNumber) {
        Prizes prizes = new Prizes();

        for (Lotto lotto : lotteries) {
            Integer winningCount = lotto.countWinningNumbers(winningNumbers);
            boolean isBonusNumberMatch = lotto.isBonusNumberMatch(bonusNumber);
            Prize prize = Prize.calculatePrize(winningCount, isBonusNumberMatch);
            prizes.addPrize(prize);
        }

        return prizes;
    }
}

