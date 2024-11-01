package lotto.view;

public class OutputView {

    public static void requestLotteryPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public static void requestLotteryWinningNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public static void requestLotteryBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }

    public void printErrorMessage(String errorMessage){
        System.err.println(errorMessage);
    }
}
