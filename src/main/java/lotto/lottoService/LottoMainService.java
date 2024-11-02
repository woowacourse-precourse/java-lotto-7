package lotto.lottoService;

import java.util.stream.Collectors;
import lotto.lottoModel.LottoDAO;
import lotto.lottoModel.*;
import lotto.lottoView.LottoPrize;
import lotto.Utility.LottoNumberGenerator;

import java.util.*;

public class LottoMainService {

    private LottoDAO lottoDAO;
    private StatisticsLottoDAO statisticsDAO;

    public LottoMainService() {
        this.lottoDAO = new LottoDAO();
        this.statisticsDAO = new StatisticsLottoDAO();
    }

    public void buyLotto(long calcCost) {
        long numberOfBuy = calcCost / 1000;

        for (int i = 0; i < numberOfBuy; i++) {
            Lotto lotto = new Lotto(LottoNumberGenerator.generateLottoNumbers());
            lottoDAO.save(lotto);
        }
    }

    public List<LottoDTO> getAllLottosAsDTO() {
        List<Lotto> allLottos = lottoDAO.getAll();
        return allLottos.stream()
                .map(lotto -> new LottoDTO(lotto.getNumbers()))
                .collect(Collectors.toList());
    }

    // 당첨 번호 저장
    public void saveHitLotto(String hitLottoInput, String bonusNumberInput) {
        List<Integer> hitNumbers = Arrays.stream(hitLottoInput.split(","))
                .map(Integer::parseInt)
                .toList();
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        HitLotto.getInstance(hitNumbers, bonusNumber);
    }

    public HitLottoDTO getAllHitLottosAsDTO() {
        HitLotto hitLotto = HitLotto.getInstance(null, 0);  // 이미 초기화된 싱글톤 인스턴스를 가져옴
        return new HitLottoDTO(hitLotto.getAllHitNumbers());
        }

    // 로또 번호와 당첨 번호 비교 및 통계 저장
    public void retainLotto(List<LottoDTO> allLottos, List<Integer> hitLottos) {
        for (LottoDTO lotto : allLottos) {
            Set<Integer> lottoNumber = new HashSet<>(lotto.getNumbers());
            Set<Integer> hitLottoNumber = new HashSet<>(hitLottos);
            lottoNumber.retainAll(hitLottoNumber); // 두 세트의 공통 원소만 뽑아서 합친 세트
            saveLottoStatistics(lottoNumber);
        }
    }

    public StatisticsLottoDTO getAllStatisticsAsDTO() {
        StatisticsLottoDTO stats = statisticsDAO.getStatisticsAsDTO();  // 이미 초기화된 싱글톤 인스턴스를 가져옴
        return stats;
    }

    // 통계 저장
    public void saveLottoStatistics(Set<Integer> lottoNumber) {
        int hitSize = lottoNumber.size();
        HitLotto hitLotto = HitLotto.getInstance(null, 0);

        // 3~6까지 맞춘 횟수 빈도 추가
        if (hitSize >= 3 && hitSize <= 6) {
            statisticsDAO.updateSizeFrequency(hitSize);
        }

        // 5일 때 특정 값이 있는지 확인하고 있으면 추가
        if (hitSize == 5 && lottoNumber.contains(hitLotto.getBonusNumber())) {
            statisticsDAO.addSpecificValue();
        }
    }

    // 상금 합계 계산
    public long sumPrize(StatisticsLottoDTO stats) {
        long sumPrize = 0;
        for (int i = 3; i <= 6; i++) {
            if (i == 5) {
                sumPrize += LottoPrize.getPrize(i, false) * (stats.getHitNumberValue(i) - stats.getBonusNumberFrequency());
                sumPrize += LottoPrize.getPrize(i, true) * stats.getBonusNumberFrequency();
            }
            sumPrize += LottoPrize.getPrize(i, false) * stats.getHitNumberValue(i);
        }
        return sumPrize;
    }

}
