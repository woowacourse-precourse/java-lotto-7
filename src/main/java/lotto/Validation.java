package lotto;

public class Validation {
    private final int PRICE_PER_LOTTO = 1000;
    public void validateLottoPrice(String lottoPrice) {
        int totalPrice = validateNumberFormatException(lottoPrice);
        validateIsPositiveNumber(totalPrice);
        validateIsDividedByPricePerLotto(totalPrice);
    }
    private int validateNumberFormatException(String lottoPrice){
        try{
            return Integer.parseInt(lottoPrice);
        }
        catch(NumberFormatException e){
            throw new IllegalArgumentException("구입 금액을 숫자로 입력해 주세요.");
        }
    }

    private void validateIsPositiveNumber(int totalPrice){
        if(totalPrice< 0) {
            throw new IllegalArgumentException("구입 금액을 양수로 입력해 주세요.");
        }
    }

    private void validateIsDividedByPricePerLotto(int totalPrice){
        if(totalPrice % PRICE_PER_LOTTO != 0){
            throw new IllegalArgumentException("구입 금액은 " + PRICE_PER_LOTTO + "로 나누어 떨어져야 합니다.");
        }
    }
}
