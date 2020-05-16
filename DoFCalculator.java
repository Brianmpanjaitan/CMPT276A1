package Model;

public class DoFCalculator
{
    public double hyperFocal(Lens lens, double aperatureChoice, double COC)
    {
        return ((lens.getFocalLength() * lens.getFocalLength()) / (aperatureChoice * COC));
    }

    public double nearFocal(Lens lens, double aperatureChoice, double COC, double distance)
    {
        double hyperF =  hyperFocal(lens, aperatureChoice, COC);
        return ((hyperF * distance) / (hyperF + (distance - lens.getFocalLength())));
    }

    public double farFocal(Lens lens, double aperatureChoice, double COC, double distance)
    {
        double hyperF =  hyperFocal(lens, aperatureChoice, COC );
        if (distance > hyperF)
        {
            return Double.POSITIVE_INFINITY;
        }
        return ((hyperF * distance) / (hyperF - (distance - lens.getFocalLength())));
    }

    public double DOF(Lens lens, double aperatureChoice, double COC, double distance)
    {
        double nFocal = nearFocal(lens, aperatureChoice, COC, distance);
        double fFocal = farFocal(lens, aperatureChoice, COC, distance);
        return fFocal - nFocal;
    }
}
