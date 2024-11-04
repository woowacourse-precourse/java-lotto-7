package lotto.model;

public class LottoPurchase {
    private final int money;
    private final int lottoAmount;

    public LottoPurchase(String input) {
        // 구입 금액에 따른 발행할 로또 개수 설정
        isInputNumeric(input);
        int inputToInt = Integer.parseInt(input);
        this.money = validateAmount(inputToInt);
        this.lottoAmount = calculateLottoAmount();
    }

    public int getLottoAmount() {
        return this.lottoAmount;
    }

    public int getMoney() {
        return this.money;
    }

    private int calculateLottoAmount() {
        return (this.money / 1000);
    }

    private void isInputNumeric(String input) {
        if (!isNumeric(input)) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력해야 합니다.");
        }
    }

    private boolean isNumeric(String input) {
        return input.matches("-?\\d+(\\.\\d+)?");
    }

    private int validateAmount(int amount) {
        if (amount < 1000) {
            throw new IllegalArgumentException("[ERROR] 최소 1000원 이상 입력해야 합니다.");
        }
        if (amount % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위로 입력해야 합니다.");
        }
        return amount;
    }
}
