package lotto.view;

import lotto.domain.Lotto;
import lotto.domain.Lottos;

public class OutputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private static final String WINNING_STATISTICS_HEADER = "당첨 통계\n---";
    private static final String THREE_MATCHING = "3개 일치 (5,000원) - ";
    private static final String FOUR_MATCHING = "4개 일치 (50,000원) - ";
    private static final String FIVE_MATCHING = "5개 일치 (1,500,000원) - ";
    private static final String FIVE_MATCHING_AND_BONUS = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    private static final String SIX_MATCHING = "6개 일치 (2,000,000,000원) - ";
    private static final String PIECES = "개";


    public void printRequestMoney(){
        System.out.println(INPUT_MONEY);
    }

    public void printLottoCount(int lottoCount){
        System.out.println(lottoCount + LOTTO_COUNT);
    }

    public void printLottos(Lottos lottos) {
        for (Lotto lotto : lottos.getLottos()) {
            System.out.println(lotto.getNumbers());
        }
    }

    public void printRequestWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS);
    }

    public void printRequestBonusNumbers(){
        System.out.println(INPUT_BONUS_NUMBER);
    }
}
