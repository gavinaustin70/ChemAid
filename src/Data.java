import java.util.HashMap;

/**
 * This class contains the data for the program.
 * This includes the periodic table and the constants.
 * This class is used to populate the HashMaps in the ChemErrorChecker class.
 */
public class Data {

  /**
   * This HashMap contains the elements and their atomic numbers.
   */
  public static HashMap<Integer, String> chemConstantLog = new HashMap<Integer, String>();

  /**
   * This HashMap contains the elements and their atomic numbers.
   * 
   * (Eventually hoping to just webscrape this data)
   */
  public static void populateHash(HashMap<Integer, String> chemConstantLog) {

    chemConstantLog.put(1, "H");
    chemConstantLog.put(2, "He");
    chemConstantLog.put(3, "Li");
    chemConstantLog.put(4, "Be");
    chemConstantLog.put(5, "B");
    chemConstantLog.put(6, "C");
    chemConstantLog.put(7, "N");
    chemConstantLog.put(8, "O");
    chemConstantLog.put(9, "F");
    chemConstantLog.put(10, "Ne");
    chemConstantLog.put(11, "Na");
    chemConstantLog.put(12, "Mg");
    chemConstantLog.put(13, "Al");
    chemConstantLog.put(14, "Si");
    chemConstantLog.put(15, "P");
    chemConstantLog.put(16, "S");
    chemConstantLog.put(17, "Cl");
    chemConstantLog.put(18, "Ar");
    chemConstantLog.put(19, "K");
    chemConstantLog.put(20, "Ca");
    chemConstantLog.put(21, "Sc");
    chemConstantLog.put(22, "Ti");
    chemConstantLog.put(23, "V");
    chemConstantLog.put(24, "Cr");
    chemConstantLog.put(25, "Mn");
    chemConstantLog.put(26, "Fe");
    chemConstantLog.put(27, "Co");
    chemConstantLog.put(28, "Ni");
    chemConstantLog.put(29, "Cu");
    chemConstantLog.put(30, "Zn");
    chemConstantLog.put(31, "Ga");
    chemConstantLog.put(32, "Ge");
    chemConstantLog.put(33, "As");
    chemConstantLog.put(34, "Se");
    chemConstantLog.put(35, "Br");
    chemConstantLog.put(36, "Kr");
    chemConstantLog.put(37, "Rb");
    chemConstantLog.put(38, "Sr");
    chemConstantLog.put(39, "Y");
    chemConstantLog.put(40, "Zr");
    chemConstantLog.put(41, "Nb");
    chemConstantLog.put(42, "Mo");
    chemConstantLog.put(43, "Tc");
    chemConstantLog.put(44, "Ru");
    chemConstantLog.put(45, "Rh");
    chemConstantLog.put(46, "Pd");
    chemConstantLog.put(47, "Ag");
    chemConstantLog.put(48, "Cd");
    chemConstantLog.put(49, "In");
    chemConstantLog.put(50, "Sn");
    chemConstantLog.put(51, "Sb");
    chemConstantLog.put(52, "Te");
    chemConstantLog.put(53, "I");
    chemConstantLog.put(54, "Xe");
    chemConstantLog.put(55, "Cs");
    chemConstantLog.put(56, "Ba");
    chemConstantLog.put(57, "La");
    chemConstantLog.put(58, "Ce");
    chemConstantLog.put(59, "Pr");
    chemConstantLog.put(60, "Nd");
    chemConstantLog.put(61, "Pm");
    chemConstantLog.put(62, "Sm");
    chemConstantLog.put(63, "Eu");
    chemConstantLog.put(64, "Gd");
    chemConstantLog.put(65, "Tb");
    chemConstantLog.put(66, "Dy");
    chemConstantLog.put(67, "Ho");
    chemConstantLog.put(68, "Er");
    chemConstantLog.put(69, "Tm");
    chemConstantLog.put(70, "Yb");
    chemConstantLog.put(71, "Lu");
    chemConstantLog.put(72, "Hf");
    chemConstantLog.put(73, "Ta");
    chemConstantLog.put(74, "W");
    chemConstantLog.put(75, "Re");
    chemConstantLog.put(76, "Os");
    chemConstantLog.put(77, "Ir");
    chemConstantLog.put(78, "Pt");
    chemConstantLog.put(79, "Au");
    chemConstantLog.put(80, "Hg");
    chemConstantLog.put(81, "Tl");
    chemConstantLog.put(82, "Pb");
    chemConstantLog.put(83, "Bi");
    chemConstantLog.put(84, "Po");
    chemConstantLog.put(85, "At");
    chemConstantLog.put(86, "Rn");
    chemConstantLog.put(87, "Fr");
    chemConstantLog.put(88, "Ra");
    chemConstantLog.put(89, "Ac");
    chemConstantLog.put(90, "Th");
    chemConstantLog.put(91, "Pa");
    chemConstantLog.put(92, "U");
    chemConstantLog.put(93, "Np");
    chemConstantLog.put(94, "Pu");
    chemConstantLog.put(95, "Am");
    chemConstantLog.put(96, "Cm");
    chemConstantLog.put(97, "Bk");
    chemConstantLog.put(98, "Cf");
    chemConstantLog.put(99, "Es");
    chemConstantLog.put(100, "Fm");
    chemConstantLog.put(101, "Md");
    chemConstantLog.put(102, "No");
    chemConstantLog.put(103, "Lr");
    chemConstantLog.put(104, "Rf");
    chemConstantLog.put(105, "Db");
    chemConstantLog.put(106, "Sg");
    chemConstantLog.put(107, "Bh");
    chemConstantLog.put(108, "Hs");
    chemConstantLog.put(109, "Mt");
    chemConstantLog.put(110, "Ds");
    chemConstantLog.put(111, "Rg");
    chemConstantLog.put(112, "Cn");
    chemConstantLog.put(113, "Nh");
    chemConstantLog.put(114, "Fl");
    chemConstantLog.put(115, "Mc");
    chemConstantLog.put(116, "Lv");
    chemConstantLog.put(117, "Ts");
    chemConstantLog.put(118, "Og");
  }
}
