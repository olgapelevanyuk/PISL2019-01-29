package by.it.group673602.pelevanyuk.lesson09;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.*;

/*
Задача на программирование: рюкзак без повторов

Первая строка входа содержит целые числа
    1<=W<=100000     вместимость рюкзака
    1<=n<=300        число золотых слитков
                    (каждый можно использовать только один раз).
Следующая строка содержит n целых чисел, задающих веса каждого из слитков:
  0<=w[1]<=100000 ,..., 0<=w[n]<=100000

Найдите методами динамического программирования
максимальный вес золота, который можно унести в рюкзаке.

Sample Input:
10 3
1 4 8
Sample Output:
9

*/

public class B_Knapsack {

    int getMaxWeight(InputStream stream ) {
        //!!!!!!!!!!!!!!!!!!!!!!!!!     НАЧАЛО ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        Scanner scanner = new Scanner(stream);
        int w=scanner.nextInt();
        int n=scanner.nextInt();
        int gold[]=new int[n];
        for (int i = 0; i < n; i++) {
            gold[i]=scanner.nextInt();
        }


        int result = knaonsackSat(gold,w);
        //!!!!!!!!!!!!!!!!!!!!!!!!!     КОНЕЦ ЗАДАЧИ     !!!!!!!!!!!!!!!!!!!!!!!!!
        return result;
    }


    public static void main(String[] args) throws FileNotFoundException {
        String root = System.getProperty("user.dir") + "/src/";
        InputStream stream = new FileInputStream(root + "by/it/group673602/pelevanyuk/lesson09/dataB.txt");
        B_Knapsack instance = new B_Knapsack();
        int res=instance.getMaxWeight(stream);
        System.out.println(res);
    }
    int knaonsackSat(int[] ingotsWeights,int knapsackCapacity){

        ArrayList<Integer> combinationsOfWeights = new ArrayList<>();

        combinationsOfWeights.add(0);

        int countOfIngots = ingotsWeights.length;

        for (int i = 0; i < countOfIngots; i++) {

            ArrayList<Integer> capacityCombsWithCurrentIngot =  new ArrayList<>();

            for (int j = 0; j < combinationsOfWeights.size(); j++) {

                int currentCapacityCombination = ingotsWeights[i] + combinationsOfWeights.get(j);

                if(currentCapacityCombination <= knapsackCapacity &&
                        !combinationsOfWeights.contains(currentCapacityCombination)){
                    capacityCombsWithCurrentIngot.add(currentCapacityCombination);
                }
            }

            combinationsOfWeights.addAll(capacityCombsWithCurrentIngot);
        }

        return  Collections.max(combinationsOfWeights);
    }

}

