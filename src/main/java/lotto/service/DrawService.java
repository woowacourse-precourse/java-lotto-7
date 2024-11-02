package lotto.service;

import java.util.List;
import lotto.domain.Bonus;
import lotto.domain.Lotto;
import lotto.view.InputView;

public class DrawService {
    public Lotto getLotto(List<Integer> lottoNumbers) {
        Lotto lotto = null;
        while (lotto == null) {
            try {
                lotto =  drawLotto(lottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                lottoNumbers = InputView.getLottoNumber();
            }
        }
        return lotto;
    }

    public Bonus getBonus(int bonusNumber, List<Integer> lottoNumbers) {
        Bonus bonus = null;
        while (bonus == null) {
            try {
                bonus = drawBonus(bonusNumber, lottoNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                bonusNumber = InputView.getBonusNumber();
            }
        }
        return bonus;
    }

    private Lotto drawLotto(List<Integer> lottoNumbers) {
        return new Lotto(lottoNumbers);
    }

    private Bonus drawBonus(int bonusNumber, List<Integer> lottoNumbers) {
        return new Bonus(bonusNumber, lottoNumbers);
    }

}
