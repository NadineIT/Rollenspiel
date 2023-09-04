public class Ruestung extends Gegenstand {
    protected int abwehr;
    protected int magieAbwehr;
    protected int staerke;
    protected int geschicklichkeit;
    protected int konstitution;
    protected int intelligenz;
    protected int weisheit;
    protected int charisma;
    protected String kategorie;
    protected Material material;

    public Ruestung(String name, String kategorie, Material material, int wert, int abwehr, int magieAbwehr) {
        super(name, name + " ist ein " + kategorie + " aus " + material ,wert);
        this.kategorie = kategorie;
        this.material = material;
        this.abwehr = abwehr;
        this.magieAbwehr = magieAbwehr;
        this.staerke = 0;
        this.geschicklichkeit = 0;
        this.konstitution = 0;
        this.intelligenz = 0;
        this.weisheit = 0;
        this.charisma = 0;
    }
    public Ruestung(String name, String kategorie, Material material, int wert, int abwehr, int magieAbwehr,
                    int staerke, int geschicklichkeit, int konstitution, int intelligenz, int weisheit, int charisma) {
        super(name, name + " ist ein " + kategorie + " aus " + material, wert);
        this.kategorie = kategorie;
        this.material = material;
        this.abwehr = abwehr;
        this.magieAbwehr = magieAbwehr;
        this.staerke = staerke;
        this.geschicklichkeit = geschicklichkeit;
        this.konstitution = konstitution;
        this.intelligenz = intelligenz;
        this.weisheit = weisheit;
        this.charisma = charisma;
    }

    public Ruestung(String name, String kategorie, Material material, String beschreibung, int wert, int abwehr, int magieAbwehr) {
        super(name, beschreibung, wert);
        this.kategorie = kategorie;
        this.material = material;
        this.abwehr = abwehr;
        this.magieAbwehr = magieAbwehr;
        this.staerke = 0;
        this.geschicklichkeit = 0;
        this.konstitution = 0;
        this.intelligenz = 0;
        this.weisheit = 0;
        this.charisma = 0;
    }
    public Ruestung(String name, String kategorie, Material material, String beschreibung, int wert, int abwehr, int magieAbwehr,
                    int staerke, int geschicklichkeit, int konstitution, int intelligenz, int weisheit, int charisma) {
        super(name, beschreibung, wert);
        this.kategorie = kategorie;
        this.material = material;
        this.abwehr = abwehr;
        this.magieAbwehr = magieAbwehr;
        this.staerke = staerke;
        this.geschicklichkeit = geschicklichkeit;
        this.konstitution = konstitution;
        this.intelligenz = intelligenz;
        this.weisheit = weisheit;
        this.charisma = charisma;
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

class Helme extends Ruestung{

    public Helme(String name, Material material){
        super(name, "Helm", material, 5, 10, 5);
    }
    public Helme(String name, Material material, String beschreibung){
        super(name, "Helm", material, beschreibung, 5, 10, 5);
    }
    public Helme(String name, Material material, int wert, int abwehr, int magieAbwehr) {
        super(name, "Helm", material,  wert,  abwehr, magieAbwehr);
    }
    public Helme(String name, Material material, int wert, int abwehr, int magieAbwehr,
                    int staerke, int geschicklichkeit, int konstitution, int intelligenz, int weisheit, int charisma) {
        super(name, "Helm", material, wert, abwehr, magieAbwehr,
                staerke, geschicklichkeit, konstitution, intelligenz, weisheit, charisma);
    }
    public Helme(String name, Material material, String beschreibung, int wert, int abwehr, int magieAbwehr) {
        super(name, "Helm", material, beschreibung, wert, abwehr, magieAbwehr);
    }
    public Helme(String name, Material material, String beschreibung, int wert, int abwehr, int magieAbwehr,
                    int staerke, int geschicklichkeit, int konstitution, int intelligenz, int weisheit, int charisma) {
        super(name, "Helm", material, beschreibung, wert, abwehr, magieAbwehr,
                staerke, geschicklichkeit, konstitution, intelligenz, weisheit, charisma);
    }
}

/*
class Brust extends Ruestung{
    public Brust(String name, int wert, int abwehr) {
        super(name, wert, abwehr);
    }
}
class Beine extends Ruestung{

    public Beine(String name, int wert, int abwehr) {
        super(name, wert, abwehr);
    }
}
class Fuesse extends Ruestung{

    public Fuesse(String name, int wert, int abwehr) {
        super(name, wert, abwehr);
    }
}
*/