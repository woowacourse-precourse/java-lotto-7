package lotto.controller;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.ErrorMessage;
import lotto.LottoManager;
import lotto.model.Lottos;
import lotto.NumberGenerate;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {

    public static final int LOTTO_PRICE = 1000;

    private final InputView inputView;
    private final OutputView outputView;
    private final LottoManager lottoManager;

    public LottoController(InputView inputView, OutputView outputView, NumberGenerate lottoGenerator) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.lottoManager = new LottoManager(lottoGenerator);
    }

    public void run() {
        int money = lottoMoneyInput();

        Lottos lottos = lottoManager.buyLotto(money);
        outputView.showHowManyLotto(lottos);
        outputView.showAllLottoNums(lottos);

        List<Integer> numbers;
        while (true) {
            try {
                String rawNumbers = inputView.lottoNumsInput();
                numbers = Arrays.stream(rawNumbers.split(","))
                        .map(Integer::parseInt)
                        .toList();
                validateNumberDuplication(numbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        int bonusNumbers;
        while (true) {
            try {
                bonusNumbers = inputView.lottoBounsNumInput();
                validateBonusNumberDuplication(numbers, bonusNumbers);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }
    }

    private void validateNumberDuplication(List<Integer> numbers) {
        Set<Integer> duplication = new HashSet<>(numbers);
        if (duplication.size() != numbers.size()) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMS_DUPLICATION.getMsg());
        }
    }

    private void validateBonusNumberDuplication(List<Integer> numbers, int bonus) {
        Set<Integer> duplication = new HashSet<>(numbers);
        duplication.add(bonus);
        if (duplication.size() != (numbers.size() + 1)) {
            throw new IllegalArgumentException(ErrorMessage.LOTTO_NUMS_DUPLICATION.getMsg());
        }
    }

    private int lottoMoneyInput() {
        int money;
        while (true) {
            try {
                money = inputView.lottoMoneyInput();
                validateIsRightNumber(money);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                continue;
            }
            break;
        }

        return money;
    }

    private void validateIsRightNumber(int value) {
        if (value % LOTTO_PRICE != 0) {
            throw new IllegalArgumentException(ErrorMessage.MONEY_IS_NOT_DIVIDE_PRICE.getMsg());
        }
    }
}
