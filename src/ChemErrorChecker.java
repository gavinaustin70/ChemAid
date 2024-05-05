public class ChemErrorChecker extends Data{
  /**
   * Checks if the input is valid.
   * @param allegedString The input to be checked.
   */
  public static boolean checkIfElement(String allegedString) {
    populateHash(chemConstantLog);

    for (int i = 1; i < chemConstantLog.size() + 1; i++) {
      if (chemConstantLog.get(i).equalsIgnoreCase(allegedString)) {
        return true;
      }
    }

    return false;
  }

  public static boolean checkYesOrNo(String allegedString) {
    ChemistryAssistantMain chemAssist = new ChemistryAssistantMain();

    if (allegedString.equalsIgnoreCase("yes") || allegedString.equalsIgnoreCase("no")) {
      return true;
    } else {
      System.out.println("Invalid input. Please enter a valid input.");
    }
    return false;
  }

  public static boolean checkIfNumber(String allegedString) {
    try {
      Integer.parseInt(allegedString);
      return true;
    } catch (NumberFormatException e) {
      return false;
    }
  }
}

