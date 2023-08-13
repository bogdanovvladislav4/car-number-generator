import java.util.*;
public class Main {
    /*
    TODO:
     - реализовать методы класса CoolNumbers
     - посчитать время поиска введимого номера в консоль в каждой из структуры данных
     - проанализоровать полученные данные
     */
    public static void main(String[] args) {
        CoolNumbers.generateCoolNumbers();
        String carNumber1 = "АЕ127М138";
        String carNumber2 = CoolNumbers.carPlateNumbers.get(1_988_000);

        long start = System.nanoTime();
        boolean result = CoolNumbers.bruteForceSearchInList(CoolNumbers.carPlateNumbers, carNumber1);
        long finish = System.nanoTime();
        System.out.println(CoolNumbers.findNumber(result, CoolNumbers.BRUTE_FORCE_SEARCH_IN_LIST, start, finish));

        start = System.nanoTime();
        result = CoolNumbers.bruteForceSearchInList(CoolNumbers.carPlateNumbers, carNumber2);
        finish = System.nanoTime();
        System.out.println(CoolNumbers.findNumber(result, CoolNumbers.BRUTE_FORCE_SEARCH_IN_LIST, start, finish));

        Collections.sort(CoolNumbers.carPlateNumbers);
        start = System.nanoTime();
        result = CoolNumbers.binarySearchInList(CoolNumbers.carPlateNumbers, carNumber1);
        finish = System.nanoTime();
        System.out.println(CoolNumbers.findNumber(result, CoolNumbers.BINARY_SEARCH_IN_LIST, start, finish));

        start = System.nanoTime();
        result = CoolNumbers.bruteForceSearchInList(CoolNumbers.carPlateNumbers, carNumber2);
        finish = System.nanoTime();
        System.out.println(CoolNumbers.findNumber(result, CoolNumbers.BINARY_SEARCH_IN_LIST, start, finish));
        //Асимптота от О(1) до О(log2 hashSet.size). Наихудщий вариант при заполнении одного и
        // того же basket всеми существующими элементами (при одинаковых хеш-кодах) О(n).
        // Поиск происходит сначала ищет basket по хеш-коду, затем по баскету элементы проверяются через equals,
        // что ускоряет поиск элементов.
        //Наихудший вариант О(log2 hashSet.size)
        HashSet<String> hashSetNumber = new HashSet<>(CoolNumbers.carPlateNumbers);
        start = System.nanoTime();
        result = CoolNumbers.searchInHashSet(hashSetNumber, carNumber1);
        finish = System.nanoTime();
        System.out.println(CoolNumbers.findNumber(result, CoolNumbers.SEARCH_IN_HASH_SET, start, finish) + hashSetNumber.size());
        //При заранее известном количестве элементов, эфективнее задавать размер необходимый размер контейнера с
        // помощью конструктора, а так же изменить коэффициент заполнения на 1 (100 %),
        // при котором происходит расширение HashMap внутри HashSet.
        HashSet<String> hashSetNumber1 = new HashSet<>(2,1);
        hashSetNumber1.addAll(CoolNumbers.carPlateNumbers);
        start = System.nanoTime();
        result = CoolNumbers.searchInHashSet(hashSetNumber1, carNumber2);
        finish = System.nanoTime();
        System.out.println(CoolNumbers.findNumber(result, CoolNumbers.SEARCH_IN_HASH_SET, start, finish));

        start = System.nanoTime();
        result = CoolNumbers.searchInHashSet(hashSetNumber, carNumber2);
        finish = System.nanoTime();
        System.out.println(CoolNumbers.findNumber(result, CoolNumbers.SEARCH_IN_HASH_SET, start, finish));
        //Асимптота TreeSet О(log2 treeSet.size). Так как поиск происходит по дереву.
        TreeSet<String> threeSetNumber = new TreeSet<>(CoolNumbers.carPlateNumbers);
        start = System.nanoTime();
        result = CoolNumbers.searchInTreeSet(threeSetNumber, carNumber1);
        finish = System.nanoTime();
        System.out.println(CoolNumbers.findNumber(result, CoolNumbers.SEARCH_IN_TREE_SET, start, finish));

        start = System.nanoTime();
        result = CoolNumbers.searchInTreeSet(threeSetNumber, carNumber2);
        finish = System.nanoTime();
        System.out.println(CoolNumbers.findNumber(result, CoolNumbers.SEARCH_IN_TREE_SET, start, finish));
    }
}
