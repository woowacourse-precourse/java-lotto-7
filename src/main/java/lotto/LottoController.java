package lotto;

import java.util.Arrays;
import java.util.List;

public class LottoController {
    private Lotto winningLotto;
    private Integer bonusNumber;
    private LottoGroup lottoGroup;
    private final View view = new View();

    public LottoController() {
    }

    void run() {
        purchaseLotto(view.getPurchaseCost());
        view.println(lottoGroup.getLottoGroupSize());
        view.println(lottoGroup.getLottoNumbers());

        getWinningNumbers(view.getWinningNumbers());
        getBonusNumber(view.getBonusNumber());
        LottoRankGroup lottoRankGroup = LottoRankGroup.of(lottoGroup, winningLotto, bonusNumber);

        view.println(lottoRankGroup.getRankInstructions());
    }

    void purchaseLotto(String input) {
        while (true) {
            try {
                lottoGroup = LottoGroup.create(getPurchaseAmount(Integer.parseInt(input)));
                break;
            } catch (IllegalArgumentException e) {
                view.println("[ERROR] " + e.getMessage());
                input = view.getPurchaseCost();
            }
        }
    }

    private int getPurchaseAmount(int purchaseCost) {
        validatePurchaseCost(purchaseCost);
        return purchaseCost / Lotto.PRICE;
    }

    private void validatePurchaseCost(int purchaseCost) {
        if (purchaseCost % Lotto.PRICE != 0) {
            throw new IllegalArgumentException("구입 금액은 1,000원 단위로 입력해야 합니다.");
        }
    }

    void getWinningNumbers(String input) {
        while (true) {
            try {
                winningLotto = new Lotto(getNumbers(input));
                break;
            } catch (IllegalArgumentException e) {
                view.println("[ERROR] " + e.getMessage());
                input = view.getWinningNumbers();
            }
        }
    }

    private List<Integer> getNumbers(String numbers) {
        return Arrays.stream(numbers.split(","))
                .map(String::trim)
                .map(Integer::parseInt)
                .toList();
    }

    void getBonusNumber(String input) {
        while (true) {
            try {
                winningLotto.validateBonusNumber(bonusNumber = Integer.parseInt(input));
                break;
            } catch (IllegalArgumentException e) {
                view.println("[ERROR] " + e.getMessage());
                input = view.getBonusNumber();
            }
        }
    }
}
