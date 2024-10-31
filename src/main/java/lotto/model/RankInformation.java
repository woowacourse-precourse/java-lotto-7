package lotto.model;

public interface RankInformation {

    boolean support(int count, boolean contain);

    String getResultForDisplay(int comparedResult);

}
