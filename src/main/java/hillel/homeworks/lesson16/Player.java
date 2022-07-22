package hillel.homeworks.lesson16;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Player {
    private String name;
    private int gamesPlayed = 0;
    private int win = 0;
    private int loss = 0;
    private int draw = 0;

    @Override
    public String toString() {
        return "Player{" +
                "name='" + name + '\'' +
                ", gamesPlayed=" + gamesPlayed +
                ", win=" + win +
                ", loss=" + loss +
                ", draw=" + draw +
                '}';
    }
}
