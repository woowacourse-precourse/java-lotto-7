package lotto.Service;

public class ValidService {
    public void validMoney(String money) {
        isNull(money);
        isNum(money);
        is1000s(money);
        isBig(money);
    }

    private void isNull(String money) {
        if (money == null || money.isEmpty()) {
            throw new IllegalArgumentException("[ERROR] 입력에 빈 값이 들어갈 수는 없습니다.");
        }
    }

    private void isNum(String money) {
        boolean notNumber = !money.matches("\\d+");
        if (notNumber) {
            throw new IllegalArgumentException("[ERROR] 입력에는 숫자만 들어가야 합니다");
        }
    }

    private void is1000s(String money) {
        boolean not1000s = (Integer.parseInt(money) % 1000 != 0 && Integer.parseInt(money)!=0);
        if (not1000s) {
            throw new IllegalArgumentException("[ERROR] 입력에는 1000원 단위에 금액만 들어가야합니다.");
        }
    }

    private void isBig(String money) {
        if (money.length() >= 9) {
            throw new IllegalArgumentException("[ERROR] 1억 이상 로또를 구매하는것은 중독입니다");
        }
    }


}