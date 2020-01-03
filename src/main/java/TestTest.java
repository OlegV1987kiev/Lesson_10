import java.io.Serializable;

/**
 * Created by Nick on 21.07.2016.
 */
public class TestTest implements Serializable{
    @Save
    public String text="bla-bla";
    @Save
    public int a=1;

    int b=2;

    @Save
    private    long c=50000;

    @Save
    public   double d=3.234;

    char e='x';



    public TestTest (int a, int b, long c, double d, char e, String text) {
        this.a = a;
        this.b = b;
        this.c = c;
        this.d = d;
        this.e = e;
        this.text = text;
    }

    public TestTest () {
    }
}

