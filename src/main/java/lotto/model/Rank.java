package lotto.model;

import lotto.config.LottoGameConfig;

public enum Rank implements RankInformation {

    FIRST_PLACE(1, 6) {
        @Override
        public boolean support(int count, boolean contain) {
            return count == FIRST_PLACE.compareCount;
        }

        @Override
        public String getResultForDisplay(int comparedResult) {
            return FIRST_PLACE.compareCount + "개 일치, 보너스 볼 일치 ("
                    + String.format("%,d", LottoGameConfig.FIRST_PLACE_AMOUNT)
                    + "원) - " + comparedResult + "개";
        }
    },
    SECOND_PLACE(2, 5) {
        @Override
        public boolean support(int count, boolean contain) {
            return count == SECOND_PLACE.compareCount && contain;
        }

        @Override
        public String getResultForDisplay(int comparedResult) {
            return SECOND_PLACE.compareCount + "개 일치 ("
                    + String.format("%,d", LottoGameConfig.SECOND_PLACE_AMOUNT)
                    + "원) - " + comparedResult + "개\n";
        }
    },
    THIRD_PLACE(3, 5) {
        @Override
        public boolean support(int count, boolean contain) {
            return count == THIRD_PLACE.compareCount && !contain;
        }

        @Override
        public String getResultForDisplay(int comparedResult) {
            return THIRD_PLACE.compareCount + "개 일치 ("
                    + String.format("%,d", LottoGameConfig.THIRD_PLACE_AMOUNT)
                    + "원) - " + comparedResult + "개\n";
        }
    },
    FOURTH_PLACE(4, 4) {
        @Override
        public boolean support(int count, boolean contain) {
            return count == FOURTH_PLACE.compareCount;
        }

        @Override
        public String getResultForDisplay(int comparedResult) {
            return FOURTH_PLACE.compareCount + "개 일치 ("
                    + String.format("%,d", LottoGameConfig.FOURTH_PLACE_AMOUNT)
                    + "원) - " + comparedResult + "개\n";
        }
    },
    FIFTH_PLACE(5, 3) {
        @Override
        public boolean support(int count, boolean contain) {
            return count == FIFTH_PLACE.compareCount;
        }

        @Override
        public String getResultForDisplay(int comparedResult) {
            return FIFTH_PLACE.compareCount + "개 일치 ("
                    + String.format("%,d", LottoGameConfig.FIFTH_PLACE_AMOUNT)
                    + "원) - " + comparedResult + "개\n";
        }
    }
    ;

    private final int rank;
    private final int compareCount;

    Rank(int rank, int compareCount) {
        this.rank = rank;
        this.compareCount = compareCount;
    }



    public int getRank() {
        return rank;
    }
}
