package lotto.view.output;

import java.util.List;
import lotto.domain.Lotto;
import lotto.domain.LottoShop;

public class OutputView {
    public static void printPurchasePrice() {
        System.out.println(OutputMessage.INPUT_PURCHASE_PRICE.message);
    }

    public static void printPurchasedLottoery(LottoShop lottoShop) {
        List<Lotto> lotteries = lottoShop.getLottoTickets().getLotteries();

        lotteries.stream().map(Lotto::getNumbers)
                .forEach(System.out::println);
    }

    public static void printWinningNumbers() {
        System.out.println(OutputMessage.INPUT_WINNING_NUMBERS.message);
    }

    public static void printBonusNumber() {
        System.out.println(OutputMessage.INPUT_BONUS_NUMBER.message);
    }
}
