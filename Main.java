import Model.LensManager;
import TextUI.CameraTextUI;

public class Main
{
    public static void main(String args[])
    {
        LensManager manager = new LensManager();
        CameraTextUI ui = new CameraTextUI(manager);
        ui.show();
    }
}
