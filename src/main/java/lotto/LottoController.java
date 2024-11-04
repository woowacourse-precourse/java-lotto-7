package lotto;

public class LottoController {
    private Lotto winningLotto;
    private Integer bonusNumber;
    private LottoGroup lottoGroup;
    private final View view = new View();

    public LottoController() {
    }

    void run() {
        lottoGroup = purchaseLotto(view.getPurchaseCost());
        view.println(lottoGroup.getStatus());

        winningLotto = getWinningLotto(view.getWinningNumbers());
        bonusNumber =  getBonusNumber(view.getBonusNumber());
        LottoRankGroup lottoRankGroup = LottoRankGroup.of(lottoGroup, winningLotto, bonusNumber);

        view.println(lottoRankGroup.getRankInstructions());
    }

    LottoGroup purchaseLotto(String input) {
        while (true) {
            try {
                return lottoGroup = LottoGroup.of(input);
            } catch (IllegalArgumentException e) {
                view.println("[ERROR] " + e.getMessage());
                input = view.getPurchaseCost();
            }
        }
    }


    Lotto getWinningLotto(String input) {
        while (true) {
            try {
                return winningLotto = Lotto.of(input);
            } catch (IllegalArgumentException e) {
                view.println("[ERROR] " + e.getMessage());
                input = view.getWinningNumbers();
            }
        }
    }

    Integer getBonusNumber(String input) {
        while (true) {
            try {
                winningLotto.validateBonusNumber(bonusNumber = Integer.parseInt(input));
                return bonusNumber;
            } catch (IllegalArgumentException e) {
                view.println("[ERROR] " + e.getMessage());
                input = view.getBonusNumber();
            }
        }
    }
}
