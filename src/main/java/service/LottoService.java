package service;

import camp.nextstep.edu.missionutils.Randoms;
import common.LottoConstants;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.LottoScoreboard;
import view.InputView;
import view.OutputView;

public class LottoService {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private LottoScoreboard lottoScoreboard;
    private final List<Lotto> lottoList = new ArrayList<>();
    private int lottoPurchaseAmount;
    private int lottoDrawCount;
    private Lotto winnerLottoNumber;
    private int bonusNumber;


    public void initializeLottoPurchaseAmount() {
        this.lottoPurchaseAmount = inputView.inputLottoPurchaseAmount();
        this.lottoScoreboard = new LottoScoreboard(lottoPurchaseAmount, 0);
    }

    public void initializeLottoDrawCount() {
        this.lottoDrawCount = lottoPurchaseAmount / LottoConstants.TICKET_PRICE.getValue();
    }


    public void initializeWinnerLottoNumbers() {
        List<Integer> winnerNumbers = inputView.inputWinnerLottoNumbers();
        this.winnerLottoNumber = new Lotto(winnerNumbers);
    }

    public void generateRandomLottoNumbers() {
        for (int i = 0; i < lottoDrawCount; i++) {
            this.lottoList.add(makeLotto());
        }
    }

    public Lotto makeLotto() {
        List<Integer> numbers = Randoms.pickUniqueNumbersInRange(LottoConstants.MIN_LOTTO_NUMBER.getValue(),
                LottoConstants.MAX_LOTTO_NUMBER.getValue(), LottoConstants.LOTTO_NUMBER_COUNT.getValue());
        return new Lotto(numbers);
    }

    public void printLottoNumbers() {
        outputView.outputLottoNumbers(this.lottoList);
    }

    public void initializeBonusNumber() {
        this.bonusNumber = inputView.inputBonusNumber();
    }

    public void calculateLottoScore() {
        for (Lotto lotto : lottoList) {
            int matchCount = countMatches(lotto.getNumbers(), winnerLottoNumber.getNumbers());
            boolean bonusMatch = lotto.getNumbers().contains(bonusNumber);

            lottoScoreboard.calculateIncrementNumber(matchCount, bonusMatch);
        }
    }

    private int countMatches(List<Integer> ticketNumbers, List<Integer> winnerNumbers) {
        int matchCount = 0;
        for (int number : ticketNumbers) {
            if (winnerNumbers.contains(number)) {
                matchCount++;
            }
        }
        return matchCount;
    }

    public void displayWinningResults() {
        outputView.printScoreboard(lottoScoreboard);
    }

}
