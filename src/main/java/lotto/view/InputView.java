package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.view.messages.InputMessages;

public class InputView {

    public String getLottoPriceByUser() {
        System.out.println(InputMessages.INPUT_LOTTO_PRICE);
        return Console.readLine().trim();
    }

    public String getWinningLottoNumbers() {
        System.out.println();
        System.out.println(InputMessages.INPUT_WINNING_NUMBERS);
        return Console.readLine().trim();
    }

    public String getWinningLottoBonusNumber() {
        System.out.println();
        System.out.println(InputMessages.INPUT_BONUS_NUMBER);
        return Console.readLine().trim();
    }


}
