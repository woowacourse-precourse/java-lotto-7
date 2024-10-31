package lotto.view;

import static lotto.global.Message.BUY_LOTTO_COUNT_MESSAGE;

import java.util.List;
import lotto.domain.Lotto;

public class OutputView {

    public void printTotalLottoCounts(int lottoCounts) {
        System.out.println("\n" + lottoCounts + BUY_LOTTO_COUNT_MESSAGE.getMsg());
    }

    public void printLottoRandomNumber(List<Lotto> randomLotto) {
        randomLotto.stream().map(Lotto::getNumbers).forEach(System.out::println);
    }
}
