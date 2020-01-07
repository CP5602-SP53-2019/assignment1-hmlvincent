import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        int lowerRange;
        int upperRange;
        int numOfValue;
        int sortmethod;
        String userInput;
        String determination;
        String storedetermination;
        boolean unique = false;
        long startTime;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter lower limit:");
        lowerRange = input.nextInt();

        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter upper limit:");
        upperRange = input2.nextInt();
        while (upperRange < lowerRange) {
            System.out.println("The upper limit cannot lower than lower limit!");
            Scanner input2a = new Scanner(System.in);
            System.out.println("Enter upper limit:");
            upperRange = input2a.nextInt();
        }

        Scanner input3 = new Scanner(System.in);
        System.out.println("How many value do you want output:");
        numOfValue = input3.nextInt();
        while (numOfValue <= 0) {
            System.out.println("The value of number is must greater than 0");
            Scanner input3a = new Scanner(System.in);
            System.out.println("How many value do you want output:");
            numOfValue = input3a.nextInt();
        }

        Scanner input4 = new Scanner(System.in);
        System.out.println("Do you want output unique(T/F):");
        userInput = input4.next();
        determination = userInput.toUpperCase();
        while (determination.equals("T") == false && determination.equals("F") == false) {
            System.out.println("Wrong input, try again!");
            Scanner input4a = new Scanner(System.in);
            System.out.println("Do you want output unique(T/F):");
            userInput = input4a.next();
            determination = userInput.toUpperCase();
        }

        if (determination.equals("T")) {
            unique = true;
        }

        Scanner input5 = new Scanner(System.in);
        System.out.println("Do you want to sort the output: 1)insertion sort, 2)quick sort");
        sortmethod = input5.nextInt();
        while (sortmethod != 1 && sortmethod != 2) {
            System.out.println("Wrong input");
            Scanner input6a = new Scanner(System.in);
            System.out.println("Do you want to sort the output: 1)insertion sort, 2)quick sort");
            sortmethod = input6a.nextInt();
        }

        Scanner input6 = new Scanner(System.in);
        System.out.println("Do you want to store the output(T/F):");
        userInput = input6.next();
        storedetermination = userInput.toUpperCase();
        if (storedetermination.equals("T")) {
            System.out.println("The file is stored");
        } else {
            System.out.println("Output will not be stored!");
        }

        if (unique == false) {
            startTime = System.currentTimeMillis();
            int arr[] = new int[numOfValue];
            for (int i = 0; i < numOfValue; i++) {
                int randomNumber = (int) Math.round(Math.random() * (upperRange - lowerRange) + lowerRange);
                arr[i] = randomNumber;
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Random number generate time:" + (endTime - startTime) + "ms");
            if (sortmethod == 1) {
                System.out.println("Using insertion sort");
                long startTime2 = System.currentTimeMillis();
                InsertSort(arr);
                long endTime2 = System.currentTimeMillis();
                System.out.println("Sort used time:" + (endTime2 - startTime2) + "ms");
                if (storedetermination.equals("T")) {
                    savetofile(arr,startTime);
                }
                else if (storedetermination.equals("F")) {
                    display(arr,startTime);
                }

            } else if (sortmethod == 2) {
                System.out.println("Using quick sort");
                long startTime2 = System.currentTimeMillis();
                quickSort(arr,0,numOfValue-1);
                long endTime2 = System.currentTimeMillis();
                System.out.println("Sort used time:" + (endTime2 - startTime2) + "ms");
                if (storedetermination.equals("T")) {
                    savetofile(arr,startTime);
                }
                else if (storedetermination.equals("F")) {
                    display(arr,startTime);
                }
            }

        } else if (unique == true) {
            startTime = System.currentTimeMillis();
            int arr[] = new int[numOfValue];
            for (int i = 0; i < numOfValue; i++) {
                while (true) {
                    int randomNumber = (int) Math.round(Math.random() * (upperRange - lowerRange) + lowerRange);
                    for (int j = 0; j < i; j++) {
                        if (arr[j] == randomNumber) {
                            randomNumber = -1;
                            break;
                        }
                    }
                    if (randomNumber != -1) {
                        arr[i] = randomNumber;
                        break;
                    }
                }
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Random number generate time:" + (endTime - startTime) + "ms");
            if (sortmethod == 1) {
                System.out.println("Using insertion sort");
                long startTime2 = System.currentTimeMillis();
                InsertSort(arr);
                long endTime2 = System.currentTimeMillis();
                System.out.println("Sort used time:" + (endTime2 - startTime2) + "ms");
                if (storedetermination.equals("T")) {
                    savetofile(arr,startTime);
                }
                else if (storedetermination.equals("F")) {
                    display(arr,startTime);
                }
            } else if (sortmethod == 2) {
                System.out.println("Using quick sort");
                long startTime2 = System.currentTimeMillis();
                quickSort(arr,0,numOfValue-1);
                long endTime2 = System.currentTimeMillis();
                System.out.println("Sort used time:" + (endTime2 - startTime2) + "ms");
                if (storedetermination.equals("T")) {
                    savetofile(arr,startTime);
                }
                else if (storedetermination.equals("F")) {
                    display(arr,startTime);
                }
            }
        }
    }

    public static void InsertSort(int[] arr){
        int i, j;
        int n = arr.length;
        int target;
        for (i = 1; i < n; i++)
        {
            j = i;
            target = arr[i];
            while (j > 0 && target < arr[j - 1])
            {
                arr[j] = arr[j - 1];
                j--;
            }
            arr[j] = target;
        }
    }


    public static void quickSort(int[] arr, int head, int tail) {
        if (head >= tail || arr == null || arr.length <= 1) {
            return;
        }
        int i = head, j = tail, pivot = arr[(head + tail) / 2];
        while (i <= j) {
            while (arr[i] < pivot) {
                ++i;
            }
            while (arr[j] > pivot) {
                --j;
            }
            if (i < j) {
                int t = arr[i];
                arr[i] = arr[j];
                arr[j] = t;
                ++i;
                --j;
            } else if (i == j) {
                ++i;
            }
        }
        quickSort(arr, head, j);
        quickSort(arr, i, tail);
    }

    public static void display(int [] array, long startTime) {
        for (int i = 0; i <array.length; i++) {
            System.out.print(array[i]+"\r\n");
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Program running time:" + (endTime - startTime) + "ms");
        Scanner input7 = new Scanner(System.in);
        System.out.println("Press enter to exit.");
        String userInput2 = input7.next();
        if (userInput2 == null) {
            System.exit(0);
        }else {
            System.exit(0);
        }
    }

    public static void savetofile(int [] array, long startTime) {
        try {
            long startTime3 = System.currentTimeMillis();
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\MIT\\CP5602 Advanced Algorithm Analysis\\assignment1-hmlvincent\\test.txt"), "GBK");
            for ( int i = 0; i < array.length; i++){
                osw.write(array[i] + "\r\n");
            }
            long endTime = System.currentTimeMillis();
            System.out.println("File save time:" + (endTime - startTime3) + "ms");
            System.out.println("Program running time:" + (endTime - startTime) + "ms");
            osw.flush();
            osw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Scanner input7 = new Scanner(System.in);
        System.out.println("Press enter to exit.");
        String userInput2 = input7.next();
        if (userInput2 == null) {
            System.exit(0);
        }else {
            System.exit(0);
        }
    }
}