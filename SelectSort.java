import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * This program uses select sort to
 * sort an array.
 *
 * @author  Melody Berhane
 * @version 1.0
 *
 * @since 2023-20-05.
 */

public final class SelectSort {

    /**
     * This is a private constructor used to satisfy the
     * style checker.
     *
     * @exception IllegalStateException Utility class.
     * @see IllegalStateException
     */
    private SelectSort() {
        throw new IllegalStateException("Utility class");
    }

    /**
     * This is the main method.
     *
     * @param args Unused.
     */
    public static void main(String[] args) {
        // Pass path to file as parameter.
        final File file = new File("input.txt");

        // Create a list of strings.
        final List<String> listOfStrings = new ArrayList<String>();

        // Declare variable
        String stringList;

        // Usage of try catch to detect error.
        try {
            // Create FileWriter object to write to file.
            final FileWriter fileWrite = new FileWriter("output.txt");
            // Create Scanner object to read from file.
            final Scanner sc = new Scanner(file);
            // Create PrintWriter object to write to file.
            final PrintWriter write = new PrintWriter(fileWrite);

            while (sc.hasNextLine()) {
                // Read line as string.
                stringList = sc.nextLine();
                // Add to list.
                listOfStrings.add(stringList);
            }
            // Convert from list to array.
            final String[] arrayOfStr = listOfStrings.toArray(new String[0]);

            // Convert all elements in array to integers.
            // To do so, loop through each element & convert
            // each string.
            for (int counter = 0; counter < arrayOfStr.length; counter++) {
                try {
                    final String[] nums = arrayOfStr[counter].split(" ");
                    final int[] arrayNum = new int[nums.length];
                    for (int counter2 = 0; counter2 < nums.length; counter2++) {
                        arrayNum[counter2] = Integer.parseInt(nums[counter2]);

                    }

                    // Call function.
                    final int[] sortSelect =
                        selectSort(arrayNum);

                    // Display & write to file.
                    write.println(Arrays.toString(sortSelect));

                } catch (NumberFormatException error) {
                    // Display error to user.
                    write.println("Incorrect, valid input.");
                    continue;
                }
            }

            // Closes scanner & writer.
            write.close();
            sc.close();

        } catch (IOException error) {
            // Displays error to user.
            System.out.println("An error occurred: "
                    + error.getMessage());
        }
    }

    /**
    * This function uses bubble sort to
    * sort an array.
    * Referenced from video.
    *
    * @param listNum passed.
    * @return listNum.
    */
    public static int[] selectSort(int[] listNum) {
        // Usage of loop to access each element.
        for (int counter1 = 0; counter1 < listNum.length; counter1++) {
            // Declare variables.
            int minNum = counter1;
            // Usage of loop to access each element.
            for (int counter2 = counter1 + 1; counter2 < listNum.length;
                counter2++) {
                if (listNum[counter2] < listNum[minNum]) {
                    minNum = counter2;
                }
            }
            // Checking to see if min num is in the loop.
            if (minNum != counter1) {
                // Declaring variable.
                final int temp = listNum[counter1];
                // Using temp to swap.
                listNum[counter1] = listNum[minNum];
                listNum[minNum] = temp;
            }
        }
        // Return main menu.
        return listNum;

    }
}
