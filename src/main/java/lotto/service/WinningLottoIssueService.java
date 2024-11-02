package lotto.service;

import java.util.List;
import lotto.Lotto;
import lotto.exception.BusinessException;
import lotto.util.ConsoleInput;

public class WinningLottoIssueService extends CustomLottoIssueService {

    @Override
    public List<Lotto> issue(int lottoCnt) {
        Lotto winningLotto = null;
        while (winningLotto == null) {
            winningLotto = getCustomLotto("\n당첨 번호를 입력해 주세요.");
        }
        initBonusNum(winningLotto);
        return List.of(lottoRepository.save(winningLotto));
    }

    private int initBonusNum(Lotto winningLotto) {
        int bonus = -1;
        while (bonus < 0) {
            bonus = getBonusNum(winningLotto);
        }
        lottoRepository.save(bonus);
        return bonus;
    }

    private int getBonusNum(Lotto winningLotto) {
        int bonus;
        try {
            bonus = ConsoleInput.getIntWithPrompt("\n보너스 번호를 입력해 주세요.");
            validateBonusNum(winningLotto, bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return -1;
        }
        return bonus;
    }

    private void validateBonusNum(Lotto winningLotto, int bonusNum) {
        validateLottoNumRange(bonusNum);
        validateDuplicate(winningLotto, bonusNum);
    }

    private void validateDuplicate(Lotto winningLotto, int bonusNum) {
        if (winningLotto.contains(bonusNum)) {
            throw new BusinessException("보너스 번호는 당첨 번호와 중복될 수 없습니다.");
        }
    }
}
