package lotto;

import lotto.io.*;

public class LottoMachine {
    public void start() {
        inputMoney();
        inputNum();
        inputBonus();
    }

    public void inputMoney() {
        Output.money();
    }

    public void inputNum() {
        Output.number();
    }

    public void inputBonus() {
        Output.bonus();
    }
}
