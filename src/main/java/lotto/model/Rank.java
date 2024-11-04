package lotto.model;

import lotto.config.LottoGameConfig;

public enum Rank implements RankInformation {

    FIRST_PLACE(1, 6, LottoGameConfig.FIRST_PLACE_AMOUNT) {

        @Override
        public boolean support(int count, boolean contain) {
            return count == FIRST_PLACE.compareCount;
        }

        @Override
        public String getResultForDisplay(int comparedResult) {
            return FIRST_PLACE.compareCount + "개 일치 ("
                    + String.format("%,d", FIRST_PLACE.winnerAmount)
                    + "원) - " + comparedResult + "개";
        }

    },
    SECOND_PLACE(2, 5, LottoGameConfig.SECOND_PLACE_AMOUNT) {

        @Override
        public boolean support(int count, boolean contain) {
            return count == SECOND_PLACE.compareCount && contain;
        }

        @Override
        public String getResultForDisplay(int comparedResult) {
            return SECOND_PLACE.compareCount + "개 일치, 보너스 볼 일치 ("
                    + String.format("%,d", SECOND_PLACE.winnerAmount)
                    + "원) - " + comparedResult + "개\n";
        }

    },
    THIRD_PLACE(3, 5, LottoGameConfig.THIRD_PLACE_AMOUNT) {

        @Override
        public boolean support(int count, boolean contain) {
            return count == THIRD_PLACE.compareCount && !contain;
        }

        @Override
        public String getResultForDisplay(int comparedResult) {
            return THIRD_PLACE.compareCount + "개 일치 ("
                    + String.format("%,d", THIRD_PLACE.winnerAmount)
                    + "원) - " + comparedResult + "개\n";
        }

    },
    FOURTH_PLACE(4, 4, LottoGameConfig.FOURTH_PLACE_AMOUNT) {

        @Override
        public boolean support(int count, boolean contain) {
            return count == FOURTH_PLACE.compareCount;
        }

        @Override
        public String getResultForDisplay(int comparedResult) {
            return FOURTH_PLACE.compareCount + "개 일치 ("
                    + String.format("%,d", FOURTH_PLACE.winnerAmount)
                    + "원) - " + comparedResult + "개\n";
        }

    },
    FIFTH_PLACE(5, 3, LottoGameConfig.FIFTH_PLACE_AMOUNT) {

        @Override
        public boolean support(int count, boolean contain) {
            return count == FIFTH_PLACE.compareCount;
        }

        @Override
        public String getResultForDisplay(int comparedResult) {
            return FIFTH_PLACE.compareCount + "개 일치 ("
                    + String.format("%,d", FIFTH_PLACE.winnerAmount)
                    + "원) - " + comparedResult + "개\n";
        }

    }
    ;

    private final int rank;
    private final int compareCount;
    private final int winnerAmount;

    Rank(int rank, int compareCount, int winnerAmount) {
        this.rank = rank;
        this.compareCount = compareCount;
        this.winnerAmount = winnerAmount;
    }

    public int getRank() {
        return rank;
    }

    public int getWinnerAmount() {
        return winnerAmount;
    }

}
