package lotto.domain.lotto;


import java.util.List;

public class WinningStatisticsResponseDto {
    int threeStrike = 0;
    int fourStrike = 0;
    int fiveStrike = 0;
    int fiveStrikeAndBall = 0;
    int sixStrike = 0;
    double rateOfReturn = 0.0;

    public void calculateWinningStatistics(List<Lotto> lottoes, LottoDto lottoDto) {
        for (Lotto lotto : lottoes) {
            int winningNumberCnt = 0;
            int bonusNumberCnt = 0;
            for (int num : lotto.getNumbers()) {
                if (lottoDto.getWinningNumbers().contains(num)) {
                    winningNumberCnt++;
                } else if (lottoDto.getBonusNumber() == num) {

                    bonusNumberCnt++;
                }
            }

            if (winningNumberCnt == 3) {
                threeStrike++;
            } else if (winningNumberCnt == 4) {
                fourStrike++;
            } else if (winningNumberCnt == 5 && bonusNumberCnt == 0) {
                fiveStrike++;

            } else if (winningNumberCnt == 5 && bonusNumberCnt == 1) {
                fiveStrikeAndBall++;
            } else if (winningNumberCnt == 6) {
                sixStrike++;
            }
        }
        long sum = 0;
        sum += threeStrike * LottoConstant.THREE_STRIKE_PRICE;
        sum += fourStrike * LottoConstant.FOUR_STRIKE_PRICE;
        sum += fiveStrike * LottoConstant.FIVE_STRIKE_PRICE;
        sum += fiveStrikeAndBall * LottoConstant.FIVE_STRIKE_AND_BALL_PRICE;
        sum += sixStrike * LottoConstant.SIX_STRIKE_PRICE;
        rateOfReturn = (double) sum / (lottoes.size() * LottoConstant.LOTTO_PRICE) * 100;
        rateOfReturn = Math.round(rateOfReturn * 100) / 100.0;
    }

    public int getThreeStrike() {
        return threeStrike;
    }

    public int getFourStrike() {
        return fourStrike;
    }

    public int getFiveStrike() {
        return fiveStrike;
    }

    public int getFiveStrikeAndBall() {
        return fiveStrikeAndBall;
    }

    public int getSixStrike() {
        return sixStrike;
    }

    public double getRateOfReturn() {
        return rateOfReturn;
    }
}
