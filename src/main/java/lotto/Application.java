package lotto;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        LottoMachine machine = new LottoMachine();
        List<Lotto> lottos;
        System.out.println("구입금액을 입력해 주세요.");
        int pay = Integer.parseInt(Console.readLine());
        int prize;

        lottos = machine.buyLotto(pay);

        for (Lotto lotto : lottos) {
            lotto.printLottoNumber();
        }

        machine.setWinningNum();

        prize = machine.checkResult(lottos);

        machine.printBenefitRate(pay, prize);

    }
}
