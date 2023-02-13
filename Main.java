import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> testInput = new ArrayList<Integer>(); //input created for testing
        testInput.add(1);
        testInput.add(80);
        ArrayList<ArrayList<Integer>> printOutput = microwaveTimer(testInput); // print statement for testing
        for (ArrayList<Integer> listElement : printOutput) {
            System.out.println(listElement);
        }
    }

    /**
     * Main function of the program
     * represents the working of the microwave timer
     * 
     * @param timerInput the starting state of the microwave timer
     * @return an ArrayList of integers integers representing the state of
     * the microwave timer ordered chronologically
     */

    private static ArrayList<ArrayList<Integer>> microwaveTimer(ArrayList<Integer> timerInput) {
        ArrayList<ArrayList<Integer>> timerOutput = new ArrayList<ArrayList<Integer>>();
        timerOutput.add(timerInput); // adds the input parameters to the beginning of the output
        // condition when the while loop should break
        ArrayList<Integer> toBreak = new ArrayList<Integer>();
        toBreak.add(0);
        toBreak.add(0);
        while (true) {
            timerOutput.add(countDown(timerOutput.get(timerOutput.size() - 1)));
            if (timerOutput.get(timerOutput.size() - 1).equals(toBreak)){
                break;
            }
        }
        // adds [0,0] to the end of output
        ArrayList<Integer> endList = new ArrayList<Integer>();
        endList.add(0);
        endList.add(0);
        timerOutput.add(endList);
        return timerOutput;
    }

    /**
     * helper function for microwaveTimer()
     * @param countDownInput the current state of the timer
     * @return the state of the timer after a second
     */

    private static ArrayList<Integer> countDown(ArrayList<Integer> countDownInput) {
        ArrayList<Integer> countDownOutput = new ArrayList<Integer>();
        if (countDownInput.get(1) > 0) {
            countDownOutput.add(countDownInput.get(0));
            countDownOutput.add(countDownInput.get(1) - 1);
            return countDownOutput;
        }
        else if((countDownInput.get(1) == 0) && (countDownInput.get(0) > 0)){
            countDownOutput.add(countDownInput.get(0) - 1);
            countDownOutput.add(59);
            return countDownOutput;
        }
        else{ // should never fire
            throw new IllegalStateException("countDown method logic error");
        }
    }
}