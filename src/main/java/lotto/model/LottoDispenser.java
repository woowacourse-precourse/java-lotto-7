package lotto.model;

public class LottoDispenser {

    public LottoDispenser() {

    }

    public void executeTransactionAndDispense(String inputMoney) {
        int money = executeTransaction(inputMoney);
    }
    
    private int executeTransaction(String inputMoney) {
        validateInput(inputMoney);
        int money = parseMoney(inputMoney);
        validateMoney(money);
        return money;
    }
        

    private void validateInput(String inputMoney) {
        if (inputMoney == null || inputMoney.trim().isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액이 입력되지 않았습니다.");
        }

        try {
            int money = Integer.parseInt(inputMoney);
            if (money <= 0) {
                throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 양수여야 합니다.");
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 로또 구입 금액은 숫자만 입력 가능합니다.");
        }
    }

    private int parseMoney(String inputMoney) {
        return Integer.parseInt(inputMoney);
    }

    private void validateMoney(int money) {
        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 구입 금액은 1,000원 단위여야 합니다.");
        }
    }

}
