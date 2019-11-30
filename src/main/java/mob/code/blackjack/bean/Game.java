package mob.code.blackjack.bean;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;
@Data
@AllArgsConstructor
public class Game {
    private String role_name;
    private List<String> cards;
}
