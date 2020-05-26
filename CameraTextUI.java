package TextUI;

import Model.Lens;
import Model.DofCalc;
import Model.LensManager;

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
        // BEGIN SAMPLE USING SCREEN AND KEYBOARD:
        // (remove this: it's just to show you how to access the screen and keyboard!)
        /*
        System.out.println("Enter an integer: ");
        System.out.print(": ");
        int count = in.nextInt();

        System.out.println("Enter an double: ");
        System.out.print(": ");
        double value = in.nextDouble();

        System.out.println("Printing " + value + " out " + count + " times (with formatting)!");
        for (int i = 0; i < count; i++) {
            System.out.println(" --> " + formatM(value));
        }
        */

        // END SAMPLE

        DofCalc calc = new DofCalc();
        int lens;
        double aperture;
        double dist;
        double near;
        double far;
        double depth;
        double hyperF;

        boolean check = false;

        while(check == false)
        {
            System.out.println("Lenses to pick from");//UI for user
            for (int i = 0; i < manager.size(); i++ )
            {
                System.out.println("  " + i + ". " + manager.get(i));
            }
            System.out.println("  (-1 to exit)");
            System.out.print(": ");
            System.out.print("Select a lens: ");

            lens = in.nextInt();

            if(lens == 0)
            {
                System.out.print("Aperture [the F number]: ");
                aperture = in.nextDouble();
                if (aperture < manager.get(lens).getMaxAperture())
                {
                    System.out.println("ERROR: This aperture is not possible with this lens");
                    break;
                }
                System.out.print("Distance to subject [m] : ");
                dist  = in.nextDouble() * 1000; //convert units to mm

                near = calc.nearFocal(manager.get(0), aperture, COC, dist)/1000; //convert back in to mm
                far = calc.farFocal(manager.get(0), aperture, COC, dist)/1000;
                depth = calc.depthOfField(manager.get(0), aperture, COC, dist)/1000;
                hyperF = calc.hyperFocal(manager.get(0), aperture, COC) / 1000;

                System.out.println("  In focus: " + formatM(near) + "m to " + formatM(far) + "m [DoF = " + formatM(depth) +  "m]");
                System.out.println("  Hyperfocal point: " + formatM(hyperF) + "m");
            }
            else if(lens == 1)
            {
                System.out.print("Aperture [the F number]: ");
                aperture = in.nextDouble();
                if (aperture < manager.get(lens).getMaxAperture())
                {
                    System.out.println("ERROR: This aperture is not possible with this lens");
                    break;
                }
                System.out.print("Distance to subject [m] : ");
                dist  = in.nextDouble() * 1000;

                near = calc.nearFocal(manager.get(1), aperture, COC, dist)/1000;
                far = calc.farFocal(manager.get(1), aperture, COC, dist)/1000;
                depth = calc.depthOfField(manager.get(1), aperture, COC, dist)/1000;
                hyperF = calc.hyperFocal(manager.get(1), aperture, COC) / 1000;

                System.out.println("  In focus: " + formatM(near) + "m to " + formatM(far) + "m [DoF = " + formatM(depth) +  "m]");
                System.out.println("  Hyperfocal point: " + formatM(hyperF) + "m");
            }
            else if(lens == 2)
            {
                System.out.print("Aperture [the F number]: ");
                aperture = in.nextDouble();
                if (aperture < manager.get(lens).getMaxAperture())
                {
                    System.out.println("ERROR: This aperture is not possible with this lens");
                    break;
                }
                System.out.print("Distance to subject [m] : ");
                dist  = in.nextDouble() * 1000;

                near = calc.nearFocal(manager.get(2), aperture, COC, dist)/1000;
                far = calc.farFocal(manager.get(2), aperture, COC, dist)/1000;
                depth = calc.depthOfField(manager.get(2), aperture, COC, dist)/1000;
                hyperF = calc.hyperFocal(manager.get(2), aperture, COC) / 1000;

                System.out.println("  In focus: " + formatM(near) + "m to " + formatM(far) + "m [DoF = " + formatM(depth) +  "m]");
                System.out.println("  Hyperfocal point: " + formatM(hyperF) + "m");
            }
            else if(lens == 3)
            {
                System.out.print("Aperture [the F number]: ");
                aperture = in.nextDouble();
                if (aperture < manager.get(lens).getMaxAperture())
                {
                    System.out.println("ERROR: This aperture is not possible with this lens");
                    break;
                }
                System.out.print("Distance to subject [m] : ");
                dist  = in.nextDouble() * 1000;

                near = calc.nearFocal(manager.get(3), aperture, COC, dist)/1000;
                far = calc.farFocal(manager.get(3), aperture, COC, dist)/1000;
                depth = calc.depthOfField(manager.get(3), aperture, COC, dist)/1000;
                hyperF = calc.hyperFocal(manager.get(3), aperture, COC) / 1000;

                System.out.println("  In focus: " + formatM(near) + "m to " + formatM(far) + "m [DoF = " + formatM(depth) +  "m]");
                System.out.println("  Hyperfocal point: " + formatM(hyperF) + "m");
            }
            else if(lens == -1) // End the program
            {
                check = true;
                break;
            }
            else // Lens is out of index
            {
                System.out.println("Error: Invalid lens index.");
            }
        }
    }

    private String formatM(double distanceInM)
    {
        DecimalFormat df = new DecimalFormat("0.00");
        return df.format(distanceInM);
    }
}
