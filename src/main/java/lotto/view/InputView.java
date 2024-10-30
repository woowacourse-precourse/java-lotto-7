package lotto.view;

public class InputView {
    public void inputPurchaseAmount(){
        System.out.println("구입금액을 입력해 주세요.");
        String purchaseAmount = camp.nextstep.edu.missionutils.Console.readLine();

    }
    public void inputPrimaryNumber(){
        System.out.println("당첨 번호를 입력해 주세요.");
        String primaryNumber = camp.nextstep.edu.missionutils.Console.readLine();
    }

    public void inputBonusNumber(){
        System.out.println("보너스 번호를 입력해 주세요.");
        String bonusNumber = camp.nextstep.edu.missionutils.Console.readLine();
    }

}
