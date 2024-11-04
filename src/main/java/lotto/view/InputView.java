package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.message.RunMessage;
import lotto.model.Amount;
import lotto.model.Bonus;
import lotto.model.Lotto;

public class InputView {

    public static Amount inputAmount() {
        Amount amount = null;
        while (amount == null) {
            System.out.print(RunMessage.INPUT_AMOUNT_MESSAGE.getMessage());
            try {
                String input = Console.readLine();
                amount = new Amount(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }

        return amount;
    }

    public Lotto inputWinningLotto(){
        Lotto winningLotto = null;
        while(winningLotto == null){
            System.out.print(RunMessage.INPUT_WINNING_MESSAGE.getMessage());
            try {
                String input = Console.readLine();
                winningLotto =new Lotto(Lotto.parseWinningNumbers(input));
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        return winningLotto;
    }

    public Bonus inputBonusNumber(Lotto winningNumber){
        Bonus number = null;

        while (number == null){
            System.out.print(RunMessage.INPUT_BONUS_MESSAGE.getMessage());
            try {
                String input = Console.readLine();
                number = new Bonus(winningNumber.getNumbers(), Bonus.parseBonusNumber(input));
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }

        return number;
    }
}
