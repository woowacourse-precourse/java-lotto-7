package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();

        int lottoCount = lottoPurchase.inputPurchaseAmount();
        List<List<Integer>> lottos = lottoNumberGenerator.generateLottoNumbers(lottoCount);

        lottoNumberGenerator.printLottos(lottos);
    }
}