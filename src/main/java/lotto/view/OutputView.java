package lotto.view;

import static lotto.message.MessageConstants.OUTPUT_PURCHASE_COUNT_MESSAGE;

import java.util.List;

public class OutputView {

    public void printLottoPurchaseCountMessage(int lottoCount) {
        System.out.printf(OUTPUT_PURCHASE_COUNT_MESSAGE, lottoCount);
    }

    public void printLottoNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

}
