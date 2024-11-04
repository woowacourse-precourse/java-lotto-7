package lotto.model;

import static lotto.view.InputView.getStrInput;
import static lotto.view.OutputView.printErrorMessage;

import java.util.ArrayList;
import java.util.List;
import lotto.exception.ErrorCode;
import lotto.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;

public class LottoGame {
    private static final int LOTTO_PRICE = 1000;
    private final OutputView outputView;
    private final WinningLottoNumbers winningLottoNumbers;

    public LottoGame(OutputView outputView, WinningLottoNumbers winningNumbers) {
        this.outputView = outputView;
        this.winningLottoNumbers = winningNumbers;
    }

    public List<Lotto> purchase() {
        int price = getValidatedPrice();
        int lottoCount = countLottoes(price);
        outputView.printPurchasePrompt(lottoCount);
        return generateLottoes(lottoCount);
    }

    public void playLottoGame() {
        List<Integer> winningNumbers =  winningLottoNumbers.getWinningNumber();
        winningLottoNumbers.validatePositiveInteger(winningNumbers);
        outputView.promptBonusNumber();
        int BonusNumber = winningLottoNumbers.getBonusNumber(winningNumbers);

    }


    public int getValidatedPrice() {
        while (true) {
            String priceInput = getStrInput();

            try {
                return validatePrice(priceInput);
            } catch (IllegalArgumentException e) {
                printErrorMessage(e.getMessage());
            }
        }
    }

    private int validatePrice(String priceInput) {
        try {
            int price = Integer.parseInt(priceInput);
            if (price < 0) {
                throw new IllegalArgumentException(ErrorCode.INVALID_NEGATIVE_NUMBER.getMessage());
            } else if (price % LOTTO_PRICE != 0) {
                throw new IllegalArgumentException(ErrorCode.INVALID_PRICE_UNIT.getMessage());
            }
            return price;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorCode.INVALID_AMOUNT_FORMAT.getMessage());
        }
    }

    private int countLottoes(int price) {
        return price / LOTTO_PRICE;
    }

    private List<Lotto> generateLottoes(int lottoCount) {
        List<Lotto> lottoes = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            Lotto lotto = new Lotto(numbers);
            lottoes.add(lotto);
        }
        return lottoes;
    }
}
