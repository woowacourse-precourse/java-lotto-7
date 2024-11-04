package lotto.week3.global.error.handler;

import java.util.List;
import lotto.week3.dto.PurchaseRequestDto;
import lotto.week3.dto.WinningNumberRequestDto;
import lotto.week3.global.error.validate.PurchaseAmountValidator;
import lotto.week3.view.InputView;

public class InputHandler {

    public static PurchaseRequestDto purchaseInputHandler() {
        while (true) {
            try {
                String input = InputView.purchaseAmountInput();  // 금액을 String으로 입력받음
                int validatedAmount = PurchaseAmountValidator.validate(input);  // 검증 후 정수로 변환된 금액
                return new PurchaseRequestDto(validatedAmount);  // DTO 생성
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());  // 오류 메시지 출력 후 재입력 유도
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
