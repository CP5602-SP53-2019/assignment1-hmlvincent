import java.io.*;
import java.util.Scanner;

public class Task1 {
    public static void main(String[] args) {
        int lowerRange;
        int upperRange;
        int numOfValue;
        String userInput;
        String determination;
        String storedetermination;
        boolean unique = false;

        Scanner input = new Scanner(System.in);
        System.out.println("Enter lower limit:");
        lowerRange = input.nextInt();

        Scanner input2 = new Scanner(System.in);
        System.out.println("Enter upper limit:");
        upperRange = input2.nextInt();
        while (upperRange < lowerRange){
            System.out.println("The upper limit cannot lower than lower limit!");
            Scanner input2a = new Scanner(System.in);
            System.out.println("Enter upper limit:");
            upperRange = input2a.nextInt();
        }

        Scanner input3 = new Scanner(System.in);
        System.out.println("How many value do you want output:");
        numOfValue = input3.nextInt();

        Scanner input4 = new Scanner(System.in);
        System.out.println("Do you want output unique(T/F):");
        userInput = input4.next();
        determination = userInput.toUpperCase();

        while (determination.equals("T")==false && determination.equals("F")==false){
            System.out.println("Wrong input, try again!");
            Scanner input4a = new Scanner(System.in);
            System.out.println("Do you want output unique(T/F):");
            userInput = input4a.next();
            determination = userInput.toUpperCase();
        }

        if (determination.equals("T")){
            unique = true;
        }

        Scanner input5 = new Scanner(System.in);
        System.out.println("Do you want to store the output(T/F):");
        userInput = input5.next();
        storedetermination = userInput.toUpperCase();

        if (storedetermination.equals("T")){
            System.out.println("The file is stored");
        }else{
            System.out.println("Output will not be stored!");
        }

        if (unique == false){
            long startTime = System.currentTimeMillis();
            int arr[] = new int[numOfValue];
            for (int i =0 ; i< numOfValue; i++){
                int randomNumber = (int) Math.round(Math.random() * (upperRange - lowerRange) + lowerRange);
                arr[i] = randomNumber;
                System.out.print(arr[i]+"\r\n");
            }
            long endTime = System.currentTimeMillis();
            System.out.println("Random number generate time:" + (endTime - startTime) + "ms");
            savetofile(arr,startTime);

        } else if (unique == true) {
            long startTime = System.currentTimeMillis();
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
            for (int i = 0; i < numOfValue; i++) {
                System.out.print(arr[i] + "\r\n");
            }
            savetofile(arr,startTime);
            long endTime = System.currentTimeMillis();
            System.out.println("Random number generate time:" + (endTime - startTime) + "ms");
        }
    }

    public static void savetofile(int [] array, long startTime) {
        try {
            long startTime2 = System.currentTimeMillis();
            OutputStreamWriter osw = new OutputStreamWriter(new FileOutputStream("D:\\MIT\\CP5602 Advanced Algorithm Analysis\\assignment1-hmlvincent\\test.txt"), "GBK");
            for ( int i = 0; i < array.length; i++){
                osw.write(array[i] + "\r\n");
            }
            long endTime = System.currentTimeMillis();
            System.out.println("File save time:" + (endTime - startTime2) + "ms");
            System.out.println("Program running time:" + (endTime - startTime) + "ms");
            osw.flush();
            osw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        Scanner input9 = new Scanner(System.in);
        System.out.println("Press enter to exit.");
        String userInput2 = input9.next();
        if (userInput2.equals(null)) {
            System.exit(0);
        }else {
            System.exit(0);
        }
    }
}