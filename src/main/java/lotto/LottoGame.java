package lotto;

import java.util.List;

public class LottoGame {
    private final UserInputLotto userInputLotto;
    private final LottoGeneration lottoGeneration;
    private final LottoCheck lottoCheck;
    private final OutputLottoResult outputLottoResult;
    private int[] lottoResults;
    private int totalPrize;

    public LottoGame() {
        this.userInputLotto = new UserInputLotto();
        this.lottoGeneration = new LottoGeneration();
        this.lottoCheck = new LottoCheck();
        this.outputLottoResult = new OutputLottoResult();
        this.lottoResults = new int[5];
        this.totalPrize = 0;
    }

    public void start() {
        // 로또 발매 주요 흐름
        int purchaseAmount = userInputLotto.purchaseAmount();
        List<Lotto> purchasedLottos = initGame(purchaseAmount);

        List<Integer> winningNumbers = userInputLotto.inputPrizeNumbers();
        int bonusNumber = userInputLotto.inputBonusNumber(winningNumbers);

        calculateRank(purchasedLottos, winningNumbers, bonusNumber);
        outputLottoResult.printLottoResults(lottoResults, totalPrize, purchaseAmount);
    }

    private List<Lotto> initGame(int purchaseAmount) {
        // 구입 금액에 따른 로또 생 및 정보 출력
        int lottoCount = purchaseAmount / 1000;
        List<Lotto> purchasedLottos = lottoGeneration.generateLottoLines(lottoCount);
        outputLottoResult.printLottoInfo(lottoCount, purchasedLottos);

        return purchasedLottos;
    }

    private void calculateRank(List<Lotto> purchasedLottos, List<Integer> winningNumbers, int bonusNumber) {
        // 당첨 결과 계산 메서드
        for (Lotto lotto : purchasedLottos) {
            int rank = lottoCheck.checkRank(lotto, winningNumbers, bonusNumber);
            if (rank >= 1 && rank <= 5) {
                lottoResults[rank - 1]++;
                totalPrize += lottoCheck.prizeInfo(rank);
            }
        }
    }
}
