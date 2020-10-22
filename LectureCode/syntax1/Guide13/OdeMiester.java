package LectureCode.syntax1.Guide13;

public class OdeMiester {
    public final int breath;
    public final Grodie gosh;
    public final Grodie[] arr;

    public OdeMiester(int breath, Grodie gosh, Grodie[] arr) {
        this.breath = breath;
        this.gosh = gosh;
        this.arr = arr;
    }

    public OdeMiester() {
        OdeMiester a = new OdeMiester(2, null, null);
        this.breath = a.breath;
        this.gosh = a.gosh;
        this.arr = a.arr;
    }
}
