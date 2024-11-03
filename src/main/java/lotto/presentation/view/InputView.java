package lotto.presentation.view;

import java.util.List;

public class InputView {
    // todo: input 메서드 반복입력 처리 받기
//        boolean validInput = false;
//        while (!validInput) {
//            try {
//                inputMethod();
//            } catch (NumberFormatException e) {
//                System.out.println("[ERROR] 숫자 형식이 잘못되었습니다. 다시 입력하세요.");
//            } catch (IllegalArgumentException e) {
//                System.err.println(e.getMessage());
//            }
//        }
    public int getValidPurchaseAmount() {
        // todo: 구입금액 입력
        // todo: 구입금액 유효성검사
        return 0;
    }

    public List<Integer> getValidWinningNumbers() {
        // todo: 당첨번호 입력
        // todo: 당첨번호 유효성 검사
        return null;
    }

    public int getValidBonusNumber() {
        // todo: 보너스번호 입력
        // todo: 보너스번호 유효성 검사
        return 0;
    }
}
