package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        InputSixNumbers inputSixNumbers = new InputSixNumbers();
        InputBonusNumber inputBonusNumber = new InputBonusNumber();

        //1. 구입 금액 입력, 로또 구입 개수
        int lottoCount = lottoPurchase.inputPurchaseAmount();

        //2. 개수만큼 로또 번호 생성
        List<List<Integer>> lottos = lottoNumberGenerator.generateLottoNumbers(lottoCount);

        //3. 생성된 로또 번호 출력
        lottoNumberGenerator.printLottos(lottos);

        //4. 당첨 번호 6개 입력받기
        Lotto winningLotto = inputSixNumbers.inputLottoNumbers();
        List<Integer> lottoNumbers = winningLotto.getNumbers();

        //5. 보너스 번호 1개 입력받기
        int bonusNumber = inputBonusNumber.inputBonusNumber(lottoNumbers);
    }
}
