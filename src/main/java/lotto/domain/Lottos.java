package lotto.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Lottos {

    private static final Lottos instance = new Lottos(); // 싱글톤 패턴 적용

    private final List<Lotto> lottos = new ArrayList<>();
    private final int[] winningLottoCounts = new int[8];
    private Lotto inputLottoNumbers;
    private Integer bonusNumber;

    private Lottos() {
        Arrays.fill(winningLottoCounts, 0);
    }

    public static Lottos getInstance() {
        return instance;
    }

    public void add(Lotto lotto) {
        lottos.add(lotto);
    }

    public List<Lotto> getLottos() {
        return lottos;
    }

    public int[] getWinningLottoCounts() {
        return winningLottoCounts;
    }

    public Lotto getInputLottoNumbers() {
        return inputLottoNumbers;
    }

    public Integer getBonusNumber() {
        return bonusNumber;
    }

    public void setInputLottoNumbers(Lotto inputLottoNumbers) {
        this.inputLottoNumbers = inputLottoNumbers;
    }

    public void setBonusNumber(Integer bonusNumber) {
        this.bonusNumber = bonusNumber;
    }

    public void countUp(int index) {
        winningLottoCounts[index]++;
    }
}