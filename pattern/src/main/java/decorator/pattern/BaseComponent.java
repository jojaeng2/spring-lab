package decorator.pattern;

public class BaseComponent implements Component{

    @Override
    public String add() {
        return "에스프레소";
    }
}
