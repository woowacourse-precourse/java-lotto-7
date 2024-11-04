package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        InputHandler inputHandler = new InputHandler();

        // 당첨 번호 입력 받기
        List<Integer> winningNumbers = inputHandler.getWinningNumbers();

        // 보너스 번호 입력 받기 (당첨 번호를 인자로 전달)
        int bonusNumber = inputHandler.getBonusNumber(winningNumbers);

        // 출력 또는 다른 로직 추가
        System.out.println("당첨 번호: " + winningNumbers);
        System.out.println("보너스 번호: " + bonusNumber);
    }
}