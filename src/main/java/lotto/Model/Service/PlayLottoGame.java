package lotto.Model.Service;

import static lotto.constants.Constants.OUTPUT_RETYPE;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Model.Validation;
import lotto.View.InputView;

public class PlayLottoGame {
    private final Lotto winningLottoNumbers;
    private final List<Lotto> lottoList;
    private final Map<Integer, Boolean> matchingResult;
    private final Validation validation;
    private int bonusNumber;

    public PlayLottoGame(Lotto winningLottoNumbers, List<Lotto> lottoList, int bonusNumber) {
        this.winningLottoNumbers = winningLottoNumbers;
        this.lottoList = lottoList;
        this.bonusNumber = bonusNumber;
        this.matchingResult = new HashMap<>();
        this.validation = new Validation();
        validateBonusNumber();
    }

    // 보너스 번호가 당첨번호와 중복되는지 여부 체크
    private void validateBonusNumber() {
        boolean check = false;
        while (!check) {
            try {
                // Validation 클래스의 메소드를 호출하여 보너스 번호 중복 체크
                validation.validateBonusNumberWithWinningNumbers(winningLottoNumbers.getNumbers(), bonusNumber);
                check = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println(OUTPUT_RETYPE);
                this.bonusNumber = InputView.getBonusNumber();
            }
        }
    }

    // 각각의 로또가 당첨 숫자와 몇 개가 일치하는지, 보너스 숫자가 일치하는지 반환하는 로직
    public Map<Integer, Boolean> play() {
        lottoList.forEach(lotto -> {
            int matchCount = countMatches(lotto);
            boolean hasBonusMatch = checkBonusMatch(lotto);
            matchingResult.put(matchCount, hasBonusMatch);
        });
        return matchingResult;
    }

    // 당첨 숫자와 로또 비교 메소드
    private int countMatches(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningLottoNumbers.getNumbers()::contains)
                .count();
    }

    // 보너스 숫자와 비교 메소드
    private boolean checkBonusMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
