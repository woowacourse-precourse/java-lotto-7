package lotto;

import console.Input;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Input input = new Input();
        long lottoCount = input.returnLottoCount();

        LottoBuyer lottoBuyer = new LottoBuyer(lottoCount);
        input.makeEmptyLine(null);

        lottoBuyer.setWinningLottoAndBonusNumber(input.receiveWiningNumber(), input.receiveBonusNumber());
        lottoBuyer.printTotalPrize();
    }
}
