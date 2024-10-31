package lotto;

import lotto.io.InputView;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // todo : 입력 기능 모듈 구현

        InputView inputView = new InputView();

        int cost = inputView.getCost();
        List<Integer> winningNums = inputView.getWinningNums();
        int bonusNum = inputView.getBonusNum();

    }
}
