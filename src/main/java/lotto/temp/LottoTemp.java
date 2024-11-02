package lotto.temp;

import lotto.util.CommonIo;

public class LottoTemp {
    private final CommonIo io;

    public LottoTemp(CommonIo io) {
        this.io = io;
    }

    public void printRequestPurchase(){
        io.printMessage("구입금액을 입력해 주세요.");
    }

    public String inputPurchaseAmount(){
        return io.receiveInput();
    }

    public int convertInputToInt(String input) {
        return io.convertStringToInt(input);
    }

    public int convertMoneyToTicket(int amount){
        return amount / 1000;
    }

}
