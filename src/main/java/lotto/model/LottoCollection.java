/*
 * 클래스 이름 LottoCollection
 *
 * 버전 정보 V1
 *
 * 날짜 10월 31일
 *
 * 저작권 주의
 */
package lotto.model;

import lotto.constant.Constant;
import lotto.domain.*;

import java.util.ArrayList;
import java.util.List;

public class LottoCollection {
    private final List<Lotto> lottoList = new ArrayList<>();
    private final List<WonLotto> resultList = new ArrayList<>();

    public LottoCollection(int numberOfLotto) {
        for (int i = 0; i < numberOfLotto; i++) {
            Lotto lotto = getRandomLotto();
            lottoList.add(lotto);
        }

    }

    private Lotto getRandomLotto() {
        List<Integer> randomNumbers = RandomNumbers.getRandomNumbers();
        return new Lotto(randomNumbers);
    }

    public String getState() {
        StringBuilder state = new StringBuilder();
        for (Lotto lotto : lottoList) {
            String lottoState = lotto.getState();
            state.append(lottoState);
            state.append("\n");
        }
        return state.toString();
    }

    public void compareWinningLotto(WinningLotto winningLotto) {
        for(Lotto lotto : lottoList) {
            Rank rank = lotto.getRank(winningLotto);
            WonLotto wonLotto = new WonLotto(lotto, rank);
            resultList.add(wonLotto);
        }
    }

    public int [] getWinningResult() {
        int [] resultArray = new int [Constant.NUMBER_OF_RANKS];
        for (WonLotto wonLotto : resultList) {
            int rank = wonLotto.getRankNumber();
            if(rank != 0){
                resultArray[rank - 1]++;
            }
        }
        return resultArray;
    }

    public int getTotalWinnings() {
        int totalWinnings = 0;
        for (WonLotto wonLotto : resultList) {
            Rank rank = wonLotto.getRank();
            int reward = rank.getReward();
            totalWinnings += reward;
        }
        return totalWinnings;
    }

    public double getPurchaseAmount() {
        int size = lottoList.size();
        return size * Constant.UNIT;
    }
}
