package Model;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class LensManager implements Iterable<Lens>
{
    private List<Lens> lensList = new ArrayList<>();

    public void add(Lens lens)
    {
        lensList.add(lens);
    }

    public List<Lens> getLensList()
    {
        return lensList;
    }

    public Lens get(int i)
    {
        return lensList.get(i);
    }

    public int size()
    {
        return lensList.size();
    }

    @Override
    public Iterator<Lens> iterator()
    {
        return lensList.iterator();
    }
}
