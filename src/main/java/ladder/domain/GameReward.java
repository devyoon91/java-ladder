package ladder.domain;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GameReward {

    private static final String REWARD_IS_EMPTY = "결과에 빈값을 입력 할 수 없습니다.";
    private static final String REWARD_NAMES_SEPARATOR = ",";

    private final List<String> rewards;

    private GameReward (List<String> rewards) {
        this.rewards = rewards;
    }

    public static GameReward of(String rewardNames) {
        return new GameReward(splitStrings(rewardNames));
    }

    private static List<String> splitStrings(String rewardNames) {
        isNullReward(rewardNames);
        return Arrays.stream(rewardNames.split(REWARD_NAMES_SEPARATOR))
                .peek(GameReward::isNullReward)
                .collect(Collectors.toList());
    }

    private static void isNullReward(String reward) {
        if(isBlank(reward))
            throw new IllegalArgumentException(REWARD_IS_EMPTY);
    }

    private static boolean isBlank(String str) {
        return str == null || str.trim().isEmpty();
    }

    public String get(int index) {
        return rewards.get(index);
    }

    public List<String> getRewards() {
        return rewards;
    }
}
