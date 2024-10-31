package lotto.lottoController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import lotto.lottoModel.HitLotto;
import lotto.lottoModel.HitLottoDAO;
import lotto.lottoModel.LottoDAO;
import lotto.lottoModel.LottoDTO;
import lotto.lottoModel.Lotto;
import lotto.lottoView.InputView;
import lotto.lottoView.OutputView;

import lotto.Utility.LottoNumberGenerator;

public class LottoController {
    private LottoDAO lottoDAO;
    private LottoDTO lottoDTO;
    private InputView inputView;
    private OutputView outputView;
    private LottoNumberGenerator lottoNumberGenerator;
    private HitLottoDAO hitLottoDAO;

    public LottoController() {
        this.lottoDAO = new LottoDAO();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.hitLottoDAO = new HitLottoDAO();

    }

    public void run() {
        String Cost = inputView.PrintStartMsg();
        //여기에 유효성 검증

        buyLotto(Cost);
        List<Lotto> allLottos = lottoDAO.getAll();

        for (Lotto lotto : allLottos) { //todo:추후 메서드로 빼낼것
            LottoDTO dto = new LottoDTO(lotto.getNumbers());
            System.out.println(dto.getNumbers()); //todo 아웃뷰?
        }

        String hitLottoInput= inputView.PrintLottoInputMsg();
        String bonusNumberInput = inputView.PrintBonusLottoInputMsg();
        //여기에 유효성 검증



    }


    public void buyLotto(String cost) {
        long calcCost = Long.parseLong(cost);
        long numberOfBuy = calcCost/1000;
        outputView.howManyBuy(numberOfBuy);

        for (int i=0;i<numberOfBuy;i++){
            Lotto lotto = new Lotto(LottoNumberGenerator.generateLottoNumbers());
            lottoDAO.save(lotto);
        }

    }

    public void saveHitLotto(String hitLottoInput,String bonusNumberInput) {
        List<Integer> hitNumbers = Arrays.stream(hitLottoInput.split(","))
                .map(Integer::parseInt)
                .toList();

        int bonusNumber = Integer.parseInt(bonusNumberInput);
        HitLotto hitLotto = new HitLotto(hitNumbers,bonusNumber);

        hitLottoDAO.save(hitLotto);

    }

}
