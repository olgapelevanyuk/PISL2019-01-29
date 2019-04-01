package by.it.group673602.sharafanovich.lesson01;

import java.math.BigInteger;

/*
 * Вам необходимо выполнить способ вычисления чисел Фибоначчи с вспомогательным массивом
 * без ограничений на размер результата (BigInteger)
 */

public class FiboB {

    private long startTime = System.currentTimeMillis();

    private long time() {
        return System.currentTimeMillis() - startTime;
    }

    public static void main(String[] args) {

        //вычисление чисел простым быстрым методом
        FiboB fibo = new FiboB();
        int n = 55555;
        System.out.printf("fastB(%d)=%d \n\t time=%d \n\n", n, fibo.fastB(n), fibo.time());
    }

    BigInteger fastB(Integer n) {
        BigInteger[] array = new BigInteger[n];
        if(n < 2) return BigInteger.ONE;
        array[0] = array[1] = BigInteger.ONE;
        int i=2;
        while(i<n){
            array[i] = array[i - 1].add(array[i - 2]);
            i++;
        }
        return array[n - 1];
    }

}

