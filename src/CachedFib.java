import java.util.HashMap;
import java.util.function.Function;

public class CachedFib {
    //Attempt at making a closure work for caching.


    public static Function<Integer, Integer> fib() {

        HashMap<Integer, Integer> map = new HashMap<>();

        return new Function<Integer, Integer>() {
            @Override
            public Integer apply(Integer n) {
                {
                    if (map.containsKey(n)) {
                        return map.get(n);
                    }

                    if (n < 2) {
                        System.out.println("Putting " + n + " into map as: " + n);
                        map.put(n, n);
                        return n;
                    }
                    ;

                    int result = this.apply(n - 1) + this.apply(n - 2);
                    System.out.println("Putting " + n + " into map as: " + result);
                    map.put(n, result);
                    return result;
                }
            }
        };
    }

    public static void main(String[] args){
        Function<Integer, Integer> cachedFib = fib();
        System.out.println(cachedFib.apply(5));
        /**
         * Output:
         Putting 1 into map as: 1
         Putting 0 into map as: 0
         Putting 2 into map as: 1
         Putting 3 into map as: 2
         Putting 4 into map as: 3
         Putting 5 into map as: 5
         5
         */
    }
}


