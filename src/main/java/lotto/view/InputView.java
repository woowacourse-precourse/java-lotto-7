package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import lotto.model.CustomException;

import java.util.List;

public class InputView {
    private final String INPUT_PURCHASE_AMOUNT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private static final InputView instance = new InputView();
    private final CustomException customException;
    private InputView(){
        customException = CustomException.getInstance();
    }

    public static InputView getInstance(){
        return instance;
    }

    public int inputPurchaseAmount(){
        System.out.println(INPUT_PURCHASE_AMOUNT_GUIDE_MESSAGE);
        String price = Console.readLine();
        customException.purchaseAmountInputCheck(price);
        return Integer.parseInt(price);
    }
}
