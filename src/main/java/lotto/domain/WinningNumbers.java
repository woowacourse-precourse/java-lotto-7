package lotto.domain;

import java.util.ArrayList;
import java.util.List;

public class WinningNumbers {
    private final Lotto winningLotto;
    private final int bonusNumber;
    private static WinningNumbers instance;

    public WinningNumbers(List<Integer> numbers, int bonusNumber) {
        this.winningLotto = new Lotto(numbers);
        if(winningLotto.getNumbers().contains(bonusNumber)) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호와 당첨 번호가 중복됩니다.");
        }
        this.bonusNumber = bonusNumber;
    }

    public static WinningNumbers getInstance(List<Integer> numbers, int bonusNumber) {
        if (instance == null) {
            instance = new WinningNumbers(numbers, bonusNumber);
        }
        return instance;
    }

    public List<WinningResult> matchWinningNumbers() {
        LottoMachine machine = LottoMachine.getInstance();
        List<WinningResult> lottoResult = new ArrayList<>();
        machine.getLottos().forEach(lotto -> {
            lottoResult.add(lotto.checkWinningResult(matchNumberCount(lotto), isBonusNumberMatch(lotto)));
        });
        return lottoResult;
    }

    public boolean isBonusNumberMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }

    public int matchNumberCount(Lotto lotto) {
       List<Integer> matchNumbers = new ArrayList<>(lotto.getNumbers());
       matchNumbers.retainAll((winningLotto.getNumbers())); //중복 번호 산출
       return matchNumbers.size();
    }
}
