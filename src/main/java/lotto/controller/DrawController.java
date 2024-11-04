package lotto.controller;

import lotto.common.Displayable;
import lotto.domain.Lottos;
import lotto.domain.WinningLotto;

public class DrawController {
    public Displayable draw(Lottos lottos, WinningLotto winningLotto) {
        return lottos.matchNumbers(winningLotto);
    }
}
