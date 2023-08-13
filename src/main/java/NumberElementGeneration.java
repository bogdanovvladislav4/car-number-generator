public class NumberElementGeneration {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 999;
    private static final int MIN_REGION = 1;
    private static final int MAX_REGION = 199;
    private static final Character[] LETTERS = {'А', 'В', 'Е', 'К', 'М', 'Н', 'О', 'Р', 'С', 'Т', 'У', 'Х'};

    public static String generationSymbol(){
        String letter = Character.toString(LETTERS[0]);
        char randomSymbol = (char)((int)((Math.random() * ((LETTERS[LETTERS.length - 1] - LETTERS[0]) + 1)) + LETTERS[0]));
        for (Character character : LETTERS) {
            if (randomSymbol == character) {
                letter = Character.toString(randomSymbol);
                return letter;
            }
        }
        return letter;
    }

    public static String generationNumbers(){
        String number = "";
        int randomNumber = ((int)((Math.random() * ((MAX_NUMBER - MIN_NUMBER) + 1)) + MIN_NUMBER));
        if(randomNumber < 10){
            number = "0" + "0" + randomNumber;
            return  number;
        } else if(randomNumber > 10 && randomNumber < 100){
            number = "0" + randomNumber;
            return  number;
        } else {
            number = Integer.toString(randomNumber);
            return number;
        }
    }

    public static String generationRegion(){
        String region = "";
        int randomRegion = ((int)((Math.random() * ((MAX_REGION - MIN_REGION) + 1)) + MIN_REGION));
        if(randomRegion < 10){
            region = "0" + randomRegion;
            return  region;
        } else {
            region = Integer.toString(randomRegion);
            return region;
        }
    }
}
