package lotto.view;

import lotto.Lotto;

import java.util.List;

public class OutputView {

    private static final String SIX_MATCH = "6개 일치 (2,000,000,000원) - %d개";
    private static final String FIVE_BONUS_MATCH = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개";
    private static final String FIVE_MATCH = "5개 일치 (1,500,000원) - %d개";
    private static final String FOUR_MATCH = "4개 일치 (50,000원) - %d개";
    private static final String THREE_MATCH = "3개 일치 (5,000원) - %d개";
    private static final String LOTTO_RATE_MESSAGE = "총 수익률은 %2f%%입니다.";

    public void printPurchaseGuide() {
        System.out.println("로또를 구입할 금액을 입력하세요.");
    }

    public void printWinningNumbersGuide() {
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumberGuide() {
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printLottoCount(int lottoCount) {
        System.out.println(lottoCount + "개를 구매했습니다.");
    }

    public void printLottos(List<Lotto> lottos) {
        for (Lotto lotto : lottos) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printLottoResult(List<Integer> result) {
        System.out.println(String.format(SIX_MATCH, result.get(0)));
        System.out.println(String.format(FIVE_BONUS_MATCH, result.get(1)));
        System.out.println(String.format(FIVE_MATCH, result.get(2)));
        System.out.println(String.format(FOUR_MATCH, result.get(3)));
        System.out.println(String.format(THREE_MATCH, result.get(4)));
    }

    public void printLottoRate(double rate) {
        System.out.println(String.format(LOTTO_RATE_MESSAGE, rate));
    }
}
