package lotto.view;

import java.util.List;
import lotto.model.Lotto;

public class OutputView {

    public static final String PURCHASE_PRICE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    public static final String ISSUED_LOTTO_PRINTING_START_MESSAGE = "%d개를 구매했습니다.";
    public static final String ISSUED_LOTTO_PRINT_MESSAGE = "[%s]";

    public void printPurchasePriceInputMessage() {
        System.out.println(PURCHASE_PRICE_INPUT_MESSAGE);
    }

    public void printIssuedLottoCount(int count) {
        String startingMessage = String.format(ISSUED_LOTTO_PRINTING_START_MESSAGE, count);
        System.out.println(startingMessage);
    }

    public void printIssuedLotto(List<Lotto> issuedLotto) {
        for (Lotto lotto : issuedLotto) {
            String lottoContent = String.format(ISSUED_LOTTO_PRINT_MESSAGE, lotto.printLottoNumbers());
            System.out.println(lottoContent);
        }
    }
}
