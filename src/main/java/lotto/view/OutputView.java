package lotto.view;

import static lotto.view.OutputMessage.*;

import java.util.Collections;

import lotto.constant.Rank;
import lotto.dto.response.LottosResponse;
import lotto.dto.response.ResultResponse;

public class OutputView {

    public static void inputMoney() {
        print(INPUT_MONEY.getMessage());
    }

    public static void buyLottoTickets(LottosResponse response) {
        print(BUY_LOTTO_TICKETS.getMessage(response.lottos().size()));
        response.lottos().forEach(lotto ->
            print(LOTTO_NUMBERS.getMessage(lotto.numbers())));
    }

    public static void inputWinningNumbers() {
        print(INPUT_WINNING_NUMBERS.getMessage());
    }

    public static void bonusNumber() {
        print(INPUT_BONUS_NUMBER.getMessage());
    }

    public static void result(ResultResponse response) {
        print(INIT_RESULT.getMessage());

        Rank.values(Collections.reverseOrder()).stream()
            .filter(rankPrice -> !rankPrice.equals(Rank.NONE))
            .forEach(rank -> print(RANK_RESULT.getMessage(rank,
                response.getRankCount(rank.getRank()))));

        print(RETURN_RESULT.getMessage(response.gain() * 100));
    }

    public static void exception(String message) {
        print(EXCEPTION.getMessage(message));
    }

    private static void print(String content) {
        System.out.print(content);
    }
}
