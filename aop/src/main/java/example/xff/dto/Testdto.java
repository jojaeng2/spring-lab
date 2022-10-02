package example.xff.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Testdto {

    private int id;
    private String name;

    public Testdto(int id, String name) {
        this.id = id;
        this.name = name;
    }
}
