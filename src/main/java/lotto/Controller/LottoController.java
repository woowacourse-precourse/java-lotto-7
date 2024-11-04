package lotto.Controller;

import lotto.Common.Rank;
import lotto.Domain.Lotto;
import lotto.View.InputView;
import lotto.View.OutputView;

import java.util.ArrayList;
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
        Lotto inputLotto = input.requestNumbers();
        bonusNumber = input.requestBonusNumber();
        setInputNumbers(inputLotto, bonusNumber);

        output.printPurchasedLotto(lotteryTickets);
    }

    public void issueLotto(int amount) {
        for (int i=0; i<amount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
//            Collections.sort(numbers);
            lotteryTickets.add(new Lotto(numbers));
        }
    }

    public void setInputNumbers(Lotto input, int bonus) {
        this.inputLotto = input;
        this.bonusNumber = bonus;
    }

    public void checkLottoNumbers() {
        int matchedCount = 0;
        boolean bonusMatch = false;
        for (Lotto lotto : lotteryTickets) {
            int matched = inputLotto.countMatchedNumber(lotto.getNumbers());
            if (matched > matchedCount) matchedCount = matched;
            boolean bonus = lotto.getNumbers().contains(bonusNumber);
            if (matched >=5 && bonus) bonusMatch = true;
        }
        Rank rank = getRank(matchedCount, bonusMatch);
        output.printWinningStat(rank, lotteryTickets.size());
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
