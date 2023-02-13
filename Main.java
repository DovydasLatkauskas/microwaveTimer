import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {
        ArrayList<Integer> testInput = new ArrayList<Integer>(); //input created for testing
        testInput.add(1);
        testInput.add(80);
        System.out.println(microwaveTimer(testInput)); // print statement for testing
    }

    /**
     * Main function of the program
     * represents the working of the microwave timer
     * 
     * @param input the starting state of the microwave timer
     * @return an ArrayList of integers integers representing the state of
     * the microwave timer ordered chronologically
     */

    private static ArrayList<ArrayList<Integer>> microwaveTimer(ArrayList<Integer> input) {
        ArrayList<ArrayList<Integer>> output = new ArrayList<ArrayList<Integer>>();
        output.add(input); // adds the input parameters to the beginning of the output
        while (!((input.get(0) == 0)&&(input.get(1) == 0))) {
            output.add(countDown(input));
        }
        // adds [0,0] to the end of output
        ArrayList<Integer> endList = new ArrayList<Integer>();
        endList.add(0);
        endList.add(0);
        output.add(endList);
        return output;
    }

    /**
     * helper function for microwaveTimer()
     * @param input the current state of the timer
     * @return the state of the timer after a second
     */

    private static ArrayList<Integer> countDown(ArrayList<Integer> input) {
        ArrayList<Integer> output = new ArrayList<Integer>();
        if (input.get(1) > 0) {
            output.add(input.get(0));
            output.add(input.get(1) - 1);
            return output;
        }
        else if((input.get(1) == 0) && (input.get(0) > 0)){
            output.add(input.get(0) - 1);
            output.add(59);
            return output;
        }
        else{ // should never fire
            throw new IllegalStateException("countDown method logic error");
        }
    }
}