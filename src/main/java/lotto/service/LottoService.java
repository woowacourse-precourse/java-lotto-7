package lotto.service;

import lotto.domain.Lotto;
import lotto.domain.LottoResult;
import lotto.domain.User;
import lotto.util.LottoNumberParser;
import lotto.view.InputView;
import lotto.view.OutputView;

public class LottoService {

    private final InputView inputView;
    private final OutputView outputView;

    public LottoService(InputView inputView, OutputView outputView){
        this.inputView = inputView;
        this.outputView = outputView;
    }

    /**
     * 당첨 번호 입력하면 구분자를 기준으로 Lotto 클래스에 저장
     * @return 당첨 번호가 저장된 Lotto 클래스
     */
    public Lotto winningLottoNumbers() {
        try{
            return new Lotto(LottoNumberParser.parseLottoNumbers(inputView.inputWinningNumbers()));
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return winningLottoNumbers();
        }
    }

    /**
     * 당청 번호에 보너스 번호를 추가해주는 메서드
     * @param lotto 당첨 번호가 저장된 Lotto 클래스
     * @return 당첨 번호와 보너스 번호가 저장된 클래스
     */
    public Lotto bonusLottoNumbers(Lotto lotto) {
        try{
            lotto.addBonusNumber(inputView.inputBonusNumber());
            return lotto;
        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
            return bonusLottoNumbers(lotto);
        }
    }

    /**
     * 당첨 결과 계산 및 출력
     * @param user 구매한 로또 번호가 저장된 클래스
     * @param lotto 당첨 번호
     */
    public void winningResult(User user, Lotto lotto) {
        LottoResult lottoResult = new LottoResult(user.getPurchaseLottos(), lotto);
        outputView.lottoResultView(lottoResult, user.getPurchaseAmount());
    }
}
