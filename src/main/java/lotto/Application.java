package lotto;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

import static lotto.LottoData.*;


public class Application {
    public static void main(String[] args) {

        Input input = new Input();
        LottoMachine lottoMachine = new LottoMachine();

        int money = input.useMoney();
        Lotto winPrice = input.checkNumber();
        int bonus = input.bonus();

        MyLotto myLotto = new MyLotto(winPrice, bonus);

        lottoMachine.action(money / 1000, myLotto);

    }

    // b z
}
