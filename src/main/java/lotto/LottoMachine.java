package lotto;

import java.util.*;
import camp.nextstep.edu.missionutils.Randoms;

import lotto.io.*;

public class LottoMachine {
    public int money;
    public Lotto win;
    public int bonus;
    public int lottonum;
    public List<Lotto> lottos;

    public void start() {
        inputMoney();
        lottoGen();
        Output.purchase(lottos);
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
                lottonum = money/1000;
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

    public void lottoGen() {
        lottos = new ArrayList<>();
        for(int i = 0; i< lottonum; i++) {
            lottos.add(new Lotto(Randoms.pickUniqueNumbersInRange(1, 45, 6)));
        }
    }
}
