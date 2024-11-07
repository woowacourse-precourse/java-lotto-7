package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoMachine machine = new LottoMachine();
        Customer kim = new Customer();
        LottoReader reader = new LottoReader();

        machine.enterPay(kim);
        machine.buyLotto(kim);
        reader.setWinningNum();

        reader.setBonusNum();

        reader.checkResult(kim);
        reader.printBenefitRate(kim);

    }
}
