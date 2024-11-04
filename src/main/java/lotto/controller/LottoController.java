package lotto.controller;

import static lotto.constant.LottoConstant.LOTTO_MAX_NUMBER;
import static lotto.constant.LottoConstant.LOTTO_MIN_NUMBER;
import static lotto.exception.LottoErrorMessage.BONUS_NUMBER_DUPLICATE_WITH_WINNING_NUMBER;
import static lotto.exception.LottoErrorMessage.LOTTO_NUMBER_OUT_OF_RANGE;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.function.Supplier;
import lotto.model.Lotto;
import lotto.model.LottoMachine;
import lotto.model.LottoPrice;
import lotto.view.LottoInputView;
import lotto.view.LottoOutputView;

public class LottoController {
    public static final String WINNING_NUMBERS_SPLIT_REGEX = ",";
    private final LottoInputView lottoInputView;
    private final LottoOutputView lottoOutputView;

    public LottoController(LottoInputView lottoInputView, LottoOutputView lottoOutputView) {
        this.lottoInputView = lottoInputView;
        this.lottoOutputView = lottoOutputView;
    }

    public void run() {
        LottoMachine lottoMachine = new LottoMachine();
        List<Lotto> lottos = buyLottos(lottoMachine);

        printLottoNumbers(lottos);

        Lotto winningLotto = inputWinningNumbers();
        int bonusNumber = inputBonusNumber(winningLotto);

        HashMap<LottoPrice, Integer> prices = lottoMachine.calculateLottoPrice(lottos, winningLotto, bonusNumber);

        lottoOutputView.printLottoWinPrice(prices);
        lottoOutputView.printProfitRate(prices, lottos.size());
    }

    private List<Lotto> buyLottos(LottoMachine lottoMachine) {
        return executeWithRetry(() -> {
            lottoOutputView.printInputLottoMoneyMessage();
            int money = lottoInputView.readInt();
            return lottoMachine.issueLottos(money);
        });
    }

    private <T> T executeWithRetry(Supplier<T> action) {
        while (true) {
            try {
                return action.get();
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void printLottoNumbers(List<Lotto> lottos) {
        List<List<Integer>> lottosNumbers = lottos.stream()
                .map(Lotto::getNumbers)
                .toList();
        lottoOutputView.printLottosNumber(lottosNumbers);
    }

    private Lotto inputWinningNumbers() {
        return executeWithRetry(() -> {
            lottoOutputView.printWinningNumbersMessage();
            String input = lottoInputView.readString();
            return parseWinningNumbers(input);
        });
    }

    private Lotto parseWinningNumbers(String input) {
        List<Integer> winningNumbers = Arrays.stream(input.split(WINNING_NUMBERS_SPLIT_REGEX))
                .mapToInt(Integer::parseInt)
                .sorted()
                .boxed()
                .toList();
        return new Lotto(winningNumbers);
    }

    private int inputBonusNumber(Lotto lottoNumbers) {
        return executeWithRetry(() -> {
            lottoOutputView.printBonusNumberMessage();
            int bonusNumber = Integer.parseInt(Console.readLine());
            validateBonusNumber(bonusNumber, lottoNumbers);
            return bonusNumber;
        });
    }

    private void validateBonusNumber(int bonusNumber, Lotto lottoNumbers) {
        if (bonusNumber < LOTTO_MIN_NUMBER || bonusNumber > LOTTO_MAX_NUMBER) {
            throw new IllegalArgumentException(LOTTO_NUMBER_OUT_OF_RANGE.message);
        }
        if (lottoNumbers.contains(bonusNumber)) {
            throw new IllegalArgumentException(BONUS_NUMBER_DUPLICATE_WITH_WINNING_NUMBER.message);
        }
    }
}
