package lotto.io;

import lotto.Lotto;

import java.util.List;

public class ProgramOutput {
    private static final String REQUEST_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COMPLETION_MESSAGE = "개를 구매했습니다.";
    private static final String REQUEST_WINNING_NUMBERS_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_INFORMATION_MESSAGE = "당첨 통계";
    private static final String HORIZON = "---";

    public void requestPurchaseAmount(){
        System.out.println(REQUEST_PURCHASE_AMOUNT_MESSAGE);
    }

    public void printPurChasedLotto(List<Lotto> purChasedLotto) {
        printNewLine();
        System.out.println(purChasedLotto.size()+PURCHASE_COMPLETION_MESSAGE);
        printLottoInformation(purChasedLotto);
        printNewLine();
    }

    public void requestWinningNumbers() {
        System.out.println(REQUEST_WINNING_NUMBERS_MESSAGE);
    }

    public void requestBonusNumber() {
        System.out.println(REQUEST_BONUS_NUMBER_MESSAGE);
    }

    public void printWinningStatistics(){
        printNewLine();
        System.out.println(WINNING_STATISTICS_INFORMATION_MESSAGE);
        System.out.println(HORIZON);
        printStatistics();
    }

    private void printStatistics() {
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
