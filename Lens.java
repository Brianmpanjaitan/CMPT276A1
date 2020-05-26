package Model;

public class Lens
{
    private String make;
    private double maxAperture;
    private double focalLength;

    public Lens(String make, double maxAperture, double focalLength)
    {
        this.make = make;
        this.maxAperture = maxAperture;
        this.focalLength = focalLength;
    }

    // Get & Set make
    public String getMake()
    {
        return make;
    }

    public void setMake(String make)
    {
        this.make = make;
    }

    // Get & Set maxAperture
    public double getMaxAperture()
    {
        return maxAperture;
    }

    public void setMaxAperture(double maxAperture)
    {
        this.maxAperture = maxAperture;
    }

    // Get & Set focalLength
    public double getFocalLength()
    {
        return focalLength;
    }

    public void setFocalLength(double focalLength)
    {
        this.focalLength = focalLength;
    }

    @Override
    public String toString()
    {
        return make + " " + focalLength + "mm" + " " + "F" + maxAperture;
    }
}
