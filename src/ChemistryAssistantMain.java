// Title: Chemistry Assistant
// Author: Gavin Austin
// Date Created: 2022
// Last Modified: 8/29/2023

import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.HashMap;

/**
 * Class: ChemistryAssistantMain
 * 
 * This class contains the main method for the program.
 * This class is used to prompt the user for what they would like to do.
 */
public class ChemistryAssistantMain {

  public static void prompt() {
    Scanner input = new Scanner(System.in);
    ChemErrorChecker errorChecker = new ChemErrorChecker();
    String choice = "";
    Element createdElement = null;

    System.out.println("|== Welcome to the Virtual Chemistry Assistant! ==|");
    System.out.println("What would you like to do?");
    System.out.println("Options:\n[1] Stoichiometry\n[2] Balance Equations\n[3] Quit" +
            "");

    choice = input.nextLine();

    if (choice.equalsIgnoreCase("3")) {
      System.out.println("Thank you for using the Virtual Chemistry Assistant!");
      System.exit(0);
    }

    if (choice.equalsIgnoreCase("1")) {
      while (!choice.equalsIgnoreCase("No")) {
        String element = "";
        boolean isElement = false;
        boolean isYesOrNo = false;
        boolean isCorrect = false;
        double mass = 0;
        double moles = 0;
        double molecules = 0;

        System.out.println("What is the element or compound?");

        element = input.next();
        input.nextLine();

        System.out.println("What are you given?\n [1] Mass\n [2] Moles\n [3] Molecules");
        int givenNum = 0;

        try {
          givenNum = input.nextInt();
          input.nextLine();
        } catch (InputMismatchException e) {
          System.out.println("Please enter a number.");
        }

        switch (givenNum) {
          case 1 :
            while (!isCorrect) {
              System.out.println("What is the given mass of the element or compound?");
              try {
                mass = input.nextDouble();
                input.nextLine();

                if (errorChecker.checkIfElement(element)) {
                  isCorrect = true;
                  createdElement = new Element(mass, -1, -1, element);
                } else {
                  isCorrect = true;
                  createdElement = new Compound(mass, -1, -1, element);
                }

              } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                isCorrect = false;
              }
            }

            break;
          case 2 :
            while (!isCorrect) {
              System.out.println("What is the given number of moles of the element or compound?");
              try {
                moles = input.nextDouble();
                input.nextLine();

                if (errorChecker.checkIfElement(element)) {
                  createdElement = new Element(-1, moles, -1, element);
                } else {
                  createdElement = new Compound(-1, moles, -1, element);
                }

                isCorrect = true;
              } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                isCorrect = false;
              }
            }

            break;
          case 3 :
            while (!isCorrect) {
              System.out.println("What are the given number of " +
                      "molecules of the element or compound?");
              try {
                molecules = input.nextDouble();
                input.nextLine();

                if (errorChecker.checkIfElement(element)) {
                  createdElement = new Element(-1, -1, molecules, element);
                } else {
                  createdElement = new Compound(-1, -1, molecules, element);
                }

                isCorrect = true;
              } catch (InputMismatchException e) {
                System.out.println("Please enter a number.");
                isCorrect = false;
              }
            }

            break;
        }

        System.out.println("\nThe molar mass of " + element
                + " is " + createdElement.getMolarMass() + " g/mol");
        System.out.println("The mass of the element is " +
                createdElement.getMass() + " g");
        System.out.println("The moles of the element is " +
                createdElement.getMoles() + " mol");
        System.out.println("The number of molecules of the element is " +
                createdElement.getMolecules() + " molecules");

        while (!isYesOrNo) {
          System.out.println("\nWould you like to convert something else? (Yes/No)");
          choice = input.next();
          isYesOrNo = errorChecker.checkYesOrNo(choice);
        }
      }

      prompt();
    }

  }

  public static void main(String[] args) {
    prompt();
  }
}

