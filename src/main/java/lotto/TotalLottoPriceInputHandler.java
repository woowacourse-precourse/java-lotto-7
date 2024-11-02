package lotto;

public class TotalLottoPriceInputHandler extends InputHandler{
    private final String totalLottoPrice;

    public TotalLottoPriceInputHandler(String price) {
        this.totalLottoPrice = price;
    }

    @Override
    public void validateInput() {

    }

    public boolean isValidPrice() {
        return Integer.parseInt(totalLottoPrice) % 1000 == 0;
    }

    private void throwExceptionWhenInputIsInvalid() {
        if(!Validation.isNumeric(totalLottoPrice) || !Validation.isEmptyInput(totalLottoPrice)) {
            throwIllegalArgumentException("입력이 유효하지 않습니다.");
        }
    }

}
