
package tictactoe;
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String score = sc.nextLine();
        char[][] tab = new char[3][3];
        int x;
        int y;
        boolean stan = true;
        boolean znakX = true;
        int sumO = 0;
        int sumX = 0;
        int winO = 0;
        int winX = 0;
        int wynik = 0;
        int countO = 0;
        int countX = 0;
        
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                tab[i][j] = ' ';
            }
        }
        
        System.out.println("---------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(tab[i][j] + " ");
            }
            System.out.println("|");
        }
        System.out.println("---------");
        
        while (stan) {
            String input = sc.nextLine();
            
            try {
                String[] check = input.split(" ");
                x = Integer.parseInt(check[0]);
                y = Integer.parseInt(check[1]);
            } catch (NumberFormatException e) {
                System.out.println("You should enter numbers!");
                continue;
            }
            
            if ( x > 3 || x < 1 || y > 3 || y < 1) {
                System.out.println("Coordinates should be from 1 to 3!");
                continue;
            }
            
            switch (input) {
                case "1 3":
                    if (tab[0][0] == ' ') {
                        if (znakX) {
                           tab[0][0] = 'X';
                           znakX = false; 
                        } else {
                            tab[0][0] = 'O';
                            znakX = true;
                        }
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                    break;
                case "1 2":
                    if (tab[1][0] == ' ') {
                        if (znakX) {
                           tab[1][0] = 'X';
                           znakX = false; 
                        } else {
                            tab[1][0] = 'O';
                            znakX = true;
                        }
                        
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                    break;
                case "1 1":
                    if (tab[2][0] == ' ') {
                        if (znakX) {
                           tab[2][0] = 'X';
                           znakX = false; 
                        } else {
                            tab[2][0] = 'O';
                            znakX = true;
                        }
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                    break;
                case "2 3":
                    if (tab[0][1] == ' ') {
                        if (znakX) {
                           tab[0][1] = 'X';
                           znakX = false; 
                        } else {
                            tab[0][1] = 'O';
                            znakX = true;
                        }
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                    break;
                case "2 2":
                    if (tab[1][1] == ' ') {
                        if (znakX) {
                           tab[1][1] = 'X';
                           znakX = false; 
                        } else {
                            tab[1][1] = 'O';
                            znakX = true;
                        }
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                    break;
                case "2 1":
                    if (tab[2][1] == ' ') {
                        if (znakX) {
                           tab[2][1] = 'X';
                           znakX = false; 
                        } else {
                            tab[2][1] = 'O';
                            znakX = true;
                        }
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                    break;
                case "3 3":
                    if (tab[0][2] == ' ') {
                        if (znakX) {
                           tab[0][2] = 'X';
                           znakX = false; 
                        } else {
                            tab[0][2] = 'O';
                            znakX = true;
                        }
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                    break;
                case "3 2":
                    if (tab[1][2] == ' ') {
                        if (znakX) {
                           tab[1][2] = 'X';
                           znakX = false; 
                        } else {
                            tab[1][2] = 'O';
                            znakX = true;
                        }
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                    break;
                case "3 1":
                    if (tab[2][2] == ' ') {
                        if (znakX) {
                           tab[2][2] = 'X';
                           znakX = false; 
                        } else {
                            tab[2][2] = 'O';
                            znakX = true;
                        }
                    } else {
                        System.out.println("This cell is occupied! Choose another one!");
                        continue;
                    }
                    break;
                default:
                    System.out.println("Error");
                    break;
            }
            System.out.println("---------");
            for (int i = 0; i < 3; i++) {
                System.out.print("| ");
                for (int j = 0; j < 3; j++) {
                    System.out.print(tab[i][j] + " ");
                }
                System.out.println("|");
            }
            System.out.println("---------");
            
            for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab[i][j] == 'O') {
                    sumO += 'O';
                } else if (tab[i][j] == 'X') {
                    sumX += 'X';
                }
            }
            if (sumO == 237) {
                winO++;
            } else if (sumX == 264) {
                winX++;
            }
            sumO = 0;
            sumX = 0;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab[j][i] == 'O') {
                    sumO += 'O';
                } else if (tab[j][i] == 'X') {
                    sumX += 'X';
                }
            }
            if (sumO == 237) {
                winO++;
            } else if (sumX == 264) {
                winX++;
            }
            sumO = 0;
            sumX = 0;
        }
        if (tab[0][2] == 'O' && tab[1][1] == 'O' && tab[2][0] == 'O') {
            winO++;
        } else if (tab[0][2] == 'X' && tab[1][1] == 'X' && tab[2][0] == 'X') {
            winX++;
        } else if (tab[0][0] == 'O' && tab[1][1] == 'O' && tab[2][2] == 'O') {
            winO++;
        } else if (tab[0][0] == 'X' && tab[1][1] == 'X' && tab[2][2] == 'X') {
            winX++;
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (tab[i][j] == 'O') {
                    countO++;
                } else if (tab[i][j] == 'X') {
                    countX++;
                }
            }
        }
        
        if (winO == 1) {
            wynik = 1;
        } else if (winX == 1) {
            wynik = 2;
        } else if (countO + countX == 9 && winX == 0 && winO == 0) {
            wynik = 3;
        }
        switch (wynik) {
            case 1: 
                System.out.println("O wins");
                stan = false;
                break;
            case 2: 
                System.out.println("X wins");
                stan = false;
                break;
            case 0: 
                continue;
            case 3:
                System.out.println("Draw");
                stan = false;
                break;
            default: 
                System.out.println("Error");
                break;
        }

            
            
        }
        
        
        
    }
}
