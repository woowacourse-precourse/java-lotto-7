package lotto.view;

import camp.nextstep.edu.missionutils.Console;
import lotto.dto.BonusNumberDto;
import lotto.dto.PurchaseAmountDto;
import lotto.dto.WinningLotteryDto;

public class InputView {

    private static final String INPUT_PURCHASE_AMOUNT_MESSAGE = "구입금액을 입력해 주세요.";
    private static final String INPUT_WINNING_LOTTERY_MESSAGE = "당첨 번호를 입력해 주세요.";
    private static final String INPUT_BONUS_NUMBER_MESSAGE = "보너스 번호를 입력해 주세요.";

    public static PurchaseAmountDto inputPurchaseAmount(){
        System.out.println(INPUT_PURCHASE_AMOUNT_MESSAGE);
        return PurchaseAmountDto.from(
                Console.readLine()
        );
    }

    public static WinningLotteryDto inputWinningLottery(){
        System.out.println(INPUT_WINNING_LOTTERY_MESSAGE);
        return WinningLotteryDto.from(
                Console.readLine()
        );
    }

    public static BonusNumberDto inputBonusNumber(){
        System.out.println(INPUT_BONUS_NUMBER_MESSAGE);
        return BonusNumberDto.from(
                Console.readLine()
        );
    }
}
