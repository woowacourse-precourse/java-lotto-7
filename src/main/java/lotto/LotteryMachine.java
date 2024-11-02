package lotto;

public class LotteryMachine {
    private int drawAmount;

    private void draw(int purchaseAmount) {
        drawAmount = purchaseAmount / 1000;
        // 추후 1,000원 단위 조건 체크 필요.
    }


}
