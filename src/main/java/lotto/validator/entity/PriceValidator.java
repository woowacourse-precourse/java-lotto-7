package lotto.validator.entity;

import lotto.validator.Validator;

// 구입 금액 검증 클래스
public class PriceValidator implements Validator {
    private final String price;

    public PriceValidator(String price){
        this.price = price;
    }

    @Override
    public void validate() {
        isValidFormat();
        isValidPrice();
    }

    private void isValidFormat() {
        if (!price.matches("[0-9]+")) {
            throw new IllegalArgumentException("[ERROR] 금액은 0 이상의 숫자 하나만 입력 할 수 있습니다.");
        }
    }

    private void isValidPrice(){
        int inputPrice = isValueInRange();
        isMultipleOfAThousand(inputPrice);
    }

    private int isValueInRange() {
        try{
            return Integer.parseInt(price);
        }catch (Exception e){
            throw new IllegalArgumentException(String.format("[ERROR] 금액은 %d 범위를 벗어날 수 없습니다.", Integer.MAX_VALUE));
        }
    }

    private void isMultipleOfAThousand(int inputValue){
        if(inputValue == 0 || inputValue % 1000 > 0){
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력해주세요.");
        }
    }
}