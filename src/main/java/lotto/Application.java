package lotto;

import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // STEP1. 로또 구입 금액 입력
        InputMoney userInput = new InputMoney();
        userInput.inputMoneyToBuyLotto();

        // STEP2. 로또 구입 수량 출력
        OutputPurchaseNum userPurchaseNum = new OutputPurchaseNum();
        userPurchaseNum.printPurchaseNumber(userInput.purchaseNumber);

        // STEP3. ArrayList 생성
        List<LottoIssuanceService> mylottoList = new ArrayList<>();

        // STEP4. 로또 발행, 출력, 객체 저장하는 반복문 구입 수량만큼 실행
        for (int i = 0; i < userInput.purchaseNumber; i++) {
            LottoIssuanceService mylotto = new LottoIssuanceService();
            mylotto.randomLottoIssue();
            mylotto.printIssuedLottoNumbers();

            // ArrayList 에 각 로또 객체 저장
            mylottoList.add(mylotto);
        }
        System.out.println();

        // STEP5. 당첨번호 입력
        List<Integer> tempLottoNumbers = new ArrayList<>();      // 임시 리스트
        InputLottoNum input = new InputLottoNum();
        tempLottoNumbers = input.inputLottoWinningNumber();     // 정수 리스트 반환
        Lotto lotto = new Lotto(tempLottoNumbers);

        lotto.checkValidRange(tempLottoNumbers);
        List<Integer> lottoNumbers = lotto.checkDuplicate(tempLottoNumbers);
        System.out.println();

        // STEP6. 보너스번호 입력
        LottoBonus bonus = new LottoBonus();
        int bonusNumber = bonus.inputBonusNum(lottoNumbers);
        System.out.println();

        // STEP7. 당첨 확인 및 출력
        ValidateWinnings checker = new ValidateWinnings(lottoNumbers, bonusNumber, userInput.purchaseNumber);
        checker.calculateResults(mylottoList);
    }
}
