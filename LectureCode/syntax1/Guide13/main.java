package LectureCode.syntax1.Guide13;

public class main {
    public static void main(String[] args) {
        final OdeMiester groovy = new OdeMiester();
        groovy.breath = 5;        // OdeMiester final的变量 在new中需要赋值，不能new之后单独赋值
        groovy.gosh = new Grodie();
        groovy.gosh.cow = 10;
        groovy.breath = 6;


        Grodie[] arr = new Grodie[2];
        arr[0] = groovy;      //groovy 是OdeMiester， arr是Grodie[]
        OdeMiester radical = new OdeMiester();
        OdeMiester lit = groovy;


        arr[0] = lit;       //lit 是OdeMiester， arr是Grodie[]
        groovy = radical;    // groovy是final，不能指向别的实例
        arr[1] = radical;
        arr[1] = lit;
        radical.gosh.cow = 2;
    }
}
