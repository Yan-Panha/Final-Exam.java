
import java.util.Scanner;
public class ListOfNumber {
    public static void main(String[] args){
            Scanner input = new Scanner(System.in);

            System.out.print("Enter the number of elements: ");
            int num = input.nextInt();

            int[] numbers = new int[num];

            System.out.print("Enter the numbers: ");
            for (int i=0; i < num; i++){
                numbers[i] = input.nextInt();
            }

            System.out.println("The input numbers are: ");
            for (int i=0; i < num; i++){
                System.out.print(numbers[i] + " ");
            }

            input.close();
        }
    }


