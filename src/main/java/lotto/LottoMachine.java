package lotto;

import java.util.*;
import java.util.stream.StreamSupport;

import lotto.io.*;
import lotto.validation.*;

public class LottoMachine {
    public int money;

    public void start() {
        money = inputMoney();
        inputNum();
        inputBonus();
    }

    public int inputMoney() {
        int m;
        while(true) {
            Output.money();
            try {
                m = Input.money();
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
        return m;
    }

    public void inputNum() {
        Output.number();
    }

    public void inputBonus() {
        Output.bonus();
    }
}
