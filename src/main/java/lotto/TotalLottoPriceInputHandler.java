package lotto;

public class TotalLottoPriceInputHandler extends InputHandler{
    private String totalLottoPrice;

    public TotalLottoPriceInputHandler() {
        boolean isValid = false;

        while(!isValid){
            System.out.println("구입금액을 입력해 주세요.");
            this.totalLottoPrice = camp.nextstep.edu.missionutils.Console.readLine();
            try{
                validateInput();
                isValid = true;
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    public int getTotalLottoPrice() {
        return Integer.parseInt(totalLottoPrice);
    }

    @Override
    public void validateInput() {
        throwExceptionWhenInputIsInvalid();
        throwExceptionWhenInputIsInvalidNumber();
    }

    public boolean isValidPrice() {
        return Integer.parseInt(totalLottoPrice) % 1000 == 0;
    }

    private void throwExceptionWhenInputIsInvalid() {
        if(!Validation.isNumeric(totalLottoPrice) || Validation.isEmptyInput(totalLottoPrice)) {
            throwIllegalArgumentException("입력이 유효하지 않습니다.");
        }
    }

    private void throwExceptionWhenInputIsInvalidNumber() {
        if(!isValidPrice()) {
            throwIllegalArgumentException("구입금액은 1000원 단위로만 입력 가능합니다.");
        }
        if(totalLottoPrice.equals("0")) {
            throwIllegalArgumentException("구입금액은 1원 이상부터 입력 가능합니다.");
        }
    }

}
