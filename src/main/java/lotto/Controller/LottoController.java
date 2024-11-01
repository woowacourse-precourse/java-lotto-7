package lotto.Controller;

import java.util.EnumMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Model.Lotto;
import lotto.Model.Rank;
import lotto.Model.Result;
import lotto.Utils;
import lotto.View.OutputView;

public class LottoController {
    private int lottoAmount;
    private List<Lotto> lottos;
    private List<Integer> winningNums;
    private int bonusNum;

    public LottoController() {
        set();
        setLottos();
        displayLottos();
        setWinningNums();
        setBonusNum();
        calculateWinning();
    }

    private void calculateWinning() {
        OutputView.printResult();
        Result result = new Result();
        result.compareLottos(lottos, winningNums, bonusNum);
        result.calcRevenue(lottoAmount);

    }

    private void setWinningNums() {
        try {
            winningNums = InputController.setWinningNums();
        } catch (IllegalArgumentException e) {
            setWinningNums();
        }
    }

    private void set() {
        try {
            lottoAmount = InputController.setAmountOfLotto();
        } catch (IllegalArgumentException e) {
            set();
        }
    }

    private void setLottos() {
        try {
            lottos = IntStream.range(0, lottoAmount)
                    .mapToObj(i -> new Lotto(Utils.setLottoNums()))
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            setLottos();
        }
    }

    private void displayLottos() {
        Utils.printLottos(lottos);
    }

    private void setBonusNum() {
        try {
            bonusNum = InputController.setBonusNum(winningNums);
        } catch (IllegalArgumentException e) {
            setBonusNum();
        }
    }
}