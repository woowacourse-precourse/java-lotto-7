package view;

public class OutputHandler {

    public void promptForAmountInput(){
        System.out.println("구입금액을 입력해 주세요.");
    }
    public void promptForLottoNumber(){
        System.out.println("\n" +"당첨 번호를 입력해 주세요.");
    }
    public void promptForBonusNumber(){
        System.out.println("\n" +"보너스 번호를 입력해 주세요.");
    }
    public void displayPurchasedLottoCount(int count){
        System.out.println("\n" + count + "개를 구매했습니다.");
    }
}
