package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoMachine machine = new LottoMachine();
        List<Lotto> lottos;

        machine.enterPay();

        lottos = machine.buyLotto();

        for (Lotto lotto : lottos) {
            lotto.printLottoNumber();
        }

        machine.setWinningNum();

        machine.setBonusNum();

        machine.checkResult(lottos);

        machine.printBenefitRate();

    }
}
