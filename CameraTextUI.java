package TextUI;

import Model.Lens;
import Model.LensManager;
import Model.DoFCalculator;

import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Sample (incomplete) text UI to interact with the user.
 * You may change any part of this!
 */
public class CameraTextUI
{
    private static final double COC = 0.029;    // "Circle of Confusion" for a "Full Frame" camera
    private LensManager manager;
    private Scanner in = new Scanner(System.in);// Read from keyboard


    public CameraTextUI(LensManager manager)
    {
        // Accept and store a reference to the lens manager (the model)
        // (this design is called "dependency injection")
        this.manager = manager;
        // Populate lenses (Make, max aperture (smallest supported F number), focal length [mm]):
        manager.add(new Lens("Canon", 1.8, 50));
        manager.add(new Lens("Tamron", 2.8, 90));
        manager.add(new Lens("Sigma", 2.8, 200));
        manager.add(new Lens("Nikon", 4, 200));
    }

    public void show()
    {
        DoFCalculator calc = new DoFCalculator();
        //loop for UI
        boolean isDone = false;
        while(!isDone){
            System.out.println("Lenses to pick from");//UI for user
            for (int i = 0; i < manager.size(); i++ )
            {
                System.out.println("  " + i + ". " + manager.get(i));
            }
            System.out.println("  (-1 to exit)");
            System.out.print(": ");

            //variables to take in user input
            double near;
            double far;
            double Depth;
            double hyperF;
            int choice = in.nextInt();
            double aperatureChoice;
            double distance;

            //case for each of the lenses
            switch(choice)
            {
                case 0:
                    System.out.print("Aperature [the F number] : ");
                    aperatureChoice = in.nextDouble();
                    if (aperatureChoice < manager.get(0).getMaxAperture())
                    {
                        System.out.println("ERROR: This aperature is not available with this lens");
                        break;
                    }
                    System.out.print("Distance to subject [m] : ");
                    distance  = in.nextDouble() * 1000; //convert m to mm
                    near = calc.nearFocal(manager.get(0), aperatureChoice, COC, distance)/1000; //converting back in to mm
                    far = calc.farFocal(manager.get(0), aperatureChoice, COC, distance)/1000;
                    Depth = calc.DOF(manager.get(0), aperatureChoice, COC, distance)/1000;
                    hyperF = calc.hyperFocal(manager.get(0), aperatureChoice, COC) / 1000;
                    System.out.println("  In focus: " + formatM(near) + "m to " + formatM(far) + "m [DoF = " + formatM(Depth) +  "m]");
                    System.out.println("  Hyperfocal point: " + formatM(hyperF) + "m");
                    break;

                case 1:
                    System.out.print("Aperature [the F number] : ");
                    aperatureChoice = in.nextDouble();
                    if (aperatureChoice < manager.get(1).getMaxAperture())
                    {
                        System.out.println("ERROR: This aperature is not available with this lens");
                        break;
                    }
                    System.out.print("Distance to subject [m] : ");
                    distance  = in.nextDouble() * 1000;
                    near = calc.nearFocal(manager.get(1), aperatureChoice, COC, distance)/1000;
                    far = calc.farFocal(manager.get(1), aperatureChoice, COC, distance)/1000;
                    Depth = calc.DOF(manager.get(1), aperatureChoice, COC, distance)/1000;
                    hyperF = calc.hyperFocal(manager.get(1), aperatureChoice, COC) / 1000;
                    System.out.println("  In focus: " + formatM(near) + "m to " + formatM(far) + "m [DoF = " + formatM(Depth) +  "m]");
                    System.out.println("  Hyperfocal point: " + formatM(hyperF) + "m");
                    break;

                case 2:
                    System.out.print("Aperature [the F number] : ");
                    aperatureChoice = in.nextDouble();
                    if (aperatureChoice < manager.get(2).getMaxAperture())
                    {
                        System.out.println("ERROR: This aperature is not available with this lens");
                        break;
                    }
                    System.out.print("Distance to subject [m] : ");
                    distance  = in.nextDouble() * 1000;
                    near = calc.nearFocal(manager.get(2), aperatureChoice, COC, distance)/1000;
                    far = calc.farFocal(manager.get(2), aperatureChoice, COC, distance)/1000;
                    Depth = calc.DOF(manager.get(2), aperatureChoice, COC, distance)/1000;
                    hyperF = calc.hyperFocal(manager.get(2), aperatureChoice, COC) / 1000;
                    System.out.println("  In focus: " + formatM(near) + "m to " + formatM(far) + "m [DoF = " + formatM(Depth) +  "m]");
                    System.out.println("  Hyperfocal point: " + formatM(hyperF) + "m");
                    break;

                case 3:
                    System.out.print("Aperature [the F number] : ");
                    aperatureChoice = in.nextDouble();
                    if (aperatureChoice < manager.get(3).getMaxAperture())
                    {
                        System.out.println("ERROR: This aperature is not available with this lens");
                        break;
                    }
                    System.out.print("Distance to subject [m] : ");
                    distance  = in.nextDouble() * 1000;
                    near = calc.nearFocal(manager.get(3), aperatureChoice, COC, distance)/1000;
                    far = calc.farFocal(manager.get(3), aperatureChoice, COC, distance)/1000;
                    Depth = calc.DOF(manager.get(3), aperatureChoice, COC, distance)/1000;
                    hyperF = calc.hyperFocal(manager.get(3), aperatureChoice, COC) / 1000;
                    System.out.println("  In focus: " + formatM(near) + "m to " + formatM(far) + "m [DoF = " + formatM(Depth) +  "m]");
                    System.out.println("  Hyperfocal point: " + formatM(hyperF) + "m");
                    break;

                case -1:
                    isDone = true;
                    break;

                default:
                    System.out.println("Error: Invalid lens index."); //error statement when a case is not picked
            }
        }
    }

    private String formatM(double distanceInM)
    {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distanceInM);
    }
}
