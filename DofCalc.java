package Model;

public class DofCalc
{
    public double hyperFocal(Lens lens, double selectedAperture, double confusionCircle)
    {
        double lensFocalLength = lens.getFocalLength();
        double lensFLengthSquared = lensFocalLength * lensFocalLength;
        return ((lensFLengthSquared) / (selectedAperture * confusionCircle));
    }

    public double nearFocal(Lens lens, double selectedAperture, double confusionCircle, double distance)
    {
        double hypeF = hyperFocal(lens, selectedAperture, confusionCircle);
        return ((hypeF * distance)/(hypeF + (distance - lens.getFocalLength())));
    }

    public double farFocal(Lens lens, double selectedAperture, double confusionCircle, double distance)
    {
        double hypeF = hyperFocal(lens, selectedAperture, confusionCircle);
        return ((hypeF * distance) / (hypeF - (distance - lens.getFocalLength())));
    }

    public double depthOfField(Lens lens, double selectedAperture, double confusionCircle, double distance)
    {
        double farF = farFocal(lens, selectedAperture, confusionCircle, distance);
        double nearF = nearFocal(lens, selectedAperture, confusionCircle, distance);
        return (farF - nearF);
    }
}
