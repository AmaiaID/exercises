package activity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Exercise2 {

    public static void main(String[] args) throws IOException {
        // TODO Auto-generated method stub

        int opcion = 0;

        String[][] scores = new String[4][4];

       
        scores[0][0] = "M01";
        scores[0][1] = "8";
        scores[0][2] = "9";
        scores[0][3] = "10";
        scores[1][0] = "M02";
        scores[1][1] = "6";
        scores[1][2] = "9";
        scores[1][3] = "8";
        scores[2][0] = "M03";
        scores[2][1] = "4";
        scores[2][2] = "5";
        scores[2][3] = "5";
        scores[3][0] = "M04";
        scores[3][1] = "10";
        scores[3][2] = "4";
        scores[3][3] = "9";

// Show the stored values in the array
        System.out.println("Bidimensional array values are: ");
        for (String[] puntuacione : scores) {
            for (String puntuacione1 : puntuacione) {
                System.out.print(puntuacione1 + "   ");
            }
            System.out.println("");
        }
        System.out.println("");

        do {

            System.out.print("\n Options menu:\n"
                    + "1. Show subject name.\n"
                    + "2. Show scores.\n"
                    + "3. Modify subject name according to array position.\n"
                    + "4. Show average score for a subject\n"
                    + "5. Show highest score in a subject.\n"
                    + "0. Logout.\n");

            while (true) {
                try {
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String op = br.readLine();
                    option = Integer.parseInt(op);
                    break;
                } catch (Exception e) {
                    System.out.println("Value is not valid");
                }
            }

            switch (option) {

                case 1:
                    //Show subject name
                    System.out.println("Chosen subjects are: ");
                    for (String[] puntuacione : scores) {
                        System.out.print(puntuacione[0] + "   ");
                    }
                    System.out.println("");
                    break;

                case 2:
                    System.out.println("Las scores introducidas son: ");
                    for (int i = 0; i < scores.length; i++) {
                        for (int j = 0; j < scores[i].length; j++) {
                            System.out.print(scores[i][j] + "   ");
                        }
                        System.out.println("");
                    }
                    System.out.println("");
                    break;

                case 3:

                    int position = 0;

                    
                    while (true) {
                        System.out.println("Indica el número de asignatura entre 0 y " + (scores.length-1) + " ");
                        try {
                            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                            String op = br.readLine();
                            position = Integer.parseInt(op);
                            if(position < scores.length && position > 0){
                            break;}
                            
                        } catch (Exception e) {
                            System.out.println("No has introducido un valor valido.");
                        }
                    }
                    System.out.println("Indica el nuevo subjectName");
                    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                    String subjectName = br.readLine();

                    scores[position][0] = subjectName;

                    break;

                case 4:
                    //Ask which average value who would like to get
                    position = 0;
                   
                    while ( true) {
                        System.out.println("Choose subject number between 0 and  " + (scores.length - 1) + " ");
                        try {
                            br = new BufferedReader(new InputStreamReader(System.in));
                            String op = br.readLine();
                            position = Integer.parseInt(op);
                             if(position < scores.length && position > 0){
                            break;}
                        } catch (Exception e) {
                            System.out.println("Introduced value is incorrect.");
                        }
                    }
                    //calculamos el valor medio
                    double valorMedio = 0;
                    for (int j = 1; j < scores[position].length; j++) {
                        valorMedio = valorMedio + Double.parseDouble(scores[position][j]);
                    }
                    valorMedio = valorMedio / 3;

                    System.out.println("Average value " + scores[position][0] + " is " + valorMedio);
                    break;

                case 5:
                    //Highest score
                    position = 0;
                   

                    while (true) {
                        System.out.println("Introduce a number between 0 and " + (scores.length - 1) + " ");
                        try {
                            br = new BufferedReader(new InputStreamReader(System.in));
                            String op = br.readLine();
                            position = Integer.parseInt(op);
                             if(position < scores.length && position > 0){
                            break;}
                        } catch (Exception e) {
                            System.out.println("Incorrect value");
                        }
                    }
                    //calculamos el valor maximo
                    double valorMaximo = Double.parseDouble(scores[position][1]);
                    for (int j = 1; j < scores[0].length; j++) {
                        if (valorMaximo < Double.parseDouble(scores[position][j])) {
                            valorMaximo = Double.parseDouble(scores[position][j]);
                        }
                    }
                    System.out.println("Max value is:" + valorMaximo);

                    break;

                case 0:
                    System.out.println("Closing application. See you soon!");
                    break;

                default:
                    System.out.println("Option is not valid.");
            }

        } while (option != 0);

    }

}
