package lotto.view;

import java.util.List;

public class InputHandler {
    private final String INPUT_MONEY = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNUMBER = "당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUSNUMBER = "보너스 번호를 입력해 주세요.";
    private InputReader inputReader = new InputReader();
    private Printer printer = new Printer();

    public int makeMoney(){
        printer.printMessage(INPUT_MONEY);
        return inputReader.readInteger();
    }

    public List<Integer> makeWinNumber(){
        printer.printMessage(INPUT_WINNUMBER);
        return inputReader.readIntegerList();
    }

    public int makeBonusNumber(){
        printer.printMessage(INPUT_BONUSNUMBER);
        return inputReader.readInteger();
    }
}
