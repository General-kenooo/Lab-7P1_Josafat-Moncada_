//Fila 3 Silla 4
package lab7p1_josafatmoncada_;

import java.util.Scanner;
import java.util.Random;

public class Lab7P1_JosafatMoncada_ {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion = 0;

        while (opcion != 4) {
            System.out.println("Menú de opciones:");
            System.out.println("1. Ejercicio 1");
            System.out.println("2. Ejercicio 2");
            System.out.println("3. salir 3");

            System.out.print("Selecciona una opción: ");
            opcion = scanner.nextInt();

            switch (opcion) {
                case 1:

                    char[][] tablero = generarTablero();
                    boolean juegoEnCurso = true;

                    while (juegoEnCurso) {
                        mostrarTablero(tablero);
                        turnoUsuario(tablero);

                        if (verificarVictoria(tablero, 'X')) {
                            mostrarTablero(tablero);
                            System.out.println("¡Felicidades! ¡Has ganado!");
                            juegoEnCurso = preguntarPorOtraPartida(scanner);
                        } else if (esEmpate(tablero)) {
                            mostrarTablero(tablero);
                            System.out.println("¡Es un empate!");
                            juegoEnCurso = preguntarPorOtraPartida(scanner);
                        } else {
                            turnoMaquina(tablero);
                            if (verificarVictoria(tablero, 'O')) {
                                mostrarTablero(tablero);
                                System.out.println("¡La máquina ha ganado!");
                                juegoEnCurso = preguntarPorOtraPartida(scanner);
                            }
                        }
                    }

                    System.out.println("¡Gracias por jugar!");
                    scanner.close();
            }   
            
         
        }

    }

    private static char[][] generarTablero() {
        char[][] tablero = new char[3][3];
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                tablero[i][j] = ' ';
            }
        }
        return tablero;
    }

    private static void mostrarTablero(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                System.out.print(tablero[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean verificarPosicionValida(char[][] tablero, int fila, int columna) {
        return fila >= 0 && fila < tablero.length && columna >= 0 && columna < tablero[0].length && tablero[fila][columna] == ' ';
    }

    private static boolean verificarVictoria(char[][] tablero, char simbolo) {

        for (int i = 0; i < 3; i++) {
            if ((tablero[i][0] == simbolo && tablero[i][1] == simbolo && tablero[i][2] == simbolo)
                    || (tablero[0][i] == simbolo && tablero[1][i] == simbolo && tablero[2][i] == simbolo)) {
                return true;
            }
        }

        return (tablero[0][0] == simbolo && tablero[1][1] == simbolo && tablero[2][2] == simbolo)
                || (tablero[0][2] == simbolo && tablero[1][1] == simbolo && tablero[2][0] == simbolo);
    }

    private static void turnoUsuario(char[][] tablero) {
        Scanner scanner = new Scanner(System.in);
        int fila, columna;

        do {
            System.out.print("seleccione un numero de la fila entre(0-2): ");
            fila = scanner.nextInt();
            System.out.print("seleccione un numero de columna entre (0-2): ");
            columna = scanner.nextInt();
        } while (!verificarPosicionValida(tablero, fila, columna));

        tablero[fila][columna] = 'X';
    }

    private static void turnoMaquina(char[][] tablero) {
        Random random = new Random();
        int fila, columna;

        do {
            fila = random.nextInt(3);
            columna = random.nextInt(3);
        } while (!verificarPosicionValida(tablero, fila, columna));

        tablero[fila][columna] = 'O';
    }

    private static boolean esEmpate(char[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] == ' ') {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean preguntarPorOtraPartida(Scanner scanner) {
        System.out.print("¿Quieres jugar otra partida? (s/n): ");
        String respuesta = scanner.next().toLowerCase();
        return respuesta.equals("s");
    }

    case 2:
                    private static void encontrarPuntosSilla(int[][] matriz) {
        boolean hayPuntosSilla = false;

        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[0].length; j++) {
                int elemento = matriz[i][j];

                if (esMinimoEnFila(elemento, matriz, i) && esMaximoEnColumna(elemento, matriz, j)) {
                    System.out.println("Punto de silla encontrado en (" + i + ", " + j + "): " + elemento);
                    hayPuntosSilla = true;
                }
            }
        }

        if (!hayPuntosSilla) {
            System.out.println("No se encontro ningun punto de silla en la matriz.");
        }
    }

    private static boolean esMinimoEnFila(int elemento, int[][] matriz, int fila) {
        for (int j = 0; j < matriz[0].length; j++) {
            if (matriz[fila][j] < elemento) {
                return false;
            }
        }
        return true;
    }

    private static boolean esMaximoEnColumna(int elemento, int[][] matriz, int columna) {
        for (int i = 0; i < matriz.length; i++) {
            if (matriz[i][columna] > elemento) {
                return false;
            }
        }
        return true;
    }

}

                  

                
                          

        
        
    
    

               
    
   
    

        
        
    
    

