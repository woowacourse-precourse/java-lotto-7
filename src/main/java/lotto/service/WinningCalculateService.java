package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.Winning;
import lotto.domain.WinningLotto;

import java.util.List;

public class WinningCalculateService {

    private static final int BEFORE_BONUS_NUMBER_INDEX = 6;


    public static int compareLotto(Lotto lotto, WinningLotto winningLotto) {
        int matchCount = 0;
        boolean hasBonusMatch = false;
        List<Integer> lottoNumbers = lotto.getNumbers();                  // 구매한 로또 번호들
        List<Integer> winningNumbers = winningLotto.getNumbers();  // 당첨 번호들

        int bonusNumber = winningLotto.getBonusNumber();

        // 일반 번호 매칭 확인
        for (int lottoNumber : lottoNumbers) {
            if (winningNumbers.contains(lottoNumber)) {
                matchCount++;
            }
            // 보너스 번호 매칭 확인
            if (lottoNumber == bonusNumber) {
                hasBonusMatch = true;
            }
        }
        return matchCount;
    }

    public static LottoResult returnLottoResult(){
        // 당첨 결과 반환
        if (matchCount == 6) {
            return new LottoResult(Winning.FIRST);
        }
        if (matchCount == 5 && hasBonusMatch) {
            return new LottoResult(Winning.SECOND);
        }
        if (matchCount == 5) {
            return new LottoResult(Winning.THIRD);
        }
        if (matchCount == 4) {
            return new LottoResult(Winning.FOURTH);
        }
        if (matchCount == 3) {
            return new LottoResult(Winning.FIFTH);
        }
        return null;
    }


}
