package Model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class DofCalcTest
{
    @Test
    void hyperFocal()
    {
        Lens lens1 = new Lens("Canon", 1.8, 50);
        assertEquals("Canon", lens1.getMake());
        assertEquals(1.8, lens1.getMaxAperture());
        assertEquals(50, lens1.getFocalLength());

        Lens lens2 = new Lens("Tamron", 2.8, 90);
        assertEquals("Tamron", lens2.getMake());
        assertEquals(2.8, lens2.getMaxAperture());
        assertEquals(90, lens2.getFocalLength());

        Lens lens3 = new Lens("Sigma", 2.8, 200);
        assertEquals("Sigma", lens3.getMake());
        assertEquals(2.8, lens3.getMaxAperture());
        assertEquals(200, lens3.getFocalLength());

        DofCalc calc = new DofCalc();
        double aperture = 2;
        double coc = 0.029;
        double hypeF = calc.hyperFocal(lens1, aperture, coc)/1000;
        assertEquals(43.10, hypeF , 0.01);

        aperture = 4;
        hypeF = calc.hyperFocal(lens2, aperture, coc)/1000;
        assertEquals(69.83, hypeF , 0.01);

        aperture = 6;
        hypeF = calc.hyperFocal(lens3, aperture, coc)/1000;
        assertEquals(229.89, hypeF , 0.01);
    }

    @Test
    void nearFocal()
    {
        Lens lens1 = new Lens("Canon", 1.8, 50);
        assertEquals("Canon", lens1.getMake());
        assertEquals(1.8, lens1.getMaxAperture());
        assertEquals(50, lens1.getFocalLength());

        Lens lens2 = new Lens("Tamron", 2.8, 90);
        assertEquals("Tamron", lens2.getMake());
        assertEquals(2.8, lens2.getMaxAperture());
        assertEquals(90, lens2.getFocalLength());

        Lens lens3 = new Lens("Sigma", 2.8, 200);
        assertEquals("Sigma", lens3.getMake());
        assertEquals(2.8, lens3.getMaxAperture());
        assertEquals(200, lens3.getFocalLength());

        DofCalc calc = new DofCalc();
        double coc = 0.029;
        double aperture = 2;
        double dist = 1*1000; //convert to mm
        double nearF = calc.nearFocal(lens1, aperture, coc, dist)/1000;
        assertEquals(0.98, nearF, 0.01);

        aperture = 3;
        dist = 2*1000; //convert to mm
        nearF = calc.nearFocal(lens2, aperture, coc, dist)/1000;
        assertEquals(1.96, nearF, 0.01);

        aperture = 4;
        dist = 3*1000; //convert to mm
        nearF = calc.nearFocal(lens3, aperture, coc, dist)/1000;
        assertEquals(2.98, nearF, 0.01);
    }

    @Test
    void farFocal()
    {
        Lens lens1 = new Lens("Canon", 1.8, 50);
        assertEquals("Canon", lens1.getMake());
        assertEquals(1.8, lens1.getMaxAperture());
        assertEquals(50, lens1.getFocalLength());

        Lens lens2 = new Lens("Tamron", 2.8, 90);
        assertEquals("Tamron", lens2.getMake());
        assertEquals(2.8, lens2.getMaxAperture());
        assertEquals(90, lens2.getFocalLength());

        Lens lens3 = new Lens("Sigma", 2.8, 200);
        assertEquals("Sigma", lens3.getMake());
        assertEquals(2.8, lens3.getMaxAperture());
        assertEquals(200, lens3.getFocalLength());

        DofCalc calc = new DofCalc();
        double coc = 0.029;
        double aperture = 2;
        double dist = 1*1000; //convert to mm
        double farF = calc.farFocal(lens1, aperture, coc, dist)/1000;
        assertEquals(1.02, farF, 0.01);

        aperture = 3;
        dist = 2*1000; //convert to mm
        farF = calc.farFocal(lens2, aperture, coc, dist)/1000;
        assertEquals(2.04, farF, 0.01);

        aperture = 4;
        dist = 3*1000; //convert to mm
        farF = calc.farFocal(lens3, aperture, coc, dist)/1000;
        assertEquals(3.02, farF, 0.01);
    }

    @Test
    void depthOfField()
    {
        Lens lens1 = new Lens("Canon", 1.8, 50);
        assertEquals("Canon", lens1.getMake());
        assertEquals(1.8, lens1.getMaxAperture());
        assertEquals(50, lens1.getFocalLength());

        Lens lens2 = new Lens("Tamron", 2.8, 90);
        assertEquals("Tamron", lens2.getMake());
        assertEquals(2.8, lens2.getMaxAperture());
        assertEquals(90, lens2.getFocalLength());

        Lens lens3 = new Lens("Sigma", 2.8, 200);
        assertEquals("Sigma", lens3.getMake());
        assertEquals(2.8, lens3.getMaxAperture());
        assertEquals(200, lens3.getFocalLength());

        DofCalc calc = new DofCalc();
        double coc = 0.029;
        double aperture = 2;
        double dist = 1*1000; //convert to mm
        double dof = calc.depthOfField(lens1, aperture, coc, dist);
        //assertEquals(0.04, dof, 0.01);

        aperture = 3;
        dist = 2*1000; //convert to mm
        dof = calc.depthOfField(lens2, aperture, coc, dist)/1000;
        assertEquals(0.08, dof, 0.01);

        aperture = 4;
        dist = 3*1000; //convert to mm
        dof = calc.depthOfField(lens3, aperture, coc, dist)/1000;
        assertEquals(0.05, dof, 0.01);
    }
}