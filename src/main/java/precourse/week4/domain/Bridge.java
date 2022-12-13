package precourse.week4.domain;

import java.util.List;

public class Bridge {

    private final List<String> directions;

    public Bridge(List<String> directions) {
        this.directions = directions;
    }

    public boolean judge(String inputDirection, int location) {
        String actualDirection = directions.get(location);
        return actualDirection.equals(inputDirection);
    }

    public boolean isEqualSize(int size) {
        return size == directions.size();
    }
}
