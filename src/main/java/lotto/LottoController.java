package lotto;

public class LottoController {
    private static final LottoInput LOTTO_INPUT = new LottoInput();
    private static final LottoProcessor LOTTO_PROCESSOR = new LottoProcessor();
    private static final LottoOutput LOTTO_OUTPUT = new LottoOutput();

    public void play() {
        int purchaseAmount = inputAmount();
        int lottoCount = purchaseAmount / 1000;

        System.out.println(lottoCount + "개를 구매했습니다.");
        LOTTO_PROCESSOR.createLotto(lottoCount);
        inputWinningNumbers();
        inputBonusNumber();
        LOTTO_PROCESSOR.matchLotto();
        LOTTO_OUTPUT.showWinningLotto(LOTTO_PROCESSOR.getRewardCounts());
        LOTTO_OUTPUT.showReturnPrice(LOTTO_PROCESSOR.calculateReturnPrice(purchaseAmount));
    }

    // 구입 금액 검증 후 옳바른 구입 금액까지 루프
    private static int inputAmount() {
        while (true) {
            try {
                return validatePurchaseAmount(LOTTO_INPUT.getPurchaseAmount());
            }catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    // 구입 금액 검증
    private static int validatePurchaseAmount(String purchaseAmount) {
        int amount = Integer.parseInt(purchaseAmount);
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("구입금액은 1000의 배수여야 합니다.");
        }
        // 검증 코드 추가
        return amount;
    }

    // 당첨 번호 검증 후 올바른 당첨 번호까지 루프
    private static void inputWinningNumbers() {
        while (true) {
            try {
                LOTTO_PROCESSOR.setWinningNumbers(LOTTO_INPUT.getWinningNumbers().split(","));
                return;
            }catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }

    // 보너스 번호 검증 후 올바른 번호까지 루프
    private static void inputBonusNumber() {
        while (true) {
            try {
                LOTTO_PROCESSOR.setBonusNumber(Integer.parseInt(LOTTO_INPUT.getBonusNumber()));
                return;
            }catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
    }
}
