package lotto;

import java.util.*;
import java.util.stream.StreamSupport;

import lotto.io.*;
import lotto.validation.*;

public class LottoMachine {
    public int money;
    public int bonus;

    public void start() {
        inputMoney();
        inputNum();
        inputBonus();
    }

    public void inputMoney() {
        int m;
        while(true) {
            Output.money();
            try {
                money = Input.money();
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    public void inputNum() {
        while(true) {
            Output.number();
            try {
                Input.number();
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }

    public void inputBonus() {
        while(true) {
            Output.bonus();
            try {
                bonus = Input.bonus();
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }
}
