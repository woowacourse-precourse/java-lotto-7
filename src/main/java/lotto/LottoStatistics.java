package lotto;

import java.util.ArrayList;
import java.util.List;

public class LottoStatistics {

    private final List<Integer> winningNum;
    private final int bonusNum;
    private static Lotto[] lottos;

    private static int first;
    private static int second;
    private static int third;
    private static int fourth;
    private static int fifth;


    public LottoStatistics(List<Integer> winningNum, Lotto[] lottos, int bonusNum) {
        this.winningNum = winningNum;
        this.lottos = lottos;
        this.bonusNum = bonusNum;
        first = 0;
        second = 0;
        third = 0;
        fourth = 0;
        fifth = 0;
    }

    public void compareNum() {
        for(Lotto lotto : lottos) {
            List<Integer> lottoNum = new ArrayList<>();
            lottoNum.addAll(lotto.getNumbers());
            discerning(lottoNum);
        }
    }

    public void discerning(List<Integer> lottoNum) {
        List<Integer> overlapNum = new ArrayList<>();
        overlapNum.addAll(lottoNum);
        overlapNum.retainAll(winningNum);
        if(overlapNum.size() == 3) {
            fifth++;
            return;
        }
        if(overlapNum.size() == 4) {
            fourth++;
            return;
        }
        if(overlapNum.size() == 5) {
            if(lottoNum.contains(bonusNum)) {
                second++;
                return;
            }
            third++;
            return;
        }
        if(overlapNum.size() == 6) {
            first++;
            return;
        }
    }
}
