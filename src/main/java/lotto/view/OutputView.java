package lotto.view;

import static lotto.view.OutputMessage.*;

import java.util.Collections;
import java.util.List;

import lotto.constant.RankPrice;
import lotto.domain.Lotto;
import lotto.domain.Wallet;

public class OutputView {

    public static void inputMoney() {
        print(INPUT_MONEY.getMessage());
    }

    public static void buyLottoTickets(List<Lotto> lottos) {
        print(BUY_LOTTO_TICKETS.getMessage(lottos.size()));
        lottos.forEach(lotto -> print(LOTTO_NUMBERS.getMessage(lotto.getNumbers())));
    }

    public static void inputWinningNumbers() {
        print(INPUT_WINNING_NUMBERS.getMessage());
    }

    public static void bonusNumber() {
        print(INPUT_BONUS_NUMBER.getMessage());
    }

    public static void result(Wallet wallet) {
        print(INIT_RESULT.getMessage());
        RankPrice.values(Collections.reverseOrder()).stream()
            .filter(rankPrice -> !rankPrice.equals(RankPrice.NONE))
            .forEach(rankPrice ->
                print(RANK_RESULT.getMessage(
                    rankPrice,
                    wallet.getRankCount(rankPrice.getRank())
                )));
        print(RETURN_RESULT.getMessage(wallet.gain() * 100));
    }

    public static void exception(String message) {
        print(EXCEPTION.getMessage(message));
    }

    private static void print(String content) {
        System.out.print(content);
    }
}
