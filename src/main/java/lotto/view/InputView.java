package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.model.CustomException;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class InputView {
    private final String INPUT_PURCHASE_AMOUNT_GUIDE_MESSAGE = "구입금액을 입력해 주세요.";
    private final String INPUT_WINNING_NUMBER_GUIDE_MESSAGE = "\n당첨 번호를 입력해 주세요.";
    private final String INPUT_BONUS_NUMBER_GUIDE_MESSAGE = "\n보너스 번호를 입력해 주세요.";
    private static final InputView instance = new InputView();
    private final CustomException customException;

    private InputView() {
        customException = CustomException.getInstance();
    }

    public static InputView getInstance() {
        return instance;
    }

    public int inputPurchaseAmount() {
        System.out.println(INPUT_PURCHASE_AMOUNT_GUIDE_MESSAGE);
        try {
            String price = Console.readLine();
            customException.purchaseAmountInputCheck(price);
            return Integer.parseInt(price);
        }catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    public List<Integer> inputWinningNumbers() {
        System.out.println(INPUT_WINNING_NUMBER_GUIDE_MESSAGE);
        String winningNumber = Console.readLine();
        customException.winningNumberInputCheck(winningNumber);

        return Arrays.stream(winningNumber.split(","))
                .map(String::trim)
                .map(Integer::parseInt) // Integer로 변환
                .collect(Collectors.toList());
    }

    public int inputBonusNumber() {
        System.out.println(INPUT_BONUS_NUMBER_GUIDE_MESSAGE);
        String bonusNumber = Console.readLine();
        customException.bonusNumberInputCheck(bonusNumber);
        return Integer.parseInt(bonusNumber);
    }
}
