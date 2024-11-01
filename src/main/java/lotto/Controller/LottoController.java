package lotto.Controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Model.Lotto;
import lotto.Utils;

public class LottoController {
    private int lottoAmount;
    private List<Lotto> lottos;
    private List<Integer> winningNums;

    public LottoController() {
        set();
        setLottos();
        displayLottos();
        setWinningNums();
    }

    private void setWinningNums() {
        try{
            winningNums = InputController.setWinningNums();
        }catch (IllegalArgumentException e){
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
        System.out.printf("%d개를 구매했습니다.%n", lottoAmount);
        Utils.printLottos(lottos);
    }
}