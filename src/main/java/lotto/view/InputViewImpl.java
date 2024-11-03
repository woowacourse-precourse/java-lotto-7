package lotto.view;

import lotto.constants.string.InputMessage;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputViewImpl implements InputView {

    private static InputViewImpl inputView;

    private InputViewImpl() {
    }

    public static InputViewImpl getInstance() {
        if (inputView == null) {
            inputView = new InputViewImpl();
        }
        return inputView;
    }

    @Override
    public String getInputPrice() {
        System.out.println(InputMessage.PRICE.getInstance());
        return readLine();
    }

    @Override
    public String getWinningComponent() {
        System.out.println();
        System.out.println(InputMessage.WINNING_NUMBER.getInstance());
        return readLine();
    }

    @Override
    public String getBonusComponent() {
        System.out.println();
        System.out.println(InputMessage.BONUS_NUMBER.getInstance());
        return readLine();
    }

}
