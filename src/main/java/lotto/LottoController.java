package lotto;

public class LottoController {
    public int purchaseAmount;
    public int lottoCount;
    private static final LottoInput LOTTO_INPUT = new LottoInput();

    public void play() {
        this.purchaseAmount = getAmount();
        this.lottoCount = purchaseAmount / 1000;
    }

    // 구입 금액 검증 후 옳바른 구입 금액까지 루프
    private static int getAmount() {
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
}
