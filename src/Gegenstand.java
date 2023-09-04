abstract public class Gegenstand {
    protected String name;
    protected String beschreibung;
    protected int wert;

    public Gegenstand(String name, int wert){
        this.name = name;
        this.wert = wert;
    }
    public Gegenstand(String name, String beschreibung, int wert){
        this.name = name;
        this.beschreibung = beschreibung;
        this.wert = wert;
    }
    @Override
    public String toString() {
        return getName();
    }
    abstract public int getWert();
    abstract public String getName();
    abstract public String getBeschreibung();
    abstract public void beschreibeDich();
}

