package lotto;

import java.util.ArrayList;
import java.util.List;

public class BonusNumberInputHandler extends InputHandler{
    private String bonusNumber;

    public BonusNumberInputHandler(List<Integer> winningNumber) {
        boolean isValid = false;

        while(!isValid){
            System.out.println("\n보너스 번호를 입력해 주세요.");
            this.bonusNumber = camp.nextstep.edu.missionutils.Console.readLine();
            try{
                validateInput(winningNumber);
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public int getBonusNumber() {
        return Integer.parseInt(bonusNumber);
    }

    @Override
    public void validateInput() {}

    public void validateInput(List<Integer> numbers) {
        throwExceptionWhenInputIsInvalid();
        throwExceptionWhenInputIsNotInRange1To45();
        throwExceptionNumberIsNotUnique(numbers);
    }

    private void throwExceptionWhenInputIsInvalid() {
        if(!Validation.isNumeric(bonusNumber) || Validation.isEmptyInput(bonusNumber)) {
            throwIllegalArgumentException("입력이 유효하지 않습니다.");
        }
    }

    private void throwExceptionNumberIsNotUnique(List<Integer> numbers) {
        if(numbers.contains(Integer.parseInt(bonusNumber))) {
            throwIllegalArgumentException("보너스 번호는 당첨 번호의 숫자들과 중복되서는 안됩니다.");
        }
    }

    private void throwExceptionWhenInputIsNotInRange1To45() {
        List<Integer> number = new ArrayList<>();
        number.add(Integer.parseInt(bonusNumber));
        if(!Validation.isInRange1To45(number)){
            throwIllegalArgumentException("당첨 번호의 숫자는 1부터 45까지의 범위안에서 입력해 주세요.");
        }
    }
}
