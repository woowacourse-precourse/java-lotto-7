package lotto.view;

import java.util.List;
import lotto.dto.LottoNumberDto;

public class OutputView {
    private static final String INPUT_PURCHASE_AMOUNT = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_NUMBER_MESSAGE = "\n%d개를 구매했습니다.";

    private OutputView() {
    }

    public static void printPurchaseAmountInputMessage() {
        System.out.println(INPUT_PURCHASE_AMOUNT);
    }

    public static void printPurchaseLottoNumbers(List<LottoNumberDto> purchasedLottoNumberSets) {
        System.out.printf(PURCHASE_NUMBER_MESSAGE + "%n", purchasedLottoNumberSets.size());

        purchasedLottoNumberSets.forEach(lottoNumberDto ->
                System.out.println(lottoNumberDto.numbers())
        );

    }
}
