package lotto;

import lotto.model.*;
import lotto.validator.IntegerValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        int number = IntegerValidator.numberValidator(InputView.inputMoney());
        Money money = new Money(number);

        int count = money.getCount();
        List<List<Integer>> lottos = Lotto.makeRandomNumbers(count);

        OutputView.printCount(count);
        OutputView.printLottos(lottos);

        List<Integer> numbers = IntegerValidator.lottoValidator(InputView.inputNumbers());
        Lotto winningNumbers = new Lotto(numbers);

        int bonus = IntegerValidator.numberValidator(InputView.inputBonus());
        Bonus bonusNumber = new Bonus(bonus, winningNumbers.getNumbers());

        for (List<Integer> lotto : lottos) {
            int matchCount = Result.matchLotto(lotto, winningNumbers.getNumbers());
            boolean matchBonus = Result.matchBonus(lotto, bonusNumber.getNumber());

            Rank info = Rank.getRank(matchCount, matchBonus);
            Result.addRankCount(info);
            Result.addEarnings(Rank.getPrize(info));
        }

        Result.calculateEarningsRate(money.getMoney());
    }
}
