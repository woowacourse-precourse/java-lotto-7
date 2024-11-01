package lotto.system.view;

public class InputView {

    public String  showInputMoneyMessage() {
        System.out.println("구입금액을 입력해 주세요.");
        return SystemIO.readUserInput();
    }

    public String showInputLottoNumberMessage() {
        System.out.println("");
        System.out.println("당첨 번호를 입력해 주세요.");
        return SystemIO.readUserInput();
    }

    public String showInputBonusNumberMessage() {
        System.out.println("");
        System.out.println("보너스 번호를 입력해 주세요.");
        return SystemIO.readUserInput();
    }
}
