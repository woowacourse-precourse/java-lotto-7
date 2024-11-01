package lotto;


import camp.nextstep.edu.missionutils.Console;

public class LottoGame {

    public int getPurchaseAmount(){
        System.out.println("구매 금액을 입력해 주세요.");
        String input = Console.readLine();
        validateNumericNumber(input);
        Integer purchaseNumber = Integer.valueOf(input);
        validateThousandUnit(purchaseNumber);
        return purchaseNumber;
    }

    public void validateNumericNumber(String input){
        for (int i = 0; i < input.length(); i++) {
            if(!Character.isDigit(input.charAt(i))){
                throw new IllegalArgumentException("[ERROR] 숫자 이외의 값은 입력할 수 없습니다.");
            }
        }
    }

    public void validateThousandUnit(int purchaseNumber){
        if(purchaseNumber % 1000 != 0){
            throw new IllegalArgumentException("[ERROR] 구매 금액은 1000원 단위여야 합니다.");
        }
    }
}
