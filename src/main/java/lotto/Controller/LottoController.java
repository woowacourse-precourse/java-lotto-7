package lotto.Controller;

import Common.Rank;
import lotto.Lotto;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;

public class LottoController {

    private final InputView input;
    private final OutputView output;

    private final List<Lotto> lotteryTickets;
    private Lotto inputLotto;
    private int bonusNumber;

    public LottoController(InputView input, OutputView output) {
        this.input = input;
        this.output = output;
        this.lotteryTickets = new ArrayList<>();
    }

    public void start() {
        int amount = input.requestPurchasePrice();
        issueLotto(amount);
        List<Integer> getNumbers = input.requestNumbers();
        int bonusNumber = input.requestBonusNumber();
        setInputNumbers(getNumbers, bonusNumber);

        output.printPurchasedLotto(lotteryTickets);
    }

    public void issueLotto(int amount) {
        for (int i=0; i<amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//            Collections.sort(numbers);
            lotteryTickets.add(new Lotto(numbers));
        }
    }

    public void setInputNumbers(List<Integer> numbers, int bonus) {
        this.inputLotto = new Lotto(numbers);
        this.bonusNumber = bonus;
    }

    public void checkLottoNumbers() {
        int matchedCount = 0;
        boolean bonusMatch = false;
        for (Lotto lotto : lotteryTickets) {
            matchedCount = countMatchedNumber(lotto.getNumbers());
            bonusMatch = lotto.getNumbers().contains(bonusNumber);
        }
        Rank rank = getRank(matchedCount, bonusMatch);
        rank.setPrizeCount();
        output.printWinningStat(rank, lotteryTickets.size());

    }

    private int countMatchedNumber(List<Integer> numbers) {
        int count = 0;
        for (int i : numbers) {
            if (inputLotto.getNumbers().contains(i)) count++;
        }
        return count;
    }

    private Rank getRank(int matchCount, boolean bonusMatch) {
        switch (matchCount) {
            case 6:
                return Rank.SIX_MATCHES;
            case 5:
                if (bonusMatch) return Rank.FIVE_MATCHES_WITH_BONUS;
                return Rank.FIVE_MATCHES;
            case 4:
                return Rank.FOUR_MATCHES;
            case 3:
                return Rank.THREE_MATCHES;
            default:
                return Rank.NONE;
        }
    }
}
