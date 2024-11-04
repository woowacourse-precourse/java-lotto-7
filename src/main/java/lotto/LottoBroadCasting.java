package lotto;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//todo : 입력 중에 구분자가 없는 경우나 , 가 아닌 다른 문자가 들어오는 경우에 대한 예외처리가 필요하다.

public class LottoBroadCasting {

    public void run() {
        Integer lottoPurchaseAmount = inputPurchaseAmount();
        List<Lotto> lottos = InputTotalLottoNumbers(lottoPurchaseAmount);
        List<Integer> lottoWinningNumbers = InputWinningNumbers();
        Integer lottoBonusNumber = InputBonusNumber();
        LottoResultChecking lottoResultChecking = new LottoResultChecking(lottos, lottoWinningNumbers, lottoBonusNumber, lottoPurchaseAmount);
        lottoResultChecking.checkLottos();
    }

    private Integer inputPurchaseAmount() {
        System.out.println("구입금액을 입력해 주세요.");
        try {
            Integer purchaseAmount = Integer.parseInt(Console.readLine());
            Validate validate = new Validate();
            validate.validatePurchaseAmount(purchaseAmount);
            return purchaseAmount;
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 숫자만 입력 가능합니다.");
            return inputPurchaseAmount();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return inputPurchaseAmount();
        }
    }

    private List<Lotto> InputTotalLottoNumbers(Integer purchaseAmount) {
        Integer lottoCount = purchaseAmount / 1000;
        System.out.println(lottoCount + "개를 구매했습니다.");
        List<Lotto> lottos = new ArrayList<>();
        for (int i = 0; i < lottoCount; i++) {
            Lotto lotto = InputEachLottoNumbers();
            lottos.add(lotto);
        }
        return lottos;
    }

    private Lotto InputEachLottoNumbers() {
        try {
            List<Integer> eachLottoNumbers = Randoms.pickUniqueNumbersInRange(1, 45, 6);
            List<Integer> inputNumbers = new ArrayList<>(eachLottoNumbers); // 테스트 때문에 어쩔 수 없이 변환
            Collections.sort(inputNumbers);
            System.out.println(inputNumbers);
            return new Lotto(inputNumbers);
        } catch (IllegalArgumentException e) {
            return InputEachLottoNumbers();
        }
    }

    private List<Integer> InputWinningNumbers() {
        System.out.println("당첨 번호를 입력해 주세요.");
        try {
            String inputWinningNumbers = Console.readLine();
            String[] inputNumbers = inputWinningNumbers.split(",");
            Validate validate = new Validate();
            validate.validateWinningNumbers(inputNumbers);
            List<Integer> winningNumbers = new ArrayList<>();
            for (String inputNumber : inputNumbers) {
                winningNumbers.add(Integer.parseInt(inputNumber));
            }
            return winningNumbers;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return InputWinningNumbers();
        }
    }

    private Integer InputBonusNumber() {
        System.out.println("보너스 번호를 입력해 주세요.");
        try {
            Integer bonusNumber = Integer.parseInt(Console.readLine());
            Validate validate = new Validate();
            validate.validateNumber(bonusNumber);
            return bonusNumber;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return InputBonusNumber();
        }
    }
}