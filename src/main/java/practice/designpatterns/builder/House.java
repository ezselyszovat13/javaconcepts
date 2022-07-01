package practice.designpatterns.builder;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class House implements HousePlan {
    private String basement;
    private String structure;
    private String roof;
    private String interior;

    @Override
    public String toString() {
        return "House{" +
            "basement='" + basement + '\'' +
            ", structure='" + structure + '\'' +
            ", roof='" + roof + '\'' +
            ", interior='" + interior + '\'' +
            '}';
    }
}
