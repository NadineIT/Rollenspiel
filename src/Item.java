public class Item extends Gegenstand {

    protected int staerke;
    protected String beeinflusst;

    public Item(String name, int wert, int staerke, String beeinflusst) {
        super(name, wert);
        this.staerke = staerke;
        this.beeinflusst = beeinflusst;
    }
    public Item(String name, String beschreibung, int wert, int staerke, String beeinflusst) {
        super(name, beschreibung, wert);
        this.staerke = staerke;
        this.beeinflusst = beeinflusst;
    }
    public int getStaerke() {
        return staerke;
    }
    public String getBeeinflusst() {
        return beeinflusst;
    }

    @Override
    public int getWert() {
        return wert;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public String getBeschreibung() {
        return beschreibung;
    }

    @Override
    public void beschreibeDich() {
        {
            System.out.println("Name: " + name);
            System.out.println();
            System.out.println("------------------------------");
            System.out.println();
            if (beschreibung != null) {
                System.out.println("Beschreibung");
            }else {
                System.out.println("Keine Beschreibung vorhanden");
            }
        }
    }
}
