package lotto.lottoService;

import camp.nextstep.edu.missionutils.Randoms;
import lotto.lottoModel.LottoDAO;
import lotto.lottoModel.*;
import lotto.LottoPrize;

import java.util.*;

public class LottoMainService {
    private static final int START_NUMBER = 1;
    private static final int END_NUMBER = 45;
    private static final int LIST_NUMBER = 6;
    private static final int ZERO = 0;
    private static final int THREE = 3;
    private static final int FIVE = 5;
    private static final int SIX = 6;
    private static final int ONE_THOUSAND = 1000;

    private LottoDAO lottoDAO; //생성된 로또 번호
    private StatisticsLottoDAO statisticsDAO; //당첨 통계

    public LottoMainService() {
        this.lottoDAO = new LottoDAO();
        this.statisticsDAO = new StatisticsLottoDAO();
    }

    //로또 구매 횟수 만큼 객체 생성
    public void buyLotto(String cost) {
        long calcCost = Long.parseLong(cost);
        long numberOfBuy = calcCost / ONE_THOUSAND;

        for (int i = ZERO; i < numberOfBuy; i++) {
            List<Integer> numbers = Randoms.pickUniqueNumbersInRange(START_NUMBER, END_NUMBER, LIST_NUMBER);
            Lotto lotto = new Lotto(numbers);
            lottoDAO.save(lotto); //생성된 로또 번호 저장
        }
    }

    //로또 객체 반환
    public List<LottoDTO> getAllLottosAsDTO() {
        List<Lotto> allLottos = lottoDAO.getAll(); //모든 생성된 로또 번호
        List<LottoDTO> list = new ArrayList<>();
        for (Lotto lotto : allLottos) {
            LottoDTO lottoDTO = new LottoDTO(lotto.getNumbers());
            list.add(lottoDTO);
        }
        return list;
    }

    // 당첨 번호 리스트 변환
    public List<Integer> covertHitLotto(String hitLottoInput) {
        List<Integer> hitNumbers = Arrays.stream(hitLottoInput.split(","))
                .map(Integer::parseInt)
                .toList();
        return hitNumbers;
    }

    // 당첨 번호 저장
    public void saveHitLotto(List<Integer> hitNumbers, String bonusNumberInput) {
        int bonusNumber = Integer.parseInt(bonusNumberInput);
        HitLotto.getInstance(hitNumbers, bonusNumber); //List, Int로 객체 저장
    }

    //당첨 번호 반환
    public HitLottoDTO getAllHitLottosAsDTO() {
        HitLotto hitLotto = HitLotto.getInstance(null, ZERO);  // 사용자가 입력한 당첨번호
        return new HitLottoDTO(hitLotto.getAllHitNumbers());
    }

    // 로또 번호와 당첨 번호 비교 및 통계 갱신
    public void retainLotto(List<LottoDTO> allLottos, List<Integer> hitLottos) {
        for (LottoDTO lotto : allLottos) {
            Set<Integer> lottoNumber = new HashSet<>(lotto.getNumbers());
            Set<Integer> hitLottoNumber = new HashSet<>(hitLottos);
            lottoNumber.retainAll(hitLottoNumber); // 두 세트의 공통 원소만 뽑아서 합친 세트
            saveLottoStatistics(lottoNumber); // 통계 갱신 메서드
        }
    }

    // 통계 갱신 메서드
    private void saveLottoStatistics(Set<Integer> lottoNumber) {
        int hitSize = lottoNumber.size(); // 당첨 번호 맞춘 개수
        HitLotto hitLotto = HitLotto.getInstance(null, ZERO); // 사용자가 입력한 당첨번호

        if (hitSize >= THREE && hitSize <= SIX) { // 3~6까지 맞춘 횟수 빈도 추가
            statisticsDAO.updateSizeFrequency(hitSize);
        }

        if (hitSize == FIVE && lottoNumber.contains(hitLotto.getBonusNumber())) { // 5일 때 특정 값이 있는지 확인하고 있으면 추가
            statisticsDAO.addSpecificValue();
        }
    }

    //당첨 통계 반환
    public StatisticsLottoDTO getAllStatisticsAsDTO() {
        StatisticsLottoDTO stats = statisticsDAO.getStatisticsAsDTO();  // 전체 당첨 횟수 통계Hash,보너스 당첨 횟수Int
        return stats;
    }

    // 상금 합계 계산 후 반환
    public double sumPrize(StatisticsLottoDTO stats, String cost) {
        long sumPrize = ZERO;
        for (int i = THREE; i <= SIX; i++) {
            if (i == FIVE) {
                sumPrize +=
                        LottoPrize.getPrize(i, false) * (stats.getHitNumberValue(i) - stats.getBonusNumberFrequency());
                sumPrize += LottoPrize.getPrize(i, true) * stats.getBonusNumberFrequency();
            }
            sumPrize += LottoPrize.getPrize(i, false) * stats.getHitNumberValue(i);
        }
        return (double) sumPrize / Integer.parseInt(cost);
    }

}
