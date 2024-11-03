package lotto;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        LottoPurchase lottoPurchase = new LottoPurchase();
        LottoNumberGenerator lottoNumberGenerator = new LottoNumberGenerator();
        InputNumbers inputNumbers = new InputNumbers();

        //1. 구입 금액 입력, 로또 구입 개수
        int lottoCount = lottoPurchase.inputPurchaseAmount();

        //2. 개수만큼 로또 번호 생성
        List<List<Integer>> lottos = lottoNumberGenerator.generateLottoNumbers(lottoCount);

        //3. 생성된 로또 번호 출력
        lottoNumberGenerator.printLottos(lottos);

        //4. 당첨 번호 6개 입력받기
        Lotto lottoNumbers = inputNumbers.InputLottoNumbers();
    }
}