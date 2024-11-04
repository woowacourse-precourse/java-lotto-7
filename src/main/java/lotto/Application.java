package lotto;

import lotto.model.*;
import lotto.validator.IntegerValidator;
import lotto.view.InputView;
import lotto.view.OutputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        // 1. 로또 구입 금액 입력
        int number = IntegerValidator.numberValidator(InputView.inputMoney());
        Money money = new Money(number);

        // 2. 로또 번호 추첨
        int count = money.getCount();
        List<List<Integer>> lottos = Lotto.makeRandomNumbers(count);

        // 3. 구매 로또 번호 수량 및 번호 출력
        OutputView.printCount(count);
        OutputView.printLottos(lottos);

        // 4. 로또 당첨 번호 입력
        List<Integer> numbers = IntegerValidator.lottoValidator(InputView.inputNumbers());
        Lotto winningNumbers = new Lotto(numbers);

        // 5. 보너스 번호 입력
        int bonus = IntegerValidator.numberValidator(InputView.inputBonus());
        Bonus bonusNumber = new Bonus(bonus, winningNumbers.getNumbers());

        // 6. 로또가 당첨되었는지 확인
        for (List<Integer> lotto : lottos) {
            int matchCount = Result.matchLotto(lotto, winningNumbers.getNumbers());
            boolean matchBonus = Result.matchBonus(lotto, bonusNumber.getNumber());

            Rate info = Rate.getRank(matchCount, matchBonus);
            Result.addRankCount(info);
            Result.addEarnings(Rate.getPrize(info));
        }

        Result.calculateEarningsRate(money.getMoney());


    }
}
