package lotto.lottoController;

import java.util.ArrayList;
import java.util.List;
import lotto.lottoModel.LotteryDAO;
import lotto.lottoModel.LotteryDTO;
import lotto.lottoModel.Lotto;
import lotto.lottoView.InputView;
import lotto.lottoView.OutputView;
import lotto.Utility.LottoNumberGenerator;

public class LottoController {
    private LotteryDAO lotteryDAO;
    private LotteryDTO lotteryDTO;
    private InputView inputView;
    private OutputView outputView;
    private LottoNumberGenerator lottoNumberGenerator;

    public LottoController() {
        this.lotteryDAO = new LotteryDAO();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.lottoNumberGenerator = new LottoNumberGenerator();

    }

    public void run() {
        String cost= inputView.PrintStartMsg();
        //여기에 유효성 검증

        buyLotto(cost);
        List<Lotto> allLottos = lotteryDAO.getAll();

        for (Lotto lotto : allLottos) {
            LotteryDTO dto = new LotteryDTO(lotto.getNumbers());
            System.out.println("로또 번호 :"+dto.getNumbers());
        }



        
    }


    public void buyLotto(String cost) {
        long calcCost = Long.parseLong(cost);
        long numberOfBuy = calcCost/1000;
        for (int j=0;j<numberOfBuy;j++){
            Lotto Lotto = new Lotto(LottoNumberGenerator.generateLottoNumbers());
            lotteryDAO.save(Lotto);


        }

    }


}
