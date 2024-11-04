package lotto;

public class OutputView {
    final static String ASK_PURCHASE_PRICE = "구입금액을 입력해 주세요.";
    final static String ANSWER_PURCHASE_COUNT = "개를 구매했습니다.";
    final static String ASK_JACKPOT_NUMBER = "\n당첨 번호를 입력해 주세요.";
    final static String ASK_BOUNS_NUMBER = "보너스 번호를 입력해 주세요.";
    final  static String JACKPOT_ANALYSIS = "당첨 통계";
    final static String JACKPOT_ANALYSIS_BAR = "---";
    final static String JACKPOT_ANALYSIS_THREE_CORRECT = "3개 일치 (5,000원) - ";
    final static String JACKPOT_ANALYSIS_FOUR_CORRECT = "4개 일치 (50,000원) - ";
    final static String JACKPOT_ANALYSIS_FIVE_CORRECT = "5개 일치 (1,500,000원) - ";
    final static String JACKPOT_ANALYSIS_FIVE_BONUS_CORRECT = "5개 일치, 보너스 볼 일치 (30,000,000원) - ";
    final static String JACKPOT_ANALYSIS_SIX_CORRECT = "6개 일치 (2,000,000,000원) - ";
    final static String JACKPOT_ANALYSIS_CORRECT_END_SENTESE = "개";
    final static String JACKPOT_ANALYSIS_TOTALGAIN_START_SENTENSE = "총 수익률은 ";
    final static String JACKPOT_ANALYSIS_TOTALGAIN_END_SENTENSE = "%입니다.";


    public void askPurchase() {
        System.out.println(ASK_PURCHASE_PRICE);
    }
    public void answerPurchase(int number) {
        System.out.println("\n"+number + ANSWER_PURCHASE_COUNT);
    }
    public void askJackpotNumbers() {
        System.out.println(ASK_JACKPOT_NUMBER);
    }
    public void askBonusNumber() {
        System.out.println(ASK_BOUNS_NUMBER);
    }
    public void jackpotAnalysis(int a,int b , int c , int d, int e ,double g){
        System.out.println(JACKPOT_ANALYSIS);
        System.out.println(JACKPOT_ANALYSIS_BAR);
        System.out.println(JACKPOT_ANALYSIS_THREE_CORRECT +a+JACKPOT_ANALYSIS_CORRECT_END_SENTESE );
        System.out.println(JACKPOT_ANALYSIS_FOUR_CORRECT +b+JACKPOT_ANALYSIS_CORRECT_END_SENTESE );
        System.out.println(JACKPOT_ANALYSIS_FIVE_CORRECT +c+JACKPOT_ANALYSIS_CORRECT_END_SENTESE);
        System.out.println(JACKPOT_ANALYSIS_FIVE_BONUS_CORRECT +d+ JACKPOT_ANALYSIS_CORRECT_END_SENTESE);
        System.out.println(JACKPOT_ANALYSIS_SIX_CORRECT +e+JACKPOT_ANALYSIS_CORRECT_END_SENTESE);
        System.out.println(JACKPOT_ANALYSIS_TOTALGAIN_START_SENTENSE +g +JACKPOT_ANALYSIS_TOTALGAIN_END_SENTENSE);

    }
}
