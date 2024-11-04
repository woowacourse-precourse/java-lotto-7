package lotto.model;

import static lotto.ErrorMessages.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import lotto.RandomNumbersGenerator;
import lotto.controller.LottoController;

public class LottoGame {
    private final List<Lotto> lottos;
    private final RandomNumbersGenerator numbersGenerator;
    private LottoController controller;
    private int purchase;
    private Lotto winingLotto;
    private int bonusNumber;

    public LottoGame() {
        this.lottos = new ArrayList<>();
        this.numbersGenerator = new RandomNumbersGenerator();
    }

    public void purchaseLottos(int purchase) {
        this.purchase = purchase;
        lottosFactory(numbersGenerator);
        controller.displayPurchase(purchase);
        controller.displayLottos(lottos);
    }

    public void validatePurchaseInput(String input) throws IllegalArgumentException {
        int amount;
        amount = tryParseInt(input);
        isNegativeNumber(amount);
        isDividedClearly(amount);
    }

    public void createWiningLotto(String input) throws IllegalArgumentException {
        Lotto lotto = new Lotto();
        List<Integer> numberList = trySplitParse(input);
        lotto.validate(numberList);
        this.winingLotto = new Lotto(numberList);
    }

    public void creatBonusNumber(String input) throws IllegalArgumentException {
        int number = tryParseInt(input);
        winingLotto.validate(number);
        this.bonusNumber = number;
    }

    private List<Integer> trySplitParse(String input) throws IllegalArgumentException {
        List<Integer> numberList;
        try {
            numberList = Stream.of(input.split(","))
                    .map(Integer::parseInt)
                    .collect(Collectors.toCollection(ArrayList::new));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_FORMAT_MESSAGE.getMessage());
        }
        return numberList;
    }

    private static void isDividedClearly(int amount) throws IllegalArgumentException {
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException(ERROR_PURCHASE_INPUT_WRONG_UNIT.getMessage());
        }
    }

    private static void isNegativeNumber(int amount) throws IllegalArgumentException {
        if (amount < 0) {
            throw new IllegalArgumentException(ERROR_PURCHASE_INPUT_NOT_POSITIVE.getMessage());
        }
    }

    private static int tryParseInt(String input) throws IllegalArgumentException {
        int amount;
        try {
            amount = Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ERROR_NUMBER_FORMAT_MESSAGE.getMessage());
        }
        return amount;
    }

    private void lottosFactory(RandomNumbersGenerator numbersGenerator) {
        for (int i = 0; i < this.purchase; i++) {
            this.lottos.add(new Lotto(numbersGenerator));
        }
    }

    public void registController(LottoController controller) {
        this.controller = controller;
    }
}
