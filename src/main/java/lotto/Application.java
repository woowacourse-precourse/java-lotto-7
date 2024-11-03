package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        Input input = new Input(new InputValidator());

        Integer amount = input.getAmountWithMessage();
        Integer count = amount/1000;

        Lotto winNumberLotto = input.getWinNumberLotto();

        WinLotto winLotto = input.getBonusNumber(winNumberLotto);

        LottoService lottoService = new LottoService(new LottoGenerator(new LottoStrategyRandom()));
        Lottos lottos = lottoService.createLottos(count);

        List<Rank> ranks = lottos.compareWithWinLotto(winLotto);

        // 수익률을 계산
        double revenue = lottoService.calculateRevenue(ranks, count);
    }
}
