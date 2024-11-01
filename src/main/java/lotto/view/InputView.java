package lotto.view;


import lotto.constants.string.InputMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    private static InputView inputView;

    private InputView() {
    }

    public static InputView getInstance() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }

    public String getInputPrice() {
        System.out.println(InputMessage.PRICE.getInstance());
        return readLine();
    }

    public String getWinningComponent() {
        System.out.println();
        System.out.println(InputMessage.WINNING_NUMBER.getInstance());
        return readLine();
    }


    public String getBonusComponent() {
        System.out.println();
        System.out.println(InputMessage.BONUS_NUMBER.getInstance());
        return readLine();
    }

}
