import java.util.*;

public class CoolNumbers {

    static List<String> carPlateNumbers = new ArrayList<>();
    public static final String BRUTE_FORCE_SEARCH_IN_LIST = "Поиск перебором: ";
    public static final String BINARY_SEARCH_IN_LIST = "Бинарный поиск: ";
    public static final String SEARCH_IN_HASH_SET = "Поиск в HashSet: ";
    public static final String SEARCH_IN_TREE_SET= "Поиск в TreeSet: ";

    public static String findNumber(Boolean result, String searchOption, long start, long finish){
        if(result){
            return searchOption + "номер найден, поиск занял " + (finish - start) + "нс";
        }
        return searchOption + "номер не найден";
    }

    public static List<String> generateCoolNumbers() {
        String coolNumber = "";
        for(int i = 0; i <= 2_000_000; i++){
            coolNumber = NumberElementGeneration.generationSymbol() + NumberElementGeneration.generationNumbers() +
                    NumberElementGeneration.generationSymbol() + NumberElementGeneration.generationSymbol() +
                    NumberElementGeneration.generationRegion();
            CoolNumbers.carPlateNumbers.add(coolNumber);
        }
        return CoolNumbers.carPlateNumbers;
    }

    public static boolean bruteForceSearchInList(List<String> list, String number) {
        return !(list.indexOf(number) == -1);
    }

    public static boolean binarySearchInList(List<String> sortedList, String number) {
        return Collections.binarySearch(sortedList, number) >= 0;
    }

    public static boolean searchInHashSet(HashSet<String> hashSet, String number) {
       return hashSet.contains(number);
    }

    public static boolean searchInTreeSet(TreeSet<String> treeSet, String number) {
        return treeSet.contains(number);
    }
}