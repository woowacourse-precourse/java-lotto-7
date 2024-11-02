package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        InputView inputView = new InputView();
        Lotto lotto = new Lotto(inputView.getLottoNumbers());
        List<List<Integer>> boughtLottoNumbers = lotto.generateLotto(inputView.getLottoCount());
        OutputView outputView = new OutputView(boughtLottoNumbers);
        outputView.outputLottoNumbers();
    }
}
