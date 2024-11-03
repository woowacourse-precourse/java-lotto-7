package lotto.view;

public class LottoOutputView {
    public void printCashNotification(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void printErrorMessage(String reason){
        System.out.println("[ERROR]"+reason);
    }
    public void printLottoBundleAmount(int amount){
        System.out.println(amount+"개를 구매했습니다.");
    }
}
