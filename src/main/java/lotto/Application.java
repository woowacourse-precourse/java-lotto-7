package lotto;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        OutputSystem.printMessageForPurchaseAmount();
        int lottoPurchaseAmount = InputSystem.inputLottoPurchaseAmount();

        OutputSystem.printMessageForLottoCountAndNumbers(lottoPurchaseAmount);

        OutputSystem.printMessageForLottoNumber();
        String[] lottoNumber = InputSystem.inputLottoNumber();

        OutputSystem.printMessageForBonusNumber();
        int bonusNumber =  InputSystem.inputBonusNumber();


    }
}
