import java.util.HashMap;
import java.util.Scanner;

public class Element extends Data{
  //data fields
  private double mass;
  private String symbol;
  private int atomicNum;
  private double molarMass;
  private double moles;
  private double molecules;

  //constructor
  public Element(double mass, double moles, double molecules, String symbol) {
    this.symbol = symbol;
    this.atomicNum = setAtomicNumber(symbol);
    this.molarMass = setMolarMass(this.atomicNum);

    if (mass >= 0) {
      this.mass = mass;
      this.moles = setMoles(mass, molarMass);
      this.molecules = setMolecules(this.moles);
    } else if (moles >= 0) {
      this.moles = moles;
      this.mass = setMass(moles, molarMass);
      this.molecules = setMolecules(this.moles);
    } else if (molecules >= 0) {
      this.molecules = molecules;
      this.moles = setMoles(molecules);
      this.mass = setMass(this.moles, molarMass);
    }
  }

  public Element(double mass, double moles, double molecules, String dummy, String compound) {
    this.molarMass = getMolarMassFromCompound(compound);

    if (mass >= 0) {
      this.mass = mass;
      this.moles = setMoles(mass, molarMass);
      this.molecules = setMolecules(this.moles);
    } else if (moles >= 0) {
      this.moles = moles;
      this.mass = setMass(moles, molarMass);
      this.molecules = setMolecules(this.moles);
    } else if (molecules >= 0) {
      this.molecules = molecules;
      this.moles = setMoles(molecules);
      this.mass = setMass(this.moles, molarMass);
    }
  }

  private static int setAtomicNumber(String element) {
    int atomicNumber = 0;

    populateHash(chemConstantLog);

    // Loop through the HashMap and find the key that matches the element
    for (int i = 1; i < chemConstantLog.size() + 1; i++) {
      if (chemConstantLog.get(i).equalsIgnoreCase(element)) {
        atomicNumber = i;
      }
    }

    return atomicNumber;
  }

  private double setMass(double moles, double molarMass) {
    double mass = moles * molarMass;
    return mass;
  }

  public double getMass() {
    return this.mass;
  }

  private double setMoles(double mass, double molarMass) {
    double moles = mass / molarMass;
    return moles;
  }

  public double getMoles() {
    return this.moles;
  }

  private double setMolecules(double moles) {
    double avogadro = 6.022 * Math.pow(10, 23);
    double molecules = 0.0;
    molecules = moles * avogadro;
    return molecules;
  }

  private double setMoles(double molecules) {
    double avogadro = 6.022 * Math.pow(10, 23);
    double moles = 0.0;
    moles = molecules / avogadro;
    return moles;
  }

  public double getMolecules() {
    return this.molecules;
  }

  public double getMolarMass() {
    return this.molarMass;
  }

  private static double getMolarMassFromCompound(String compound) {
    double totalMass = 0;
    int i = 0;

    while (i < compound.length()) {
      char ch = compound.charAt(i);
      String element = "";

      if (Character.isUpperCase(ch)) {
        element += ch;
        i++;

        while (i < compound.length() && Character.isLowerCase(compound.charAt(i))) {
          element += compound.charAt(i);
          i++;
        }

        int subscript = 1;
        if (i < compound.length() && Character.isDigit(compound.charAt(i))) {
          subscript = 0;

          while (i < compound.length() && Character.isDigit(compound.charAt(i))) {
            subscript = subscript * 10 + (compound.charAt(i) - '0');
            i++;
          }
        }

        totalMass += getElementMass(element) * subscript;
      } else if (ch == '(') {
        int closingIndex = findClosingIndex(compound, i);
        String subCompound = compound.substring(i + 1, closingIndex);
        i = closingIndex + 1;

        int subscript = 1;
        if (i < compound.length() && Character.isDigit(compound.charAt(i))) {
          subscript = 0;

          while (i < compound.length() && Character.isDigit(compound.charAt(i))) {
            subscript = subscript * 10 + (compound.charAt(i) - '0');
            i++;
          }
        }

        totalMass += getMolarMassFromCompound(subCompound) * subscript;
      } else if (ch == '[') {
        int closingIndex = findClosingIndex(compound, i);
        String subCompound = compound.substring(i + 1, closingIndex);
        i = closingIndex + 1;

        int subscript = 1;
        if (i < compound.length() && Character.isDigit(compound.charAt(i))) {
          subscript = 0;

          while (i < compound.length() && Character.isDigit(compound.charAt(i))) {
            subscript = subscript * 10 + (compound.charAt(i) - '0');
            i++;
          }
        }

        totalMass += getElementMass(subCompound) * subscript;
      } else {
        // Error: unexpected character
        return -1;
      }
    }

    return totalMass;
  }

  private static int findClosingIndex(String compound, int openingIndex) {
    int closingIndex = openingIndex + 1;
    int nestingLevel = 1;

    while (closingIndex < compound.length() && nestingLevel > 0) {
      char ch = compound.charAt(closingIndex);

      if (ch == '(' || ch == '[') {
        nestingLevel++;
      } else if (ch == ')' || ch == ']') {
        nestingLevel--;
      }

      closingIndex++;
    }

    return closingIndex - 1;
  }

  private static double getElementMass(String element) {
    return setMolarMass(setAtomicNumber(element));
  }

  private static double setMolarMass(int atomicNumber) {
    double molarMass = 0;
    switch (atomicNumber) {
      case 1:
        molarMass = 1.00794;
        break;
      case 2:
        molarMass = 4.002602;
        break;
      case 3:
        molarMass = 6.941;
        break;
      case 4:
        molarMass = 9.012182;
        break;
      case 5:
        molarMass = 10.811;
        break;
      case 6:
        molarMass = 12.0107;
        break;
      case 7:
        molarMass = 14.0067;
        break;
      case 8:
        molarMass = 15.9994;
        break;
      case 9:
        molarMass = 18.9984032;
      case 10:
        molarMass = 20.1797;
        break;
      case 11:
        molarMass = 22.98976928;
        break;
      case 12:
        molarMass = 24.3050;
        break;
      case 13:
        molarMass = 26.9815386;
        break;
      case 14:
        molarMass = 28.0855;
        break;
      case 15:
        molarMass = 30.973762;
        break;
      case 16:
        molarMass = 32.065;
        break;
      case 17:
        molarMass = 35.453;
        break;
      case 18:
        molarMass = 39.948;
        break;
      case 19:
        molarMass = 39.0983;
        break;
      case 20:
        molarMass = 40.078;
        break;
      case 21:
        molarMass = 44.955912;
        break;
      case 22:
        molarMass = 47.867;
        break;
      case 23:
        molarMass = 50.9415;
        break;
      case 24:
        molarMass = 51.9961;
        break;
      case 25:
        molarMass = 54.938045;
        break;
      case 26:
        molarMass = 55.845;
        break;
      case 27:
        molarMass = 58.933195;
        break;
      case 28:
        molarMass = 58.6934;
        break;
      case 29:
        molarMass = 63.546;
        break;
      case 30:
        molarMass = 65.38;
        break;
      case 31:
        molarMass = 69.723;
        break;
      case 32:
        molarMass = 72.63;
        break;
      case 33:
        molarMass = 74.92160;
        break;
      case 34:
        molarMass = 78.96;
        break;
      case 35:
        molarMass = 79.904;
        break;
      case 36:
        molarMass = 83.798;
        break;
      case 37:
        molarMass = 85.4678;
        break;
      case 38:
        molarMass = 87.62;
        break;
      case 39:
        molarMass = 88.90585;
        break;
      case 40:
        molarMass = 91.224;
        break;
      case 41:
        molarMass = 92.90638;
        break;
      case 42:
        molarMass = 95.96;
        break;
      case 43:
        molarMass = 98;
        break;
      case 44:
        molarMass = 101.07;
        break;
      case 45:
        molarMass = 102.90550;
        break;
      case 46:
        molarMass = 106.42;
        break;
      case 47:
        molarMass = 107.8682;
        break;
      case 48:
        molarMass = 112.411;
        break;
      case 49:
        molarMass = 114.818;
        break;
      case 50:
        molarMass = 118.710;
        break;
      case 51:
        molarMass = 121.760;
        break;
      case 52:
        molarMass = 127.60;
        break;
      case 53:
        molarMass = 126.90447;
        break;
      case 54:
        molarMass = 131.293;
        break;
      case 55:
        molarMass = 132.9054519;
        break;
      case 56:
        molarMass = 137.327;
        break;
      case 57:
        molarMass = 138.90547;
        break;
      case 58:
        molarMass = 140.116;
        break;
      case 59:
        molarMass = 140.90765;
        break;
      case 60:
        molarMass = 144.242;
        break;
      case 61:
        molarMass = 145;
        break;
      case 62:
        molarMass = 150.36;
        break;
      case 63:
        molarMass = 151.964;
        break;
      case 64:
        molarMass = 157.25;
        break;
      case 65:
        molarMass = 158.92535;
        break;
      case 66:
        molarMass = 162.500;
        break;
      case 67:
        molarMass = 164.93032;
        break;
      case 68:
        molarMass = 167.259;
        break;
      case 69:
        molarMass = 168.93421;
        break;
      case 70:
        molarMass = 173.054;
        break;
      case 71:
        molarMass = 174.9668;
        break;
      case 72:
        molarMass = 178.49;
        break;
      case 73:
        molarMass = 180.94788;
        break;
      case 74:
        molarMass = 183.84;
        break;
      case 75:
        molarMass = 186.207;
        break;
      case 76:
        molarMass = 190.23;
        break;
      case 77:
        molarMass = 192.217;
        break;
      case 78:
        molarMass = 195.084;
        break;
      case 79:
        molarMass = 196.966569;
        break;
      case 80:
        molarMass = 200.59;
        break;
      case 81:
        molarMass = 204.3833;
        break;
      case 82:
        molarMass = 207.2;
        break;
      case 83:
        molarMass = 208.98040;
        break;
      case 84:
        molarMass = 209;
        break;
      case 85:
        molarMass = 210;
        break;
      case 86:
        molarMass = 222;
        break;
      case 87:
        molarMass = 223;
        break;
      case 88:
        molarMass = 226;
        break;
      case 89:
        molarMass = 227;
        break;
      case 90:
        molarMass = 232.03806;
        break;
      case 91:
        molarMass = 231.03588;
        break;
      case 92:
        molarMass = 238.02891;
        break;
      case 93:
        molarMass = 237;
        break;
      case 94:
        molarMass = 244;
        break;
      case 95:
        molarMass = 243;
        break;
      case 96:
        molarMass = 247;
        break;
      case 97:
        molarMass = 247;
        break;
      case 98:
        molarMass = 251;
        break;
      case 99:
        molarMass = 252;
        break;
      case 100:
        molarMass = 257;
        break;
      case 101:
        molarMass = 258;
        break;
      case 102:
        molarMass = 259;
        break;
      case 103:
        molarMass = 262;
        break;
      case 104:
        molarMass = 261;
        break;
      case 105:
        molarMass = 262;
        break;
      case 106:
        molarMass = 266;
        break;
      case 107:
        molarMass = 264;
        break;
      case 108:
        molarMass = 277;
        break;
      case 109:
        molarMass = 268;
        break;
      case 110:
        molarMass = 271;
        break;
      case 111:
        molarMass = 272;
        break;
      case 112:
        molarMass = 285;
        break;
      case 113:
        molarMass = 284;
        break;
      case 114:
        molarMass = 289;
        break;
      case 115:
        molarMass = 288;
        break;
      case 116:
        molarMass = 292;
        break;
      case 117:
        molarMass = 294;
        break;
      case 118:
        molarMass = 294;
        break;
    }

    return molarMass;
  }

}