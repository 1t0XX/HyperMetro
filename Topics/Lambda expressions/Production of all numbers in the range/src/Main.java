import java.util.function.*;


class Operator {

    public static LongBinaryOperator binaryOperator = (x, y) -> {
        if (x == y) return x;
        long temp = 1;
        for (long i = x; i <= y; i++) {
            temp = temp * i;
        }
        return temp;
    };
}
