package lotto;

import java.util.*;

import lotto.io.*;

public class LottoMachine {
    public int money;
    public Lotto win;
    public int bonus;

    public void start() {
        inputMoney();
        inputNum();
        inputBonus();
    }

    public void inputMoney() {
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
                win = Input.number();
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
                bonus = Input.bonus(win);
                break;
            } catch(IllegalArgumentException e) {
                System.out.println(e.getMessage());
            } finally {
                System.out.println();
            }
        }
    }
}
