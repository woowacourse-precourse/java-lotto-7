package lotto.week3.global.error.handler;

import java.util.List;
import lotto.week3.dto.PurchaseRequestDto;
import lotto.week3.dto.WinningNumberRequestDto;
import lotto.week3.view.InputView;

public class InputHandler {

    public static PurchaseRequestDto purchaseRequestDto(){
        while (true){
            try {
                int money = InputView.purchaseAmountInput();
                return new PurchaseRequestDto(money);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    public static WinningNumberRequestDto winningNumberRequestDto(){
        while (true){
            try {
                List<Integer> winningNumberInput = InputView.winningNumberInput();
                int bonusNumberInput = InputView.bonusNumberInput();
                return new WinningNumberRequestDto(winningNumberInput, bonusNumberInput);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

}
