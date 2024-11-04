package lotto.service;

import lotto.exception.BusinessException;
import lotto.exception.ErrorMessage;
import lotto.model.db.Lotto;
import lotto.model.db.Owner;
import lotto.util.ConsoleInput;

public class WinningLottoIssueService extends CustomLottoIssueService {

    private static final String BONUS_ENTER_PROMPT = "\n보너스 번호를 입력해 주세요.";
    private static final int UNINITIALIZED = -1;

    @Override
    public Lotto issue(String prompt) {
        Lotto winningLotto = super.issue(prompt);
        int bonus = issueBonus(winningLotto);
        userRepository.save(Owner.from(winningLotto, bonus));
        return winningLotto;
    }

    private int issueBonus(Lotto winningLotto) {
        int bonus = UNINITIALIZED;
        while (bonus == UNINITIALIZED) {
            bonus = getBonusNum(winningLotto);
        }
        return bonus;
    }

    private int getBonusNum(Lotto winningLotto) {
        int bonus;
        try {
            bonus = ConsoleInput.getIntWithPrompt(BONUS_ENTER_PROMPT);
            validateBonusNum(winningLotto, bonus);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return UNINITIALIZED;
        }
        return bonus;
    }

    private void validateBonusNum(Lotto winningLotto, int bonusNum) {
        validateLottoNumRange(bonusNum);
        validateDuplicate(winningLotto, bonusNum);
    }

    private void validateDuplicate(Lotto winningLotto, int bonusNum) {
        if (winningLotto.contains(bonusNum)) {
            throw new BusinessException(ErrorMessage.DUPLICATED_BONUS_NUM);
        }
    }
}
