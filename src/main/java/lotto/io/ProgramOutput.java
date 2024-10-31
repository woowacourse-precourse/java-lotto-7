package lotto.io;

import lotto.Lotto;

import java.util.List;

public class ProgramOutput {
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COMPLETION_MESSAGE = "개를 구매했습니다.";

    public void requestPurchaseAmount(){
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurChasedLotto(List<Lotto> purChasedLotto) {
        printNewLine();
        System.out.println(purChasedLotto.size()+PURCHASE_COMPLETION_MESSAGE);
        printLottoInformation(purChasedLotto);
        printNewLine();
    }

    private void printLottoInformation(List<Lotto> purchasedLotto) {
        purchasedLotto.stream()
                .map(lotto -> lotto.getNumbers().toString())
                .forEach(System.out::println);
    }

    private void printNewLine() {
        System.out.println();
    }
}
