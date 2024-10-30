package lotto.model;

import lotto.Lotto;
import lotto.dto.WinningLottoInfo;

import java.util.ArrayList;
import java.util.List;

public class WinningLotto {
    private Lotto winningLotto;
    private int bonusNumber;

    public WinningLotto(WinningLottoInfo winningLottoInfo) {
        this.winningLotto = new Lotto(parseLottoNumbers(winningLottoInfo.winningLottoNums()));

        validateBonusNumber(winningLottoInfo.bonusNum());
        this.bonusNumber = winningLottoInfo.bonusNum();
    }

    private List<Integer> parseLottoNumbers(String rawLottoNumbers) {
        List<Integer> parsingNumbers = new ArrayList<>();
        String[] lottoNumbers = rawLottoNumbers.split(",");

        for (String lottoNumber : lottoNumbers) {
            try {
                parsingNumbers.add(Integer.parseInt(lottoNumber));
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 당첨번호를 숫자로만 입력해주세요.");
            }
        }

        return parsingNumbers;
    }

    private void validateBonusNumber(int bonusNumber) {
        if (bonusNumber < 1 || bonusNumber > 45) {
            throw new IllegalArgumentException("[ERROR] 보너스 번호는 1~45 사이의 수만 가능합니다.");
        }

        winningLotto.checkBonusNumberDuple(bonusNumber);
    }
}
