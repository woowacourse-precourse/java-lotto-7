package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    private final static String LOTTO_INPUT_PRICE_MESSAGE = "구입금액을 입력해 주세요.";
    private final static String LOTTO_NUMBER_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private final static String LOTTO_BONUS_NUMBER_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";
    private final static String LOTTO_PURCHASE_TOTAL_COUNT = "개를 구매했습니다.";

    private void printMessage(String message) {
        System.out.println(message);
    }

    public void printGetPrice(){
        printMessage(LOTTO_INPUT_PRICE_MESSAGE);
    }

    public void printLottoNumber(){
        printMessage(LOTTO_NUMBER_INPUT_MESSAGE);
    }

    public void printLottoBonusNumber(){
        printMessage(LOTTO_BONUS_NUMBER_INPUT_MESSAGE);
    }

    public void printPurchasedLottoCount(Integer count) {
        printMessage(count + LOTTO_PURCHASE_TOTAL_COUNT);
    }

    public void printLottoPurchaseList(List<Lotto> purchasedLotto) {
        for (Lotto lotto : purchasedLotto) {
            printMessage(lotto.toString());
        }
    }
}
