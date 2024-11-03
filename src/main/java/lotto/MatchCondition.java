package lotto;

public interface MatchCondition {
    Integer getNumberCount();
    Integer getPrizedAmount();
    String prizeDescription();
    Boolean hasBonusNumber();

    class FirstPrize implements MatchCondition {
        @Override
        public Integer getNumberCount() {
            return 6;
        }

        @Override
        public Integer getPrizedAmount() {
            return 2000000000;
        }

        @Override
        public String prizeDescription() {
            return String.format(
                    "%d개 일치 (2,000,000,000원)",
                    getNumberCount()
            );
        }

        @Override
        public Boolean hasBonusNumber() {
            return false;
        }
    }

    class SecondPrize implements MatchCondition {
        @Override
        public Integer getNumberCount() {
            return 5;
        }

        @Override
        public Integer getPrizedAmount() {
            return 30000000;
        }

        @Override
        public String prizeDescription() {
            return String.format(
                    "%d개 일치, 보너스 볼 일치 (30,000,000원)",
                    getNumberCount()
            );
        }

        @Override
        public Boolean hasBonusNumber() {
            return true;
        }
    }

    class ThirdPrize implements MatchCondition {
        @Override
        public Integer getNumberCount() {
            return 5;
        }

        @Override
        public Integer getPrizedAmount() {
            return 1500000;
        }

        @Override
        public String prizeDescription() {
            return String.format(
                    "%d개 일치 (1,500,000원)",
                    getNumberCount()
            );
        }

        @Override
        public Boolean hasBonusNumber() {
            return false;
        }
    }

    class FourthPrize implements MatchCondition {
        @Override
        public Integer getNumberCount() {
            return 4;
        }

        @Override
        public Integer getPrizedAmount() {
            return 50000;
        }

        @Override
        public String prizeDescription() {
            return String.format(
                    "%d개 일치 (50,000원)",
                    getNumberCount()
            );
        }

        @Override
        public Boolean hasBonusNumber() {
            return false;
        }
    }

    class FifthPrize implements MatchCondition {
        @Override
        public Integer getNumberCount() {
            return 3;
        }

        @Override
        public Integer getPrizedAmount() {
            return 5000;
        }

        @Override
        public String prizeDescription() {
            return String.format(
                    "%d개 일치 (5,000원)",
                    getNumberCount()
            );
        }

        @Override
        public Boolean hasBonusNumber() {
            return false;
        }
    }
}
