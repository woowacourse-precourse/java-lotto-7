package lotto.view;

public class OutputView {
    private static final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private static final String LOTTO_COUNT = "개를 구매했습니다.";
    private static final String INPUT_WINNING_NUMBERS = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";

    public void printRequestMoney(){
        System.out.println(INPUT_MONEY);
    }

    public void printLottoCount(int lottoCount){
        System.out.println(lottoCount + LOTTO_COUNT);
    }

    public void printRequestWinningNumbers(){
        System.out.println(INPUT_WINNING_NUMBERS);
    }

    public void printRequestBonusNumbers(){
        System.out.println(INPUT_BONUS_NUMBER);
    }
}
