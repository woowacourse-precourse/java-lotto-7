package lotto.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;

public class LottoNumberGenerator {
    private List<Integer> lottoNumbers;
    private List<Integer> winningNumbers;
    private int bonusNumber;

    public List<Integer> generateNumbers() {
        this.lottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
        return lottoNumbers;
    }

    // 외부에서 당첨 번호를 설정
    public void setWinningNumbers(List<Integer> numbers) {
        this.winningNumbers = List.copyOf(numbers);
    }

    // 외부에서 보너스 번호를 설정
    public void setBonusNumber(int bonus) {
        this.bonusNumber = bonus;
    }

    public List<Integer> getLottoNumbers() {
        return lottoNumbers;
    }

    public List<Integer> getWinningNumbers() {
        return winningNumbers;
    }

    public int getBonusNumbers() {
        return bonusNumber;
    }
}
