package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import lotto.domain.Lotto;
import lotto.model.LottoModel;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoController {
    LottoModel lottoModel;
    InputView inputView;
    OutputView outputView;

    private int payment;
    private int issuelottoNumber;

    public LottoController() {
        lottoModel = new LottoModel();
        inputView = new InputView();
        outputView = new OutputView();
    }

    public void tryLotto() {
        // 지불 금액 입력 받고 int로 형변환
        outputView.askPayment();
        payment = inputView.inputPayment();

        // 구입금액을 1000으로 나누어 구입할 로또 갯수 반환
        issuelottoNumber = lottoModel.countIssueLottoNumber(payment);
        // 구입갯수만큼 로또를 발행해 리스트로 저장
        List<Lotto> issuedLottos = lottoModel.issueLottos(issuelottoNumber);
        // 구입 갯수 출력
        outputView.alertBuyingNumber(issuelottoNumber);
        // 로또들의 각 로또 번호 정렬
        List<List<Integer>> sortedNumbers = lottoModel.sortLottos(issuedLottos);


        // 각 로또들을 출력하는 기능
        outputView.printSortedNumbers(sortedNumbers);

        // 당첨 번호 입력받기
        outputView.askWinningNumbers();
        String inputWinningNumber = inputView.inputWinningNumbersString();

        // 당첨 번호 6개 저장하기
        List<Integer> winningNumbers = inputView.winningNumbers(inputWinningNumber);
        // 보너스 번호 입력 받기
        outputView.askBonusNumber();
        int bonusNumber = inputView.inputBonusNumberString();

        // 로또별 당첨 내역 출력
        outputView.alertStartStat();

        int[] countRank = lottoModel.countRank(issuedLottos, winningNumbers, bonusNumber);
        outputView.printLottoResults(countRank);

        // 수익률 계산, 출력
        double earningRate = lottoModel.calculateEarningRate(countRank);
        outputView.alertEarningRate(earningRate);

    }
}
