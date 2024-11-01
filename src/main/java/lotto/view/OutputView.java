package lotto.view;

import lotto.model.Lotto;

import java.util.List;

public class OutputView {
    private static final String REQUEST_LOTTO_PRICE = "구입금액을 입력해 주세요.";
    private static final String INFORM_LOTTO_COUNT = "%d개를 구매했습니다.";
    private static final String REQUEST_WINNING_LOTTO = "당첨 번호를 입력해 주세요.";
    private static final String REQUEST_BONUS_LOTTO = "보너스 번호를 입력해 주세요.";
    private static final String NEW_LINE = System.lineSeparator();

    public void requestLottoPrice() {
        System.out.println(REQUEST_LOTTO_PRICE);
    }

    public void displayLottoPurchaseResult(List<Lotto> lottoSets) {
        System.out.print(NEW_LINE);
        System.out.printf(INFORM_LOTTO_COUNT + NEW_LINE, lottoSets.size());
        for (Lotto lotto : lottoSets) {
            System.out.println(lotto.getLotto());
        }
        System.out.print(NEW_LINE);
    }

    public void requestWinningLottoNumbers(){
        System.out.println(REQUEST_WINNING_LOTTO);
    }

    public void requestBonusLottoNumbers(){
        System.out.print(NEW_LINE);
        System.out.println(REQUEST_BONUS_LOTTO);
    }
}
