package lotto.view;

import static lotto.constant.view.OutputViewConstant.INPUT_LOTTO_BONUS_NUMBER_PREFIX;
import static lotto.constant.view.OutputViewConstant.INPUT_LOTTO_NUMBERS_PREFIX;
import static lotto.constant.view.OutputViewConstant.INPUT_LOTTO_PRICE_PREFIX;
import static lotto.constant.view.OutputViewConstant.LOTTO_TICKETS_COUNT_FORMAT;

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
}
