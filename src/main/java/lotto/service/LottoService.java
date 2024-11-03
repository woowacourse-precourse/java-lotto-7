package lotto.service;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import lotto.constant.Prize;
import lotto.constant.Prompt;
import lotto.domain.BonusNumber;
import lotto.domain.Lotto;
import lotto.domain.Lottos;
import lotto.domain.Money;
import lotto.domain.Result;
import lotto.validator.BonusNumberValidator;
import lotto.validator.LottoValidator;
import lotto.view.InputView;

public class LottoService {
    public LottoService() {
    }

    public Money inputMoney() {
        Money money;
        while (true) {
            try {
                money = new Money(InputView.inputMoney());
                return money;
            } catch (NumberFormatException e){
                System.out.println(e.getMessage());
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public Lottos buyLottos(Money money) {
        int ticketCount = getTicketCount(money);

        return new Lottos(ticketCount);
    }

    public int getTicketCount(Money money) {
        return money.getValue() / 1000;
    }

    public Lotto getWinningNumbers() {
        List<Integer> lotto;

        while (true) {
            try {
                System.out.println(Prompt.INPUT_WINNING_NUMBERS.getMessage());
                String numbers = Console.readLine();

                LottoValidator.validateInput(numbers);
                lotto = LottoValidator.makeLottoNumberList(numbers);

                return new Lotto(lotto);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }



    public BonusNumber getBonusNumber(Lotto winningNumbers) {
        while (true) {
            try {
                System.out.println(Prompt.INPUT_BONUS_NUMBER.getMessage());
                BonusNumber bonusNumber = new BonusNumber(Console.readLine(), winningNumbers);

                return bonusNumber;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public Result getResult(Lottos lottos, Lotto winningNumber, BonusNumber bonusNumber) {
        Result result = new Result();

        for (Lotto lotto : lottos.getLottos()) {
            Prize prize = lotto.match(winningNumber, bonusNumber);
            result.addPrize(prize);
        }

        return result;
    }

    public double calculateEarningRate(long totalPrize, Money money) {
        return (double) totalPrize / money.getValue() * 100;
    }
}
