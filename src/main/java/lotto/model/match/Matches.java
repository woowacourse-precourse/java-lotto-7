package lotto.model.match;

import lotto.dto.MatchDto;

import java.util.ArrayList;
import java.util.List;

public class Matches {
    private final List<Match> matches;

    public Matches(List<Match> matches) {
        this.matches = matches;
    }

    public List<MatchDto> getMatchDtos() {
        List<MatchDto> matchDtos = new ArrayList<>();
        MatchInformation[] matchInformations = MatchInformation.values();

        for (MatchInformation matchInformation : matchInformations) {
            int count = getMatchCount(matchInformation);
            matchDtos.add(new MatchDto(matchInformation, count));
        }
        return matchDtos;
    }

    private int getMatchCount(MatchInformation matchInformation) {
        return (int) matches.stream().filter(match -> match.isEqualTo(matchInformation)).count();
    }

    private boolean isAllMatch(Matches matches) {
        return this.matches.stream().allMatch(matches::isContain);
    }

    public int getSize() {
        return matches.size();
    }

    private boolean isContain(Match comparedMatch) {
        return this.matches.contains(comparedMatch);
    }

    @Override
    public int hashCode() {
        return matches.stream().mapToInt(Match::hashCode).sum();
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null || obj.getClass() != this.getClass()) {
            return false;
        }
        Matches matches = (Matches) obj;
        boolean isEqualSize = getSize() == matches.getSize();
        return isEqualSize && isAllMatch(matches);
    }
}
