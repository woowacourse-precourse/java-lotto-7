package lotto;

public class Buy {

    public int countLotto(int money) {
        if (money < 1000) {
            throw new IllegalArgumentException("[ERROR] 로또 구매금액은 1000원 이상이어야 합니다.");
        }

        if (money % 1000 != 0) {
            throw new IllegalArgumentException("[ERROR] 로또 구매금액은 1000원 단위로 가능합니다.");
        }

        return money / 1000;
    }
}
