package lotto.view;

import java.util.List;
import java.util.Map;
import lotto.domain.LottoTickets;

public class OutputView {
    private static final String PURCHASE_INPUT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String PURCHASE_COUNT_MESSAGE = "개를 구매했습니다.";
    private static final String WINNING_NUMBERS_INPUT_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String BONUS_NUMBERS_INPUT_MESSAGE = "보너스 번호를 입력해 주세요.";

    public void showPurchaseAmountInputMessage() {
        System.out.println(PURCHASE_INPUT_MESSAGE);
    }


    public void showLottoCountAndNumbers(LottoTickets lotteries) {
        showLottoCount(lotteries.getCount());
        showLottoNumbers(lotteries.getLottoNumbers());
    }

    private void showLottoCount(int count) {
        System.out.println(count + PURCHASE_COUNT_MESSAGE);
    }

    private void showLottoNumbers(List<String> lottoNumbers) {
        lottoNumbers.forEach(System.out::println);
    }

    public void showWinningNumbersInputMessage() {
        System.out.println(WINNING_NUMBERS_INPUT_MESSAGE);
    }

    public void showBonusNumberInputMessage() {
        System.out.println(BONUS_NUMBERS_INPUT_MESSAGE);
    }

    public void showResult(Map<Integer, Integer> rankMap) {
        System.out.println("3개 일치 (5,000)원 - " + rankMap.get(5) + "개");
        System.out.println("4개 일치 (50,000)원 - " + rankMap.get(4) + "개");
        System.out.println("5개 일치 (1,500,000)원 - " + rankMap.get(3) + "개");
        System.out.println("5개 일치, 보너스 볼 일치 (30,000,000)원 - " + rankMap.get(2) + "개");
        System.out.println("6개 일치 (2,000,000,000)원 - " + rankMap.get(1) + "개");
    }
}
