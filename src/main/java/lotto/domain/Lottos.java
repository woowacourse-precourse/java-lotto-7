package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottos {
    private final List<Lotto> lottoList = new ArrayList<>();
    private final int[] winningLottoCounts = new int[7];
    private final List<Integer> inputLottoNumbers;
    private final Integer bonusNumber;

    public Lottos(List<Integer> numbers, Integer bonusNumber) {
        this.inputLottoNumbers = numbers;
        this.bonusNumber = bonusNumber;
        Arrays.fill(winningLottoCounts, 0);
    }

    public void add(Lotto lotto) {
        lottoList.add(lotto);
    }

    public List<Lotto> getLottoList() {
        return lottoList;
    }

    public int[] getWinningLottoCounts() {
        return winningLottoCounts;
    }

    public List<Integer> getInputLottoNumbers() {
        return inputLottoNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void countUp(int index) {
        winningLottoCounts[index]++;
    }
}