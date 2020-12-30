package errorexceptions.university;


import java.util.function.BiFunction;
import java.util.function.Supplier;

public enum SubjectParamUniversity implements Supplier<BiFunction<Double, Integer, Double>> {
    AVERAGE((o1, o2) -> (o1 / o2)
    ),
    ;
    private final BiFunction<Double, Integer, Double> biFunction;

    SubjectParamUniversity(BiFunction<Double, Integer, Double> biFunction) {
        this.biFunction = biFunction;
    }

    @Override
    public BiFunction<Double, Integer, Double> get() {
        return biFunction;
    }


}