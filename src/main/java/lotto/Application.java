package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        System.out.print("구매금액을 입력해 주세요: ");
        int amount = LottoGeneration.inputPurchaseAmount();
        int quantity = LottoGeneration.extractQuantity(amount);
        List<Lotto> lottoSets = LottoGeneration.issueLotto(quantity);

        LottoGeneration.printLotto(lottoSets, quantity);

        System.out.println("당첨 번호를 입력해 주세요.");
        Lotto winningNumbers = LottoDraw.inputWinnigNumbers();

        System.out.println("보너스 번호를 입력해 주세요.");
        List<Integer> bonusNumber = LottoDraw.inputBonusNumber(winningNumbers);

        LottoResult.countFirstRank(lottoSets, winningNumbers);
        LottoResult.countSecondRank(lottoSets, winningNumbers, bonusNumber);
        LottoResult.countThirdRank(lottoSets, winningNumbers, bonusNumber);
        LottoResult.countFourthRank(lottoSets, winningNumbers);
        LottoResult.countFifthRank(lottoSets, winningNumbers);

        LottoResult.printResult();
        LottoResult.printRateOfReturn(amount);
    }
}
