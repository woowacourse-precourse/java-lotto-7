package lotto.service;

import lotto.model.db.Lotto;
import lotto.exception.BusinessException;
import lotto.model.db.Owner;
import lotto.util.ConsoleInput;

public class WinningLottoIssueService extends CustomLottoIssueService {

    @Override
    public Lotto issue(String prompt) {
        Lotto winningLotto = super.issue(prompt);
        int bonus = issueBonus(winningLotto);
        userRepository.save(Owner.from(winningLotto, bonus));
        return winningLotto;
    }

    private int issueBonus(Lotto winningLotto) {
        int bonus = -1;
        while (bonus < 0) {
            bonus = getBonusNum(winningLotto);
        }
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
