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
        inputNum();
        inputBonus();
        calculate();
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
        Output.purchase(lottos);
    }

    public void calculate() {
        long[] count = new long[6];

        for(Lotto l : lottos) {
            count[l.getRank(win.getNumbers(), bonus)]++;
        }
        long total = sum(count);
        double interest = ((double)total / (double)money) * 100;
        interest = Math.round(interest*10)/10.0;
        Output.statistic(count, interest);
    }

    public long sum(long[] count) {
        long total = 0;
        total += count[5]*5000;
        total += count[4]*50000;
        total += count[3]*1500000;
        total += count[2]*30000000;
        total += count[1]*2000000000;
        return total;
    }
}
