
public class Element {

    private final int key;
    String value;

    Element() {
        key = 0;
        value = null;
    }

    Element(int k, String d) {
        key = k;
        value = d;
    }

    public int Key() {
        int k = this.key;
        return k;
    }

    public String Value() {
        String d = this.value;
        return d;
    }
}
