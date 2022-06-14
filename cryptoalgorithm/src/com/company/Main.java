// Vigenère Cipher
package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        char[][] table = createTable();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter text:");
        String text = scanner.nextLine();// Только английские буквы капсом без других символов
        char chText[] = text.toCharArray();
        int length = text.length();
        System.out.println("Enter key:");
        String key = scanner.nextLine();// Только английские буквы капсом без других символов
        int KeyLength = key.length();
        char chShortKey[] = key.toCharArray();
        char chKey[] = new char[length];
        for (int i = 0; i < length; i++) //выравнивание ключа по длине текста
            chKey[i] = chShortKey[i % KeyLength];
        int y, x;
        for (int i = 0; i < length; i++) {
            y = findPos(chKey[i], table[0]);
            x = findPos(chText[i], table[0]);
            System.out.print(table[y][x]);
        }
    }

    private static char[][] createTable() {//таблица виженера
        char[][] table = new char[26][26];
        table[0][0] = 'A';
        table[0][1] = 'B';
        table[0][2] = 'C';
        table[0][3] = 'D';
        table[0][4] = 'E';
        table[0][5] = 'F';
        table[0][6] = 'G';
        table[0][7] = 'H';
        table[0][8] = 'I';
        table[0][9] = 'J';
        table[0][10] = 'K';
        table[0][11] = 'L';
        table[0][12] = 'M';
        table[0][13] = 'N';
        table[0][14] = 'O';
        table[0][15] = 'P';
        table[0][16] = 'Q';
        table[0][17] = 'R';
        table[0][18] = 'S';
        table[0][19] = 'T';
        table[0][20] = 'U';
        table[0][21] = 'V';
        table[0][22] = 'W';
        table[0][23] = 'X';
        table[0][24] = 'Y';
        table[0][25] = 'Z';
        for (int i = 1; i < 26; i++)
            for (int j = 0; j < 26; j++)
                table[i][j] = table[0][(i + j) % 26];
        return table;
    }

    public static int findPos(char ch, char[] table) {//поиск номера символа по алфавиту
        int pos = 0;
        for (int i = 0; i < 26; i++) {
            if (table[i] == ch)
                pos = i;
        }
        return pos;
    }
}
