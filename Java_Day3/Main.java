enum Level {
    LOW(1), MEDIUM(2), HIGH(3);

    final private int value;

    Level(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}

public class Main {
    public static void main(String[] args) {
        Level l = Level.LOW;
        Level h = Level.HIGH;
        Level m = Level.MEDIUM;
        System.out.println(l.getValue());
        System.out.println(h.getValue());
        System.out.println(m.getValue());  
    }
}
