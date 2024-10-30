package lotto.controller;

public class LottoController {

    // 로또 내부 메인 실행 흐름
    public static void startLotto(){

        // 1. 로또 구입 금액 입력 및 유효성 검증
        getValidatedPurchaseAmountFromUser();

        // 2. 로또 구입 금액에 따라 새로운 로또 번호를 생성
        generateNewLottoNumbers();

        // 3. 로또 당첨 번호 입력 및 유효성 검증
        getValidatedWinningNumbersFromUser();

        // 4. 로또 당첨 보너스 번호 입력 및 유효성 검증
        getValidatedBonusNumberFromUser();

        // 5. 최종 당첨 확인
        checkTotalWinningStatus();

        // 6. 최종 당첨 통계 출력
        displayTotalWinningStatistics();
    }

    static void getValidatedPurchaseAmountFromUser() {
        // 로또 구입 금액 입력 및 유효성 검증 코드
    }

    static void generateNewLottoNumbers() {
        // 로또 번호 생성 코드
    }

    static void getValidatedWinningNumbersFromUser() {
        // 당첨 번호 입력 및 유효성 검증 코드
    }

    static void getValidatedBonusNumberFromUser() {
        // 보너스 번호 입력 및 유효성 검증 코드
    }

    static void checkTotalWinningStatus() {
        // 당첨 확인 코드
    }

    static void displayTotalWinningStatistics() {
        // 당첨 통계 출력 코드
    }
}
