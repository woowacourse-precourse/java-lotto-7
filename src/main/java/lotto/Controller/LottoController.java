package lotto.Controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import lotto.Constants;
import lotto.Model.Lotto;
import lotto.Utils;

public class LottoController {
    private int lottoAmount;
    private List<Lotto> lottos;

    public LottoController(){
        set();
        setLottos();
        displayLottos();
    }
    private void set(){
        lottoAmount = InputController.setAmountOfLotto();
    }
    private void setLottos() {
        lottos = IntStream.range(0, lottoAmount)
                .mapToObj(i -> new Lotto(Utils.setLottoNums()))
                .collect(Collectors.toList());
    }
    private void displayLottos() {
        System.out.printf("%d개를 구매했습니다.%n", lottoAmount);
    }
}