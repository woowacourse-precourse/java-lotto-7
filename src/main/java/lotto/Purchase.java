package lotto;

public class Purchase {
    final int lotoPrice = 1000;
    private int money;

    public Purchase(String inputMoney) {
        try {
            Integer.parseInt(inputMoney);
        } catch (NumberFormatException e) {
            throw new NumberFormatException("[ERROR] 숫자 형식이 아닙니다.");
        }

        this.money = Integer.parseInt(inputMoney);
    }

    private boolean isMinumPrice() {
        if (money < lotoPrice) {
            return false;
        }
        return true;
    }

    private boolean isAmountValid() {
        if (money % lotoPrice != 0) {
            return false;
        }
        return true;
    }

    public int getLotoCount() {
        int lotoCount;
        // 음수 + 1000원 보다 작은 값 입력 시 오류 발생
        if (!isMinumPrice()) {
            throw new IllegalArgumentException("[ERROR] 1000원 이하의 금액 입니다.");
            // 1,000원 이하의 단위 처림
        }
        if (!isAmountValid()) {
            throw new IllegalArgumentException("[ERROR] 1000원 단위의 금액을 입력하세요.");
        }

        lotoCount = money / lotoPrice;
        System.out.println(lotoCount + "개를 구입했습니다.");
        return lotoCount;
    }

}
