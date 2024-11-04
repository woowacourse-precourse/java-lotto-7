package lotto.view;

import static lotto.view.OutputMessage.*;

import java.util.Collections;

import lotto.constant.Rank;
import lotto.dto.response.LottosResponse;
import lotto.dto.response.ResultResponse;

public class OutputView {

    private StringBuilder buffer;

    public OutputView() {
        setupBuffer();
    }

    public void inputMoney() {
        write(INPUT_MONEY.getMessage());
        flush();
    }

    public void buyLottoTickets(LottosResponse response) {
        write(BUY_LOTTO_TICKETS.getMessage(response.lottos().size()));
        response.lottos().forEach(lotto ->
            write(LOTTO_NUMBERS.getMessage(lotto.numbers())));
        flush();
    }

    public void inputWinningNumbers() {
        write(INPUT_WINNING_NUMBERS.getMessage());
        flush();
    }

    public void bonusNumber() {
        write(INPUT_BONUS_NUMBER.getMessage());
        flush();
    }

    public void result(ResultResponse response) {
        write(INIT_RESULT.getMessage());

        Rank.values(Collections.reverseOrder()).stream()
            .filter(rankPrice -> !rankPrice.equals(Rank.NONE))
            .forEach(rank -> write(RANK_RESULT.getMessage(rank,
                response.getRankCount(rank.getRank()))));

        write(RETURN_RESULT.getMessage(response.gain() * 100));

        flush();
    }

    public void exception(String message) {
        write(EXCEPTION.getMessage(message));
        flush();
    }

    private void write(String content) {
        buffer.append(content);
    }

    private void flush() {
        System.out.print(buffer);
        setupBuffer();
    }

    private void setupBuffer() {
        buffer = new StringBuilder();
    }
}
