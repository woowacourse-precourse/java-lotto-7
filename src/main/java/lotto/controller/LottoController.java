package lotto.controller;

import lotto.domain.InputValidator;
import lotto.domain.Lotto;
import lotto.domain.PrizeSystem;
import lotto.view.OutputView;

import java.util.ArrayList;
import java.util.List;

public class LottoController {

    private List<Lotto> lottos = new ArrayList<>();
    private PrizeSystem prizeSystem;

    private int purchaseMoney;
    private List<Integer> prizeNumbers;
    private int bonusNumber;

}
