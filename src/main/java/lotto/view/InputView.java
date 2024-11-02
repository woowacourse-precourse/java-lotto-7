package lotto.view;
import camp.nextstep.edu.missionutils.Console;
import lotto.model.CustomException;

public class InputView {
    private final String inputPurchaseAmountGuideMessage = "구입금액을 입력해 주세요.";
    private static final InputView instance = new InputView();
    private final CustomException customException;
    private InputView(){
        customException = CustomException.getInstance();
    }

    public static InputView getInstance(){
        return instance;
    }

    public int inputPurchaseAmount(){
        System.out.println(inputPurchaseAmountGuideMessage);
        String price = Console.readLine();
        customException.purchaseInputCheck(price);
        return Integer.parseInt(price);
    }

}
