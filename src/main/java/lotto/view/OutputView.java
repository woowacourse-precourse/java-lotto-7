package lotto.view;

import lotto.domain.Lotto;

import java.util.List;

public class OutputView {
    private static final String GET_MONEY_TO_BUY_LOTTO = "구입금액을 입력해 주세요.";
    private static final String SHOW_PUBLICED_LOTTO_NUM = "%d개를 구매했습니다.\n";
    private static final String GET_LOTTO_WINNING_NUM = "당첨 번호를 입력해 주세요.";
    private static final String GET_LOTTO_BONUS_NUM = "보너스 번호를 입력해 주세요.";
    public void showHowMuchMoneyToBuyLotto() {
        System.out.println(GET_MONEY_TO_BUY_LOTTO);
    }

    public void showPublicedLottos(List<Lotto> lottos){
        System.out.printf(SHOW_PUBLICED_LOTTO_NUM, lottos.size());
        for(Lotto lotto : lottos){
            System.out.println(lotto.getNumbers());
        }
    }

    public void enterWinningNumberForLotto(){
        System.out.println(GET_LOTTO_WINNING_NUM);
    }

    public void enterBonusNumberForLotto(){
        System.out.println(GET_LOTTO_BONUS_NUM);
    }
}
