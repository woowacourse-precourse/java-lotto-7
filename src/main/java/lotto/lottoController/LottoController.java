package lotto.lottoController;

import static lotto.lottoModel.HitLotto.getInstance;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import lotto.lottoModel.HitLotto;
import lotto.lottoModel.HitLottoDAO;
import lotto.lottoModel.HitLottoDTO;
import lotto.lottoModel.LottoDAO;
import lotto.lottoModel.LottoDTO;
import lotto.lottoModel.Lotto;
import lotto.lottoModel.StatisticsLottoDAO;
import lotto.lottoModel.StatisticsLottoDTO;
import lotto.lottoModel.StatisticsLotto;
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
    private HitLottoDTO hitLottoDTO;
    private StatisticsLottoDAO statisticsDAO;
    private StatisticsLottoDTO statisticsDTO;

    public LottoController() {
        this.lottoDAO = new LottoDAO();
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.hitLottoDAO = new HitLottoDAO();
        this.statisticsDAO = new StatisticsLottoDAO();

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

        String hitLottoInput = inputView.PrintLottoInputMsg();
        String bonusNumberInput = inputView.PrintBonusLottoInputMsg();
        //여기에 유효성 검증

        saveHitLotto(hitLottoInput, bonusNumberInput);

        HitLottoDAO hitLottoDAO = new HitLottoDAO();
        HitLottoDTO dto = hitLottoDAO.getAsDTO();

        retainLotto(allLottos, dto.getAllHitNumbers());

        StatisticsLottoDTO stats = statisticsDAO.getStatisticsAsDTO();
        outputView.statisticStart(stats);


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
        getInstance(hitNumbers,bonusNumber);


    }

    public void retainLotto(List<Lotto> alllottos, List<Integer> hitLottos) {
        for (Lotto lotto: alllottos ) {
            Set<Integer> lottoNumber = new HashSet<>(lotto.getNumbers());
            Set<Integer> hitLottoNumber = new HashSet<>(hitLottos);
            lottoNumber.retainAll(hitLottoNumber); //두 세트의 공통 원소만 뽑아서 합친 세트
            saveLottoStatistics(lottoNumber);
        }

    }

    public void saveLottoStatistics(Set<Integer> lottoNumber) {
        int hitSize = lottoNumber.size();
        HitLotto hitLotto = HitLotto.getInstance(null,0);
        //3~6까지 맞춘 횟수 빈도 추가
        if (hitSize >= 3 && hitSize <= 6) {
            statisticsDAO.updateSizeFrequency(hitSize);
        }

        // 5일 때 특정 값이 있는지 확인하고 있으면 추가
        if (hitSize == 5 && lottoNumber.contains(hitLotto.getBonusNumber())) {
            statisticsDAO.addSpecificValue();
        }
    }


}
