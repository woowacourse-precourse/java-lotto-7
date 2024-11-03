package lotto.view;

import static lotto.constant.view.OutputViewConstant.INPUT_LOTTO_BONUS_NUMBER_PREFIX;
import static lotto.constant.view.OutputViewConstant.INPUT_LOTTO_NUMBERS_PREFIX;
import static lotto.constant.view.OutputViewConstant.INPUT_LOTTO_PRICE_PREFIX;
import static lotto.constant.view.OutputViewConstant.LOTTO_TICKETS_COUNT_FORMAT;

import java.util.Comparator;
import lotto.domain.LottoPrice;
import lotto.domain.LottoPrize;
import lotto.dto.LottoPrizesRecord;
import lotto.domain.LottoTickets;

public class OutputView {

    public static void printLottoPriceInputPrefix() {
        System.out.println(INPUT_LOTTO_PRICE_PREFIX);
    }

    public static void printLottoTickets(LottoTickets lottoTickets) {
        System.out.println(LOTTO_TICKETS_COUNT_FORMAT.formatMessage(lottoTickets.getLottoCount()));
        System.out.println(lottoTickets);
    }

    public static void printLottoNumbersInputPrefix() {
        System.out.println(INPUT_LOTTO_NUMBERS_PREFIX);
    }

    public static void printLottoBonusNumberInputPrefix() {
        System.out.println(INPUT_LOTTO_BONUS_NUMBER_PREFIX);
    }

    public static void printLottoPrizes(LottoPrizesRecord prizes, LottoPrice lottoPurchaseAmount) {
        prizes.lottoPrizesMap().entrySet().stream()
                .filter(entry -> entry.getKey() != LottoPrize.NO_PRIZE)
                .sorted(Comparator.comparingLong(value -> value.getKey().getPrizeMoney()))
                .forEach(entry -> System.out.println(entry.getKey() + " - " + entry.getValue() + "개"));
        System.out.println("총 수익률은 " + prizes.getRateOfReturn(lottoPurchaseAmount) + "%입니다.");
    }
}
