import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;

public class Puzzle {

  /* Attribute */
  static Scanner in = new Scanner(System.in);
  static Scanner FILE;
  static String word, temp, FILENAME;
  static int wordLength;
  static int row = 0;
  static int col = 0;
  static char[][] board;
  static int[][] color;
  static ArrayList<String> wordArray;
  static final String ANSI_RESET = "\u001B[0m";
  static int randColor = 0;
  static long stepCounter = 0;
  static long totalstepCounter = 0;

  /* Method */
  public static void ReadFile() {
    /* KAMUS LOKAL */
    boolean fileFound = false;
    int i, j;

    /* ALGORITMA */
    while (!fileFound) {
      System.out.print("Masukkan nama file (tanpa .txt): ");
      FILENAME = in.nextLine();
      try {
        FILE = new Scanner(new File("../test/" + FILENAME + ".txt"));
        fileFound = true;
      } catch (Exception e) {
        System.out.println("Tidak ada nama File tersebut, ulangi.\n");
      }
    }

    /* Membaca banyak kolom puzzle */
    temp = FILE.nextLine();
    while (temp != "") {
      word = temp;
      temp = FILE.nextLine();
      row++;
    }

    /* Membaca banyak baris puzzle */
    for (i = 0; i < word.length(); i++) {
      if (word.charAt(i) != ' ') {
        col++;
      }
    }

    FILE.close();

    try {
      FILE = new Scanner(new File("../test/" + FILENAME + ".txt"));
      fileFound = true;
    } catch (Exception e) {
      System.out.println("Ada error dalam pembacaan file.");
    }

    board = new char[row][col];
    color = new int[row][col];

    for (i = 0; i < row; i++) {
      for (j = 0; j < col; j++) {
        board[i][j] = FILE.next().charAt(0);
        color[i][j] = 0;
      }
    }

    /* Memasukkan semua kata dalam ArrayList */
    wordArray = new ArrayList<String>();
    while (FILE.hasNext()) {
      word = FILE.next();
      wordArray.add(word);
    }

    FILE.close();
    in.close();
  }

  public static void displayBoard() {
    /* KAMUS LOKAL */
    int i, j;

    /* ALGORITMA */
    for (i = 0; i < row; i++) {
      for (j = 0; j < col; j++) {
        if (color[i][j] == 0) {
          System.out.print(board[i][j]);
        } else {
          System.out.print("\u001B[" + color[i][j] + "m" + board[i][j] + ANSI_RESET);
        }
        if (j != col - 1) {
          System.out.print(" ");
        }
      }
      System.out.println();
    }
    System.out.println();
  }

  public static boolean bruteforceAllDirection(int i, int j, String word) {
    /* KAMUS LOKAL */
    int k;
    boolean next = false;

    /* ALGORITMA */
    wordLength = word.length();
    stepCounter++;

    /* Algoritma Brute Force */
    if (board[i][j] == word.charAt(0)) {

      /* Memeriksa huruf ke arah atas */
      k = 1;
      while (i - k >= 0 && k < wordLength && !next) {
        stepCounter++;
        if (word.charAt(k) == board[i - k][j]) {
          k++;
        } else {
          next = true;
        }
      }

      if (k == wordLength) {
        for (k = 0; k < wordLength; k++) {
          color[i - k][j] = (randColor % 6) + 31;
        }
        randColor++;
        return true;
      } else {
        k = 1;
        next = false;
      }

      /* Memeriksa huruf ke arah diagonal kiri atas */
      while (i - k >= 0 && j + k < col && k < wordLength && !next) {
        stepCounter++;
        if (word.charAt(k) == board[i - k][j + k]) {
          k++;
        } else {
          next = true;
        }
      }

      if (k == wordLength) {
        for (k = 0; k < wordLength; k++) {
          color[i - k][j + k] = (randColor % 6) + 31;
        }
        randColor++;
        return true;
      } else {
        k = 1;
        next = false;
      }

      /* Memeriksa huruf ke arah kanan */
      while (j + k < col && k < wordLength && !next) {
        stepCounter++;
        if (word.charAt(k) == board[i][j + k]) {
          k++;
        } else {
          next = true;
        }
      }

      if (k == wordLength) {
        for (k = 0; k < wordLength; k++) {
          color[i][j + k] = (randColor % 6) + 31;
        }
        randColor++;
        return true;
      } else {
        k = 1;
        next = false;
      }

      /* Memeriksa huruf ke arah diagonal kanan bawah */
      while (i + k < row && j + k < col && k < wordLength && !next) {
        stepCounter++;
        if (word.charAt(k) == board[i + k][j + k]) {
          k++;
        } else {
          next = true;
        }
      }

      if (k == wordLength) {
        for (k = 0; k < wordLength; k++) {
          color[i + k][j + k] = (randColor % 6) + 31;
        }
        randColor++;
        return true;
      } else {
        k = 1;
        next = false;
      }

      /* Memeriksa huruf ke arah kanan bawah */
      while (i + k < row && k < wordLength && !next) {
        stepCounter++;
        if (word.charAt(k) == board[i + k][j]) {
          k++;
        } else {
          next = true;
        }
      }

      if (k == wordLength) {
        for (k = 0; k < wordLength; k++) {
          color[i + k][j] = (randColor % 6) + 31;
        }
        randColor++;
        return true;
      } else {
        k = 1;
        next = false;
      }

      /* Memeriksa huruf ke arah diagonal kiri bawah */
      while (i + k < row && j - k >= 0 && k < wordLength && !next) {
        stepCounter++;
        if (word.charAt(k) == board[i + k][j - k]) {
          k++;
        } else {
          next = true;
        }
      }

      if (k == wordLength) {
        for (k = 0; k < wordLength; k++) {
          color[i + k][j - k] = (randColor % 6) + 31;
        }
        randColor++;
        return true;
      } else {
        k = 1;
        next = false;
      }

      /* Memeriksa huruf ke arah kiri */
      while (j - k >= 0 && k < wordLength && !next) {
        stepCounter++;
        if (word.charAt(k) == board[i][j - k]) {
          k++;
        } else {
          next = true;
        }
      }

      if (k == wordLength) {
        for (k = 0; k < wordLength; k++) {
          color[i][j - k] = (randColor % 6) + 31;
        }
        randColor++;
        return true;
      } else {
        k = 1;
        next = false;
      }

      /* Memeriksa huruf ke arah diagonal kiri atas */
      while (i - k >= 0 && j - k >= 0 && k < wordLength && !next) {
        stepCounter++;
        if (word.charAt(k) == board[i - k][j - k]) {
          k++;
        } else {
          next = true;
        }
      }

      if (k == wordLength) {
        for (k = 0; k < wordLength; k++) {
          color[i - k][j - k] = (randColor % 6) + 31;
        }
        randColor++;
        return true;
      }
    }
    return false;
  }

  public static void main(String[] args) throws Exception {
    /* KAMUS LOKAL */
    int nWord;
    int i, j;
    boolean isFound = false;
    long start, end, runtime;

    /* ALGORITMA */
    ReadFile();
    System.out.println("\nKata yang sedang dicari: ");
    start = System.nanoTime();
    for (nWord = 0; nWord < wordArray.size(); nWord++) {
      i = 0;
      while (i < row && !isFound) {
        j = 0;
        while (j < col && !isFound) {
          isFound = bruteforceAllDirection(i, j, wordArray.get(nWord));
          j++;
        }
        i++;
      }
      if (isFound) {
        System.out.print((nWord + 1) + ". Kata " + wordArray.get(nWord) + " ditemukan");
      } else {
        System.out.print((nWord + 1) + ". Kata " + wordArray.get(nWord) + " tidak ditemukan");
      }
      System.out.println(", jumlah perbandingan huruf: " + stepCounter);
      totalstepCounter += stepCounter;
      stepCounter = 0;
      isFound = false;
    }

    end = System.nanoTime();
    runtime = (long) end - start;

    System.out.println("\nSolusi PuzzleWord: ");
    displayBoard();
    System.out.print("Waktu eksekusi program: ");
    System.out.printf("%.3f", (double) runtime / 1000000);
    System.out.println(" ms");
    System.out.println("Total perbandingan huruf: " + totalstepCounter);
  }
}
