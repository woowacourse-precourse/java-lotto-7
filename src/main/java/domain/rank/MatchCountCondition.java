package domain.rank;

public enum MatchCountCondition {
    START_MATCH_COUNT_CONDITION(3),
    END_MATCH_COUNT_CONDITION(7)
    ;

    private int condition;

    private MatchCountCondition(int condition) {
        this.condition = condition;
    }

    public int getCondition() {
        return condition;
    }
}
