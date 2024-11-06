package lotto.lottoModel;

public class StatisticsLottoDAO {

    private StatisticsLotto statisticsLotto;

    public StatisticsLottoDAO() {
        this.statisticsLotto = new StatisticsLotto();
    }

    // 맞춘 개수의 크기를 업데이트
    public void updateSizeFrequency(int size) {
        statisticsLotto.updateFrequency(size);
    }

    // 보너스가 포함된 경우 추가
    public void addSpecificValue() {
        statisticsLotto.addSpecificValue();
    }

    // DTO로 변환하여 통계 정보 반환
    public StatisticsLottoDTO getStatisticsAsDTO() {
        return new StatisticsLottoDTO(statisticsLotto.getHitNumberFrequency(),
                statisticsLotto.getBonusNumberFrequency());
    }
}