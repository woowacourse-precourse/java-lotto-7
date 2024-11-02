package lotto;

public class TotalLottoPriceInputHandler extends InputHandler{
    private String totalLottoPrice;

    @Override
    public void validateInput() {

    }

    public boolean isValidPrice() {
        return Integer.parseInt(totalLottoPrice) % 1000 == 0;
    }

}
