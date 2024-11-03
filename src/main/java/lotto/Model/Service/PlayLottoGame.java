package lotto.Model.Service;

import static lotto.constants.Constants.OUTPUT_RETYPE;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import lotto.Lotto;
import lotto.Model.Validation;
import lotto.View.InputView;

public class PlayLottoGame {
    private final ArrayList<Integer> winningNumbers;
    private final List<Lotto> lottoList;
    private final Map<Integer, Boolean> matchingResult;
    private final Validation validation;
    private int bonusNumber;

    public PlayLottoGame(ArrayList<Integer> winningNumbers, List<Lotto> lottoList, int bonusNumber) {
        this.winningNumbers = winningNumbers;
        this.lottoList = lottoList;
        this.bonusNumber = bonusNumber;
        this.matchingResult = new HashMap<>();
        this.validation = new Validation();
        validate();
    }

    //보너스 번호가 당첨번호와 중복되는지 여부 체크
    public void validate() {
        boolean check = false;
        while (!check) {
            try {
                validation.isWinningNumberContainBonus(winningNumbers, bonusNumber);
                check = true;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                System.out.println(OUTPUT_RETYPE);
                this.bonusNumber = InputView.getBonusNumber();
            }
        }

    }

    //각각의 로또가 당첨숫자와 몇개가 일치하는지,보너스 숫자가 일치하는지 반환하는 로직
    public Map<Integer, Boolean> play() {
        lottoList.forEach(lotto -> {
            int matchCount = countMatches(lotto);
            boolean hasBonusMatch = checkBonusMatch(lotto);
            matchingResult.put(matchCount, hasBonusMatch);
        });
        return matchingResult;
    }

    //당첨숫자와 로또 비교 메소드
    private int countMatches(Lotto lotto) {
        return (int) lotto.getNumbers().stream()
                .filter(winningNumbers::contains)
                .count();
    }

    //보너스 숫자와 비교 메소드
    private boolean checkBonusMatch(Lotto lotto) {
        return lotto.getNumbers().contains(bonusNumber);
    }
}
