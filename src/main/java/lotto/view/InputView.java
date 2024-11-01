package lotto.view;

public class InputView {

    public void printPurchase(){
        System.out.println("구입금액을 입력해 주세요.");
    }

    public void printPurchaseCount(int count){
        System.out.println(count + "개를 구매했습니다.");
    }

    public void printPlaceNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
    }

    public void printBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
    }
}
