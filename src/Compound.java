import java.util.Scanner;

public class Compound extends Element{
  //data fields
  private double mass;
  private String symbol;
  private int atomicNum;
  private double molarMass;
  private double moles;
  private double molecules;


  //constructor
  public Compound(double mass, double moles, double molecules, String compound) {
    super(mass, moles, molecules, "dummy", compound);
  }

}
