package actividad;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Exercise1 {

    /* Ask to the user 5 numbers from 0 to 10 (decimals included). Store them in an array and show the output
    
	 * @param args
	 * */
    public static void main(String[] args) {
        int opcion = 0;
        double[] values = new double[5];

        //Fill the array with values from 0 to 10
        System.out.println("Introduce 5 values ");
        for (int i = 0; i < values.length; i++) {
            double number = 0;
            boolean correctValue = false;
            while (!correctValue) {
                System.out.println("Introduce a decimal value");
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    number = Double.parseDouble(br.readLine());
                    correctValue= true;
                } catch (Exception e) {
                    System.out.println("Incorrect value. Choose a numeric value.");
                }
            }
            values[i] = number;
        }
    //Se deben almacenar a un array y mostrarlas por consola.
       for(int i=0; i<values.length; i++) {			
			System.out.println(values[i]);						
		}	
       //Seguidamente se pedirá al usuario si se quiere:
        do {

            System.out.print("\nOption Menu:\n"
                    + "1. Modify value.\n"
                    + "2. Show lowest value.\n"
                    + "3. Show average value.\n"
                    + "0. Log out.\n");
            boolean repite = true;
            //If this is not a numeric value, we ask for it once again.
            while (repite) {
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String op = br.readLine();
                    option = Integer.parseInt(op);
                    repite = false;
                } catch (Exception e) {
                    System.out.println("This is not a numeric value. Try again.");
                }
            }

            switch (option) {

                case 1: // Modify a value: will ask the array position we would like to modify and the new value. All the values in the array will be shown.
                    int position = 0;
                    System.out.println("In which position is the number you would like to modify?"
                            + " (Nees to be a number between " + (values.length - 1));
                     repite = true;
                    while (repite || position >= values.length || position < 0) {
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            String op = br.readLine();
                            position = Integer.parseInt(op);
                            repite = false;
                        } catch (Exception e) {
                            System.out.println("This is not a numeric value. Try again.");
                        }
                    }
                    double number = 0;
                    boolean correctValue = false;
                    while (!correctValue) {
                        System.out.println("Introduce new decimal value");
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            number = Double.parseDouble(br.readLine());
                            correctValue = true;
                        } catch (Exception e) {
                            System.out.println("Incorrect Value. Needs to be numeric");
                        }
                    }

                    values[position] = number;

                    break;

                case 2:
                    //-  Show the loewst balue: will find the lowest value through a loop and show it afterwards
                    double valueLow = values[0];
                    for (int i = 0; i < values.length; i++) {
                        if (values[i] < valueLow) {
                            valueLow = values[i];
                        }
                    }
                    System.out.println("Lowest value is: " + valueLow);
                    break;

                case 3: // Show average value: calculate the value through a loop and show it.
                    double media = 0;
                    for (int i = 0; i < values.length; i++) {
                        media += values[i];
                    }
                    media /= values.length;
                    System.out.println("Average value is: " + media);
                    break;


                case 0:
                    System.out.println("Closing application. See you soon");
                    break;

                default:
                    System.out.println("Option not valid, choose a number from 4 to 10");
            }

        } while (option != 0);

    }
}
