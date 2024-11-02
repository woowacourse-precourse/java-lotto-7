package lotto.view;

public class OutputView {
//    View는 Model 의존 가능, C의존 불가
    public static void promptInputPurchaseMoney(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void promptInputWinningNumbers(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void promptInputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public static void printResultText(){
        System.out.println("당첨 통계");
        System.out.println("---");
    }

    public void printBuyLottoAmount(int lottoAmount){
        System.out.println(lottoAmount + "개를 구매했습니다.");
    }

    public void printProfitRate(double profitRate){
        System.out.println("총 수익률은 " + profitRate + "%입니다.");
    }
}
