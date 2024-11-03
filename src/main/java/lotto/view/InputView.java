package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.enums.lotto.LottoMessage;
import lotto.service.LottoMachineService;

public class InputView {

    private final LottoMachineService lottoMachineService = new LottoMachineService();

    public void printInputLottoPurchaseAmount() {
        while (true) {
            try {
                System.out.println(LottoMessage.PRINT_INPUT_LOTTO_PURCHASE_AMOUNT.getMessage());
                lottoMachineService.inputLottoPurchaseAmount(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printInputBonusNumber() {
        while (true) {
            try {
                System.out.println(LottoMessage.PRINT_INPUT_BONUS_NUMBER.getMessage());
                lottoMachineService.inputBonusNumber(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void printInputWinningNumber() {
        while (true) {
            try {
                System.out.println(LottoMessage.PRINT_INPUT_WINNING_NUMBER.getMessage());
                lottoMachineService.inputWinningNumbers(Console.readLine());
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
