package lotto.validator;

import java.util.List;

public class LottoValidator {

    public static boolean unitValidator(int purchaseAmount){
        if(purchaseAmount % 1000 == 0){
            return true;
        }
        throw new IllegalArgumentException("[ERROR] 유효하지 않은 숫자 형식입니다.");
    }

    public static int stringToInt(String input){
        if(input == null || input.length() == 0){
            throw new IllegalArgumentException("[ERROR] 구매 할 로또 금액을 입력해주세요");
        }
        try {
            return Integer.parseInt(input);
        }catch (NumberFormatException e){
            throw new IllegalArgumentException("[ERROR] 입력한 금액 형식이 숫자 타입이 아닙니다.");
        }
    }

    public static boolean checkRangeLotto(int purchaseAmount){
        if(purchaseAmount < 1 || purchaseAmount > 45){
            throw new IllegalArgumentException("[ERROR] 유효하지 않은 숫자 범위입니다.");
        }
        return true;
    }

    public static boolean checkDuplicate(List<Integer> numberList, int checkNum){
        for (Integer num : numberList) {
            if(checkNum == num){
                throw new IllegalArgumentException("[ERROR] 당첨 번호와 보너스 번호가 겹칩니다.");
            }
        }
        return true;
    }


}
