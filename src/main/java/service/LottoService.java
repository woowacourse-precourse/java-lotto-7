package service;

import camp.nextstep.edu.missionutils.Randoms;
import common.LottoConstants;
import java.util.ArrayList;
import java.util.List;
import lotto.Lotto;
import lotto.LottoScoreboard;
import validator.InputValidator;
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

    public int getLottoPurchaseAmount() {
        return inputView.inputLottoPurchaseAmount();
    }

    public int getLottoDrawCount(int lottoPurchaseAmount) {
        InputValidator.isDivisibleByThousand(lottoPurchaseAmount);
        return lottoPurchaseAmount / 1000;
    }


    public Lotto getWinnerLottoNumbers() {

        List<Integer> lottoList = inputView.inputWinnerLottoNumbers();
        Lotto LottoWinnerNumber = new Lotto(lottoList);

        return LottoWinnerNumber;
    }

    public List<Lotto> generateRandomLottoNumbers(int lottoDrawCount) {
        List<Lotto> lottoNumbers = new ArrayList<>();

        for (int i = 0; i < lottoDrawCount; i++) {
            lottoNumbers.add(makeLotto());
        }

        return lottoNumbers;
    }

    public Lotto makeLotto() {
        List<Integer> numbers = new ArrayList<>();
        while (numbers.size() < 6) {
            numbers.add(Randoms.pickNumberInRange(1, 45));
        }
        return new Lotto(numbers);
    }

    public void printLottoNumbers(List<Lotto> lottoList) {
        outputView.outputLottoNumbers(lottoList);
    }

    public int getBonusNumber() {
        return inputView.inputBonusNumber();
    }
}
