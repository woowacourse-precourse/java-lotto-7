package lotto.model.match;

import java.util.NoSuchElementException;

public class Match {
    private final int count;
    private final boolean bonus;

    private Match(int count, boolean bonus) {
        this.count = count;
        this.bonus = bonus;
    }

    public static Match of(int count, boolean bonus) {
        int totalMatchCount = count;
        if (bonus) {
            totalMatchCount++;
        }
        return new Match(totalMatchCount, bonus);
    }

    public boolean isEqualTo(MatchInformation matchInformation) {
        try {
            MatchInformation sign = MatchInformation.of(count, bonus);
            return sign == matchInformation;
        } catch (NoSuchElementException e) {
            return false;
        }
    }

    @Override
    public int hashCode() {
        int result = Integer.hashCode(count);
        result = 31 * result + Boolean.hashCode(bonus);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Match match = (Match) obj;
        return this.count == match.count && this.bonus == match.bonus;
    }
}

