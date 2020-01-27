import java.io.*;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Scanner;
import java.util.Vector;

import static jdk.nashorn.internal.runtime.GlobalFunctions.parseInt;


public class Main {


    public static void main(String[] args) throws FileNotFoundException {

        //DATOTEKA IZ KATERE BOMO BRALI
        String theString = "";

        File file = new File("lalal.txt");
        Scanner scanner = new Scanner(file);

        theString = scanner.nextLine();
        while (scanner.hasNextLine()) {
            theString = theString + "\n" + scanner.nextLine();
            // System.izpis.println(theString);
        }

        System.out.println();
        System.out.println(theString);

        char[] charArray = theString.toCharArray(); // pusnemo v charArray
        int[] intArray = new int[charArray.length]; // tabela 1
        int[] intsTMP = new int[charArray.length]; // tabela 2

        int stevec_nul = 0;
    /*    for(int l = 0; l < dvabitaNeg.length;l++){
            String str1 = String.format( "%02d",dvabitaNeg[l]);
            System.izpis.print(str1);
        }*/


        System.out.println("");

        /* CONVERTAMO V ASCII*/
        for (int i = 0; i < theString.length(); i++) {
            intArray[i] = (int) charArray[i];
            System.out.print("|" + intArray[i] + "|");
        }

        System.out.println();
        //da vrzem v drugiga, da bo  na i-1 ze postavljen na -1
        for (int j = 1; j < intArray.length; j++) {
            intsTMP[j - 1] = intArray[j - 1];

        }
        /* DA MI ODSTEJE VSE DRUGE RAZEN i-1 PUST*/
        for (int i = 1; i < intArray.length; i++) { // zacnemo na 1
            //intsTMP[i-1] = intArray[i-1];
            intsTMP[i] = intArray[i] - intArray[i - 1];

        }
        /* SMAO ZA PREGLED */
        for (int i = 0; i < intsTMP.length; i++) {
            System.out.print(" | " + intsTMP[i]);

        }


        String n = null;
        System.out.println();

        /*PRAVILA*/
        //boolean[] bits = new boolean[intArray.length];
        PrintStream izpis = new PrintStream(new FileOutputStream("output.txt"));


        /* ENA ZANkA SE PREVERJA ZA VSE SKUP*/
        for (int i = 0; i < intsTMP.length; i++) {

            //   System.izpis.print( " | " + intsTMP[i]);

            /*PRVA VREDNOST*/
            if (i == 0) {

                n = String.format("%8s", Integer.toBinaryString(intsTMP[i])).replace(' ', '0');

                izpis.print(n);
                //  System.setOut(izpis);

            } else if (i != 0) { // če nismo na indexu 0

                /* PONOVITVE*/
                //ponovitve =null;
                if (intsTMP[i] == 0) // če je enako 0
                {
                    stevec_nul++; // stevec nicel se poveca

                }
                if (intsTMP[i] != 0 && stevec_nul != 0 || i == intsTMP.length - 1 && stevec_nul != 0) {
                    izpis.print(0);
                    izpis.print(1);
                    if (stevec_nul == 1) {
                        izpis.print("000");
                    }
                    if (stevec_nul == 2) {
                        izpis.print("00" + 1);
                    }
                    if (stevec_nul == 3) {
                        izpis.print("0" + 10);
                    }
                    if (stevec_nul == 4) {
                        izpis.print("0" + 11);
                    }
                    if (stevec_nul == 5) {
                        izpis.print(100);
                    }
                    if (stevec_nul == 6) {
                        izpis.print(101);
                    }
                    if (stevec_nul == 7) {
                        izpis.print(110);
                    }
                    if (stevec_nul == 7) {
                        izpis.print(111);
                    }
                    // System.out.print( stevec_nul);
                    stevec_nul = 0;

                }




                /*RAZLIKE*/
                if (intsTMP[i] < 30 && intsTMP[i] > 0 || intsTMP[i] < 0 && intsTMP[i] > -30) {
                    izpis.print(0);
                    izpis.print(0);
                }
                if (intsTMP[i] >= -2 && intsTMP[i] <= -1 || intsTMP[i] >= 1 && intsTMP[i] <= 2) {

                    izpis.print(0);
                    izpis.print(0);
                    // System.setOut(izpis);

                    if (intsTMP[i] == -2) {
                        izpis.print(0);
                        izpis.print(0);
                    } else if (intsTMP[i] == -1) {
                        izpis.print("0" + 1);
                    } else if (intsTMP[i] == 1) {
                        izpis.print(10);
                    } else if (intsTMP[i] == 2) {
                        izpis.print(11);
                    }


                    // izpis.print(".");

                } else if (intsTMP[i] >= -6 && intsTMP[i] <= -3 || intsTMP[i] >= 3 && intsTMP[i] <= 6) {
                    izpis.print(0);
                    izpis.print(1);
                    //System.setOut(izpis);
                    if (intsTMP[i] == -6) {
                        izpis.print("000");
                    } else if (intsTMP[i] == -5) {
                        izpis.print("00" + 1);
                    } else if (intsTMP[i] == -4) {
                        izpis.print("0" + 10);
                    } else if (intsTMP[i] == -3) {
                        izpis.print("0" + 11);
                    } else if (intsTMP[i] == 3) {
                        izpis.print(100);
                    } else if (intsTMP[i] == 4) {
                        izpis.print(101);
                    } else if (intsTMP[i] == 5) {
                        izpis.print(110);
                    } else if (intsTMP[i] == 6) {
                        izpis.print(111);
                    }
                } else if (intsTMP[i] >= -14 && intsTMP[i] <= -7 || intsTMP[i] >= 7 && intsTMP[i] <= 14) {
                    izpis.print(1);
                    izpis.print(0);
                    //System.setOut(izpis);
                    if (intsTMP[i] == -14) {
                        izpis.print("0000");
                    }
                    if (intsTMP[i] == -13) {
                        izpis.print("000" + 1);
                    }
                    if (intsTMP[i] == -12) {
                        izpis.print("00" + 10);
                    }
                    if (intsTMP[i] == -11) {
                        izpis.print("00" + 11);
                    }
                    if (intsTMP[i] == -10) {
                        izpis.print("0" + 100);
                    }
                    if (intsTMP[i] == -9) {
                        izpis.print("0" + 101);
                    }
                    if (intsTMP[i] == -8) {
                        izpis.print("0" + 110);
                    }
                    if (intsTMP[i] == -7) {
                        izpis.print("0" + 111);
                    }

                    if (intsTMP[i] == 7) {
                        izpis.print(1000);
                    }
                    if (intsTMP[i] == 8) {
                        izpis.print(1001);
                    }
                    if (intsTMP[i] == 9) {
                        izpis.print(1010);
                    }
                    if (intsTMP[i] == 10) {
                        izpis.print(1011);
                    }
                    if (intsTMP[i] == 11) {
                        izpis.print(1100);
                    }
                    if (intsTMP[i] == 12) {
                        izpis.print(1101);
                    }
                    if (intsTMP[i] == 13) {
                        izpis.print(1110);
                    }
                    if (intsTMP[i] == 14) {
                        izpis.print(1111);
                    }

                    //izpis.print(".");

                } else if (intsTMP[i] >= -30 && intsTMP[i] <= -15 || intsTMP[i] >= 15 && intsTMP[i] <= 30) {
                    izpis.print(1);
                    izpis.print(1);
                    // System.setOut(izpis);

                    switch (intsTMP[i]) {
                        case -30:
                            izpis.print("00000");
                            break;
                        case -29:
                            izpis.print("0000" + 1);
                            break;
                        case -28:
                            izpis.print("000" + 10);
                            break;
                        case -27:
                            izpis.print("000" + 11);
                            break;
                        case -26:
                            izpis.print("00" + 100);
                            break;
                        case -25:
                            izpis.print("00" + 101);
                            break;
                        case -24:
                            izpis.print("00" + 110);
                            break;
                        case -23:
                            izpis.print("00" + 111);
                            break;
                        case -22:
                            izpis.print("0" + 1000);
                            break;
                        case -21:
                            izpis.print("0" + 1001);
                            break;
                        case -20:
                            izpis.print("0" + 1010);
                            break;
                        case -19:
                            izpis.print("0" + 1011);
                            break;
                        case -18:
                            izpis.print("0" + 1100);
                            break;
                        case -17:
                            izpis.print("0" + 1101);
                            break;
                        case -16:
                            izpis.print("0" + 1110);
                            break;
                        case -15:
                            izpis.print("0" + 1111);
                            break;
                        case 15:
                            izpis.print(10000);
                            break;
                        case 16:
                            izpis.print(10001);
                            break;
                        case 17:
                            izpis.print(10010);
                            break;
                        case 18:
                            izpis.print(10011);
                            break;
                        case 19:
                            izpis.print(10100);
                            break;
                        case 20:
                            izpis.print(10101);
                            break;
                        case 21:
                            izpis.print(10110);
                            break;
                        case 22:
                            izpis.print(10111);
                            break;
                        case 23:
                            izpis.print(11000);
                            break;
                        case 24:
                            izpis.print(11001);
                            break;
                        case 25:
                            izpis.print(11010);
                            break;
                        case 26:
                            izpis.print(11011);
                            break;
                        case 27:
                            izpis.print(11100);
                            break;
                        case 28:
                            izpis.print(11101);
                            break;
                        case 29:
                            izpis.print(11110);
                            break;
                        case 30:
                            izpis.print(11111);
                            break;


                    }
                    // izpis.print(".");
                }

                /*ABS KODIRANJE*/
                else if (intsTMP[i] > 30 || intsTMP[i] < -30) {

                    izpis.print(10);
                    //System.setOut(izpis);
                    n = null;
                    if (intsTMP[i] > 0.0) {
                        izpis.print(0);
                        //System.setOut(izpis);
                    } else if (intsTMP[i] < 0.0) {
                        izpis.print(1);
                        //System.setOut(izpis);
                    }

                    // izpis.print("ABS");
                    n = String.format("%8s", Integer.toBinaryString(Math.abs(intsTMP[i]))).replace(' ', '0');
                    // n = String.format("%8s", Integer.toBinaryString(intsTMP[i])).replace(' ', '0');
                    izpis.print(n);
                    //System.setOut(izpis);

                }


            }

        }


        //izpis.print(".");

        izpis.print(11);
        //System.setOut(izpis);
        System.out.println();
        System.out.println();

        scanner.close();
        izpis.close();
        System.out.println();


        //   BufferedWriter writer = new BufferedWriter( new FileWriter(fileName));
        //  writer.write();


        //______    _________  __   ___   ______      _____
        //|     \   |           |  /      |     |    |     \
        //|     |   |_____      |/        |     |    |     |
        //|     |   |           | \       |     |    |     |
        //|____/    |________   |_ \_     |____ |    |____/


        //DATOTEKA V KATERO BOMO ZAPISOVALI ODKODIRANO:

        String kodirana = "";

        File file1_odkodirano = new File("test.txt");//output.txt more bit
        Scanner scanner1 = new Scanner(file1_odkodirano);

        System.out.println("HAHAHAHAHA");

        kodirana = scanner1.nextLine();
        while (scanner1.hasNextLine()) {
            kodirana = kodirana + "\n" + scanner1.nextLine();
            // System.izpis.println(theString);
        }

        System.out.println(" sad" + kodirana);
        char[] array_kodirano = kodirana.toCharArray(); // pusnemo v charArray
        int c = 0;

        System.out.println();
        //najprej preberes prvih 8
        int result = 0;

        int[] int_binarry = new int[array_kodirano.length]; // sem si bom dal vse vrednosti
        char[] charArray_prvi_del = new char[8];


        //PRETVORBA V int[]
        String string_1;
        int sestevek = 0;
        for (int i = 0; i < array_kodirano.length; i++) {

            //sedaj se pretvori v int[]
            int_binarry[i] = Character.getNumericValue(array_kodirano[i]);
            //System.out.print(int_binarry[i]);
             /* if(i<=7 ){
                System.out.print(array_kodirano[i]);
                 charArray_prvi_del[i]= array_kodirano[i];
*/


            // }
        }


        System.out.println();
        //ZA PRVI DEL za 8 stevilk
        int l = 0;
        int sestevek_abs = 0;
        for (int j = 0; j < 1; j++) {

            // System.out.print( "asdaaaa" + charArray_prvi_del[]);
            System.out.print(int_binarry[j]);
            System.out.println(l++);
            if (int_binarry[0] == 1) {
                sestevek += 128;
            }
            if (int_binarry[1] == 1) {
                sestevek += 64;
            }
            if (int_binarry[2] == 1) {
                sestevek += 32;
            }
            if (int_binarry[3] == 1) {
                sestevek += 16;
            }
            if (int_binarry[4] == 1) {
                sestevek += 8;
            }
            if (int_binarry[5] == 1) {
                sestevek += 4;
            }
            if (int_binarry[6] == 1) {
                sestevek += 2;
            }
            if (int_binarry[7] == 1) {
                sestevek += 1;
            }


        }
        //USTVARO SEM VEKTOR KER HOCEM DA SE MI SPROTI DODAJAJO
        Vector<Integer> vector = new Vector<Integer>();
        vector.add(sestevek);


        // IZPIS ZA PRVIH 8 stevilk!!!!
        System.out.print("SESTEVEK: " + sestevek + "|");
        /// SEDAJ SLEDIJO PRAVILA
        for (int i = 8; i < int_binarry.length; i++) { // na 8 starta in gre preverit od tam naprej
            System.out.println("INDEX 8 =" + int_binarry[i]);
            //RAZLIKE
            if (int_binarry[i] == 0 && int_binarry[i + 1] == 0) { // ce je  00 pol so razlike
                i++;

                //TODO NAREDI SE ZA RAZLIKE
                System.out.println("razlike");
                if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 0) {
                    i = i + 2;
                    System.out.println("V priv_sklop");
                    if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 0) {
                        vector.add(-2);
                    } // -2
                    if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 1) {
                        vector.add(-1);
                    }//-1
                    if (int_binarry[i + 1] == 1 && int_binarry[i + 2] == 0) {
                        vector.add(1);
                    }//1
                    if (int_binarry[i + 1] == 1 && int_binarry[i + 2] == 1) {
                        vector.add(2);
                    }//2

                    i = i + 2;

                    System.out.println(i);
                }
                System.out.println(i);
                if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 1) {
                    i += 2;
                    System.out.println("V drugi_sklop");
                    if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 0 && int_binarry[i + 3] == 0) {
                        vector.add(-6);
                    }// -6
                    if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 0 && int_binarry[i + 3] == 1) {
                        vector.add(-5);
                    }//-5
                    if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 1 && int_binarry[i + 3] == 0) {
                        vector.add(-4);
                    }//-4
                    if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 1 && int_binarry[i + 3] == 1) {
                        vector.add(-3);
                    }//-3
                    if (int_binarry[i + 1] == 1 && int_binarry[i + 2] == 0 && int_binarry[i + 3] == 0) {
                        vector.add(3);
                    }//3
                    if (int_binarry[i + 1] == 1 && int_binarry[i + 2] == 0 && int_binarry[i + 3] == 1) {
                        vector.add(4);
                    }//4
                    if (int_binarry[i + 1] == 1 && int_binarry[i + 2] == 1 && int_binarry[i + 3] == 0) {
                        vector.add(5);
                    }//5
                    if (int_binarry[i + 1] == 1 && int_binarry[i + 2] == 1 && int_binarry[i + 3] == 1) {
                        vector.add(6);
                    }//6
                    i += 3;


                }

                if (int_binarry[i + 1] == 1 && int_binarry[i + 2] == 0) {
                    i += 2;
                    if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 0 && int_binarry[i + 3] == 0 && int_binarry[i + 4] == 0) {
                        vector.add(-14);
                    }
                    if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 0 && int_binarry[i + 3] == 0 && int_binarry[i + 4] == 1) {
                        vector.add(-13);
                    }
                    if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 0 && int_binarry[i + 3] == 1 && int_binarry[i + 4] == 0) {
                        vector.add(-12);
                    }
                    if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 0 && int_binarry[i + 3] == 1 && int_binarry[i + 4] == 1) {
                        vector.add(-11);
                    }
                    if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 1 && int_binarry[i + 3] == 0 && int_binarry[i + 4] == 0) {
                        vector.add(-10);
                    }
                    if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 1 && int_binarry[i + 3] == 0 && int_binarry[i + 4] == 1) {
                        vector.add(-9);
                    }
                    if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 1 && int_binarry[i + 3] == 1 && int_binarry[i + 4] == 0) {
                        vector.add(-8);
                    }
                    if (int_binarry[i + 1] == 0 && int_binarry[i + 2] == 1 && int_binarry[i + 3] == 1 && int_binarry[i + 4] == 1) {
                        vector.add(-7);
                    }
                    if (int_binarry[i + 1] == 1 && int_binarry[i + 2] == 0 && int_binarry[i + 3] == 0 && int_binarry[i + 4] == 0) {
                        vector.add(7);
                    }
                    if (int_binarry[i + 1] == 1 && int_binarry[i + 2] == 0 && int_binarry[i + 3] == 0 && int_binarry[i + 4] == 1) {
                        vector.add(8);
                    }
                    if (int_binarry[i + 1] == 1 && int_binarry[i + 2] == 0 && int_binarry[i + 3] == 1 && int_binarry[i + 4] == 0) {
                        vector.add(9);
                    }
                    if (int_binarry[i + 1] == 1 && int_binarry[i + 2] == 0 && int_binarry[i + 3] == 1 && int_binarry[i + 4] == 1) {
                        vector.add(10);
                    }
                    if (int_binarry[i + 1] == 1 && int_binarry[i + 2] == 1 && int_binarry[i + 3] == 0 && int_binarry[i + 4] == 0) {
                        vector.add(11);
                    }
                    if (int_binarry[i + 1] == 1 && int_binarry[i + 2] == 1 && int_binarry[i + 3] == 0 && int_binarry[i + 4] == 1) {
                        vector.add(12);
                    }
                    if (int_binarry[i + 1] == 1 && int_binarry[i + 2] == 1 && int_binarry[i + 3] == 1 && int_binarry[i + 4] == 0) {
                        vector.add(13);
                    }
                    if (int_binarry[i + 1] == 1 && int_binarry[i + 2] == 1 && int_binarry[i + 3] == 1 && int_binarry[i + 4] == 1) {
                        vector.add(14);
                    }

                    i = i + 4;


                }/*
                if(int_binarry[i+1]==1 && int_binarry[i+2]==1){
                    i+=2;
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==0 && int_binarry[i+3]==0 &&int_binarry[i+4]==0 ||int_binarry[i+5]==0  ){ vector.add(-30);}
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==0 && int_binarry[i+3]==0 &&int_binarry[i+4]==0 ||int_binarry[i+5]==1 ){ vector.add(-29);}
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==0 && int_binarry[i+3]==0 &&int_binarry[i+4]==1 ||int_binarry[i+5]==0 ){ vector.add(-28);}
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==0 && int_binarry[i+3]==0 &&int_binarry[i+4]==1 ||int_binarry[i+5]==1){ vector.add(-27);}
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==0 && int_binarry[i+3]==1 &&int_binarry[i+4]==0 ||int_binarry[i+5]==0){ vector.add(-26);}
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==0 && int_binarry[i+3]==1 &&int_binarry[i+4]==0 ||int_binarry[i+5]==1){ vector.add(-25);}
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==0 && int_binarry[i+3]==1 &&int_binarry[i+4]==1 ||int_binarry[i+5]==0){ vector.add(-24);}
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==0 && int_binarry[i+3]==1 &&int_binarry[i+4]==1 ||int_binarry[i+5]==1){ vector.add(-23);}
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==1 && int_binarry[i+3]==0 &&int_binarry[i+4]==0 ||int_binarry[i+5]==0){ vector.add(-22);}
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==1 && int_binarry[i+3]==0 &&int_binarry[i+4]==0 ||int_binarry[i+5]==1){ vector.add(-21);}
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==1 && int_binarry[i+3]==0 &&int_binarry[i+4]==1 ||int_binarry[i+5]==0){ vector.add(-20);}
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==1 && int_binarry[i+3]==0 &&int_binarry[i+4]==1 ||int_binarry[i+5]==1){ vector.add(-19);}
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==1 && int_binarry[i+3]==1 &&int_binarry[i+4]==0 ||int_binarry[i+5]==0){ vector.add(-18);}
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==1 && int_binarry[i+3]==1 &&int_binarry[i+4]==0 ||int_binarry[i+5]==1){ vector.add(-17);}
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==1 && int_binarry[i+3]==1 &&int_binarry[i+4]==1 ||int_binarry[i+5]==0){ vector.add(-19);}
                    if(int_binarry[i+1]==0 && int_binarry[i+2]==1 && int_binarry[i+3]==1 &&int_binarry[i+4]==1 ||int_binarry[i+5]==1){ vector.add(-15);}

                    if(int_binarry[i+1]==1 && int_binarry[i+2]==0 && int_binarry[i+3]==0 &&int_binarry[i+4]==0 ||int_binarry[i+5]==0  ){ vector.add(15);}
                    if(int_binarry[i+1]==1 && int_binarry[i+2]==0 && int_binarry[i+3]==0 &&int_binarry[i+4]==0 ||int_binarry[i+5]==1 ){ vector.add(16);}
                    if(int_binarry[i+1]==1 && int_binarry[i+2]==0 && int_binarry[i+3]==0 &&int_binarry[i+4]==1 ||int_binarry[i+5]==0 ){ vector.add(17);}
                    if(int_binarry[i+1]==1 && int_binarry[i+2]==0 && int_binarry[i+3]==0 &&int_binarry[i+4]==1 ||int_binarry[i+5]==1){ vector.add(18);}
                    if(int_binarry[i+1]==1 && int_binarry[i+2]==0 && int_binarry[i+3]==1 &&int_binarry[i+4]==0 ||int_binarry[i+5]==0){ vector.add(19);}
                    if(int_binarry[i+1]==1 && int_binarry[i+2]==0 && int_binarry[i+3]==1 &&int_binarry[i+4]==0 ||int_binarry[i+5]==1){ vector.add(20);}
                    if(int_binarry[i+1]==1 && int_binarry[i+2]==0 && int_binarry[i+3]==1 &&int_binarry[i+4]==1 ||int_binarry[i+5]==0){ vector.add(21);}
                    if(int_binarry[i+1]==1 && int_binarry[i+2]==0 && int_binarry[i+3]==1 &&int_binarry[i+4]==1 ||int_binarry[i+5]==1){ vector.add(22);}
                    if(int_binarry[i+1]==1 && int_binarry[i+2]==1 && int_binarry[i+3]==0 &&int_binarry[i+4]==0 ||int_binarry[i+5]==0){ vector.add(23);}
                    if(int_binarry[i+1]==1 && int_binarry[i+2]==1 && int_binarry[i+3]==0 &&int_binarry[i+4]==0 ||int_binarry[i+5]==1){ vector.add(24);}
                    if(int_binarry[i+1]==1 && int_binarry[i+2]==1 && int_binarry[i+3]==0 &&int_binarry[i+4]==1 ||int_binarry[i+5]==0){ vector.add(25);}
                    if(int_binarry[i+1]==1 && int_binarry[i+2]==1 && int_binarry[i+3]==0 &&int_binarry[i+4]==1 ||int_binarry[i+5]==1){ vector.add(26);}
                    if(int_binarry[i+1]==1 && int_binarry[i+2]==1 && int_binarry[i+3]==1 &&int_binarry[i+4]==0 ||int_binarry[i+5]==0){ vector.add(27);}
                    if(int_binarry[i+1]==1 && int_binarry[i+2]==1 && int_binarry[i+3]==1 &&int_binarry[i+4]==0 ||int_binarry[i+5]==1){ vector.add(28);}
                    if(int_binarry[i+1]==1 && int_binarry[i+2]==1 && int_binarry[i+3]==1 &&int_binarry[i+4]==1 ||int_binarry[i+5]==0){ vector.add(29);}
                    if(int_binarry[i+1]==1 && int_binarry[i+2]==1 && int_binarry[i+3]==1 &&int_binarry[i+4]==1 ||int_binarry[i+5]==1){ vector.add(30);}

                    i= i+5;
                }
*/

            }
          //TUKAJ IZDELAMO PONOVITVE
          if(int_binarry[i] == 0 && int_binarry[i+1] == 1){
                //System.out.println( "Ponovitve");
              if(int_binarry[i+2]==0 && int_binarry[i+3]==0 && int_binarry[i+4]==0){vector.add(0);}
              if(int_binarry[i+2]==0 && int_binarry[i+3]==0 && int_binarry[i+4]==1){ vector.add(0);vector.add(0);}
              if(int_binarry[i+2]==0 && int_binarry[i+3]==1 && int_binarry[i+4]==0){ vector.add(0);vector.add(0);vector.add(0);}
              if(int_binarry[i+2]==0 && int_binarry[i+3]==0 && int_binarry[i+4]==1){ vector.add(0);vector.add(0);vector.add(0);vector.add(0);}
              if(int_binarry[i+2]==1 && int_binarry[i+3]==1 && int_binarry[i+4]==1){ vector.add(0);vector.add(0);vector.add(0);vector.add(0);vector.add(0);}
              if(int_binarry[i+2]==1 && int_binarry[i+3]==1 && int_binarry[i+4]==0){ vector.add(0);vector.add(0);vector.add(0);vector.add(0);vector.add(0);}
              if(int_binarry[i+2]==1 && int_binarry[i+3]==1 && int_binarry[i+4]==1){ vector.add(0);vector.add(0);vector.add(0);vector.add(0);vector.add(0);vector.add(0);vector.add(0);}
              i=i+5;
              System.out.print("|");

            }

          ///CE SO ABSOLUTNE
/*
            if(int_binarry[i] == 1 && int_binarry[i+1] == 0){
                System.out.println( "ABS");
                boolean predznak =true;
                if( int_binarry[i+2]==0){ predznak = true; }
                else if( int_binarry[i+2]==1){ predznak = false;}

                if( int_binarry[i+3]==1){
                    sestevek_abs += 128;
                }
                if( int_binarry[i+4]==1){
                    sestevek_abs += 64;
                }
                if( int_binarry[i+5]==1){
                    sestevek_abs += 32;
                }
                if( int_binarry[i+6]==1){
                    sestevek_abs += 16;
                }
                if( int_binarry[i+7]==1){
                    sestevek_abs += 8;
                }
                if( int_binarry[i+8]==1){
                    sestevek_abs += 4;
                }
                if( int_binarry[i+9]==1){
                    sestevek_abs += 2;
                }
                if( int_binarry[i+10]==1){
                    sestevek_abs += 1;
                }



                if(predznak==true){

                    vector.add(sestevek_abs);
                }else if(predznak == false){
                    vector.add(-sestevek_abs);
                }

                i=i+11;

            }

*/

        }
        // PRIKAZ VEKTORJA
        System.out.println("The vector is: " + vector);

      //da convertam v iz vectoraj v int array
        int count = 0, ints[] = new int[vector.size()];
        for (int i : vector) ints[count++] = i;

        //samo za pregled
        for (int i = 0; i < ints.length; i++) {
            System.out.print("|" + ints[i] + "|");
        }

        System.out.println();
        //TODO sestej samo

        //da vrzem v drugiga, da bo  na i-1 ze postavljen na -1
        for (int j = 1; j < ints.length; j++) {
            ints[j - 1] = ints[j - 1];
            System.out.print("| " + ints[j]);
        }
        System.out.println();
        for (int i = 1; i < ints.length; i++)
        {
            ints[i] = ints[i] + ints[i - 1];
        }
        System.out.println();
        for (int i = 0; i < ints.length; i++)
        {
            //System.out.print(ints[i-1]);
           // ints[i] = ints[i] + ints[i - 1];

            System.out.print("|" + ints[i] + "|");
        }


        /*DATOTEKA KI JO BOMO ODPRLI*/
     //   boolean[] bits1 = new boolean[intArray.length];
       // PrintStream izpis1 = new PrintStream(new FileOutputStream("output.txt"));







    }
}
