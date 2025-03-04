import java.util.Scanner;
public class App {
    public static void main(String[] args) throws Exception {
    Scanner scanner = new Scanner(System.in);

    // variable y constantes
    final int PIN_CORRECTO = 1512;
    double saldo = 100000;
    int intentos = 0;
    boolean cuentaBloqueada = false;

    // Auntenticación según los intentos
    while (intentos < 3){
        System.out.println("Ingrese su PIN: ");
        int pinIngresado = scanner.nextInt();

        if(pinIngresado == PIN_CORRECTO){
            System.out.println("BIENVENIDO CARIÑO");
            break;

        }else {
            intentos ++;
            System.out.println("PIN incorrecto ¡No, no,no! "+ intentos);

        }if (intentos == 3){
            cuentaBloqueada = true;
            System.out.println("CUENTA BLOQUEADA ¡RAROOO!");
        }
    }

    // si la cuenta ha sido bloqueada finalizará el programa
    if (cuentaBloqueada){
        scanner.close();
        return;

    }
    // Menú de cajero
    int opcion;
    do{
        System.out.println("BIENVENIDO A SU CAJERO");
        System.out.println("1. Consultar su saldito");
        System.out.println("2. Retirar saldito");
        System.out.println("3. Depositar cash!");
        System.out.println("4. SALIR y Bye");
        System.out.println("Selecionar una opción!");
        opcion = scanner.nextInt();

        // manejo de opciones 
        switch (opcion) {
            case 1:
                System.out.println("Este es tu saldo: $" + saldo);
                break;

                case 2:
                System.out.println("Que cantidad deseas retirar?: ");
                double retiro = scanner.nextDouble();
                if(retiro >= 0 && retiro <= saldo){
                    saldo -= retiro;
                    System.out.println("Sacaste dinero, tu saldo es de:"+ saldo);
                }else{
                    System.out.println("Cómo vas a retirar un saldo que no tienes?" + saldo);

                } 
                break;

                case 3:
                System.out.println("Cúanto dinero vas a consignar?:" );
                double deposito = scanner.nextDouble();
                if( deposito > 0){
                    saldo += deposito;
                    System.out.println("Depositación exitosa!!!, su saldo es de: " + saldo );

                }else{
                    System.out.println("Ese valor no está disponible");

                }
                break;
                case 4:
                System.out.println("HASTA PRONTO");
                break;
                default:
                System.out.println("¡Esa NO es una opción!");
                break; 
                
        }
    }while (opcion != 4);
    scanner.close();


    }
}
