public class RandomShuffle {

    public static void shuffle(Object[] inputArg) {
        int size = inputArg.length;

        for (int i = 0; i < size; i++) {
            int randomInt = (int) Math.floor(Math.random() * i + 1);
            swap(inputArg, i, randomInt);
        }
    }

    public static void swap(Object[] inputArg, int arg1, int arg2) {
        Object temp = inputArg[arg1];
        inputArg[arg1] = inputArg[arg2];
        inputArg[arg2] = temp;
    }
}
