public class Waffen extends Gegenstand {

    protected boolean einhaendig;
    protected boolean haupt;
    protected boolean neben;
    protected int angriff;
    protected int magAngriff;
    protected int staerke;
    protected int geschicklichkeit;
    protected int konstitution;
    protected int intelligenz;
    protected int weisheit;
    protected int charisma;
    protected String kategorie;
    protected Material material;

    public Waffen(String name, String kategorie, Material material, boolean einhaendig, boolean haupt, boolean neben, int wert,
                  int staerke, int geschicklichkeit, int konstitution, int intelligenz, int weisheit, int charisma){
        super(name, name + " ist ein " + kategorie+ " aus " + material, wert);
        this.kategorie = kategorie;
        this.material = material;
        this.einhaendig = einhaendig;
        this.haupt = haupt;
        this.neben = neben;
        this.staerke  = staerke;
        this.geschicklichkeit = geschicklichkeit;
        this.konstitution = konstitution;
        this.intelligenz = intelligenz;
        this.weisheit = weisheit;
        this.charisma = charisma;

    }

    public Waffen(String name, String kategorie, Material material, boolean einhaendig, boolean haupt, boolean neben, String beschreibung, int wert,
                  int staerke, int geschicklichkeit, int konstitution, int intelligenz, int weisheit, int charisma){
        super(name, beschreibung, wert);
        this.einhaendig = einhaendig;
        this.haupt = haupt;
        this.neben = neben;
        this.kategorie = kategorie;
        this.material = material;
        this.staerke  = staerke;
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

    public String getName(){
        return name;
    }
    @Override
    public String getBeschreibung() {
        return beschreibung;
    }
    public boolean getEinhaendig() {
        return einhaendig;
    }
    public boolean getHaupt(){
        return haupt;
    }
    public int getStaerke() {
        return staerke;
    }
    public int getGeschicklichkeit() {
        return geschicklichkeit;
    }
    public int getKonstitution() {
        return konstitution;
    }
    public int getIntelligenz() {
        return intelligenz;
    }
    public int getWeisheit() {
        return weisheit;
    }
    public int getCharisma() {
        return charisma;
    }
    @Override
    public void beschreibeDich() {
        String slots;
        String slot;
        if ((this.einhaendig) && (this.haupt) && (this.neben)) {
            slots = "Einhändig";
            slot = "Haupt- oder Nebenhand";
        } else if ((this.einhaendig) && (this.haupt)) {
            slots = "Einhändig";
            slot = "Haupthand";
        } else if (this.einhaendig) {
            slots = "Einhändig";
            slot = "Nebenhand";
        }else {
            slots = "Beidhändig";
            slot = "Beide Waffenslotz gleichzeitig";
        }
        System.out.println("Name: " + name);
        System.out.println("Waffenart: " + kategorie + " || Material: "+ material);
        System.out.println("Kategorie: " + slots + " || Slot: " + slot);

        System.out.println("------------------------------");
        System.out.println("Stä: " + staerke + " || Ges: " + geschicklichkeit);
        System.out.println("Kon: " + konstitution + " || Int: " + intelligenz);
        System.out.println("Wei: " + weisheit + " || Cha: " + charisma);
        System.out.println("------------------------------");
        System.out.println("Beschreibung:");
        if (beschreibung != null) {
            System.out.println(beschreibung);
        }else {
            System.out.println("Keine Beschreibung vorhanden");
        }
    }

}
class Schwert extends Waffen{


    public Schwert(String name, Material material) {
        super(name, "Schwert", material, true, true, true, 50*material.getWert(),
                10*material.getStaerke(), 1*material.getGeschicklichkeit(), 5*material.getKonstitution(),
                0*material.getIntelligenz(), 0*material.getWeisheit(), 0*material.getCharisma());
    }

    public Schwert(String name, Material material, boolean einhaendig, boolean haupt, boolean neben, int wert,
                   int staerke, int geschicklichkeit, int konstitution, int intelligenz, int weisheit, int charisma) {
        super(name, "Schwert", material, einhaendig, haupt, neben, wert*material.getWert(),
                staerke*material.getStaerke(),geschicklichkeit*material.getGeschicklichkeit(),
                konstitution*material.getKonstitution(), intelligenz*material.getIntelligenz(),
                weisheit*material.getWeisheit(), charisma*material.getCharisma());
    }

    public Schwert(String name, Material material, boolean einhaendig, boolean haupt, boolean neben, String beschreibung, int wert,
                   int staerke, int geschicklichkeit, int konstitution, int intelligenz, int weisheit, int charisma) {
        super(name, "Schwert", material, einhaendig, haupt, neben, beschreibung, wert*material.getWert(),
                staerke*material.getStaerke(), geschicklichkeit*material.getGeschicklichkeit(),
                konstitution*material.getKonstitution(), intelligenz*material.getIntelligenz(),
                weisheit*material.getWeisheit(), charisma*material.getCharisma());
    }
}
class Dolch extends Waffen{

    public Dolch(String name, Material material) {
        super(name, "Dolch", material, true, true, true, 10*material.getWert(),
                5*material.getStaerke(), 5*material.getGeschicklichkeit(), 2*material.getKonstitution(),
                0*material.getIntelligenz(), 0*material.getWeisheit(), 2*material.getCharisma());
    }

    public Dolch(String name, Material material, boolean einhaendig, boolean haupt, boolean neben, int wert,
                 int staerke, int geschicklichkeit, int konstitution, int intelligenz, int weisheit, int charisma) {
        super(name, "Dolch", material, einhaendig, haupt, neben, wert*material.getWert(),
                staerke*material.getStaerke(),geschicklichkeit*material.getGeschicklichkeit(),
                konstitution*material.getKonstitution(), intelligenz*material.getIntelligenz(),
                weisheit*material.getWeisheit(), charisma*material.getCharisma());
    }

    public Dolch(String name, Material material, boolean einhaendig, boolean haupt, boolean neben, String beschreibung, int wert,
                 int staerke, int geschicklichkeit, int konstitution, int intelligenz, int weisheit, int charisma) {
        super(name, "Dolch", material, einhaendig, haupt, neben, beschreibung, wert*material.getWert(),
                staerke*material.getStaerke(),geschicklichkeit*material.getGeschicklichkeit(),
                konstitution*material.getKonstitution(), intelligenz*material.getIntelligenz(),
                weisheit*material.getWeisheit(), charisma*material.getCharisma());
    }
}
class Axt extends Waffen{
    public Axt(String name, Material material) {
        super(name, "Axt", material, false, true, true, 75*material.getWert(),
                10*material.getStaerke(),-2*material.getGeschicklichkeit(),
                5*material.getKonstitution(), 0*material.getIntelligenz(),
                0*material.getWeisheit(), 0*material.getCharisma());
    }

    public Axt(String name, Material material, boolean einhaendig, boolean haupt, boolean neben, int wert,
               int staerke, int geschicklichkeit, int konstitution, int intelligenz, int weisheit, int charisma) {
        super(name, "Axt", material, einhaendig, haupt, neben, wert*material.getWert(),
                staerke*material.getStaerke(),geschicklichkeit*material.getGeschicklichkeit(),
                konstitution*material.getKonstitution(), intelligenz*material.getIntelligenz(),
                weisheit*material.getWeisheit(), charisma*material.getCharisma());
    }

    public Axt(String name, Material material, boolean einhaendig, boolean haupt, boolean neben, String beschreibung, int wert,
               int staerke, int geschicklichkeit, int konstitution, int intelligenz, int weisheit, int charisma) {
        super(name, "Axt", material, einhaendig, haupt, neben, beschreibung, wert*material.getWert(),
                staerke*material.getStaerke(),geschicklichkeit*material.getGeschicklichkeit(),
                konstitution*material.getKonstitution(), intelligenz*material.getIntelligenz(),
                weisheit*material.getWeisheit(), charisma*material.getCharisma());
    }
}
class Stab extends Waffen{
    public Stab(String name, Material material) {
        super(name, "Stab", material, false, true, true, 20*material.getWert(),
                1*material.getStaerke(),0*material.getGeschicklichkeit(),
                1*material.getKonstitution(), 10*material.getIntelligenz(),
                5*material.getWeisheit(), 0*material.getCharisma());
    }

    public Stab(String name, Material material, boolean einhaendig, boolean haupt, boolean neben, int wert,
               int staerke, int geschicklichkeit, int konstitution, int intelligenz, int weisheit, int charisma) {
        super(name, "Stab", material, einhaendig, haupt, neben, wert*material.getWert(),
                staerke*material.getStaerke(),geschicklichkeit*material.getGeschicklichkeit(),
                konstitution*material.getKonstitution(), intelligenz*material.getIntelligenz(),
                weisheit*material.getWeisheit(), charisma*material.getCharisma());
    }

    public Stab(String name, Material material, boolean einhaendig, boolean haupt, boolean neben, String beschreibung, int wert,
               int staerke, int geschicklichkeit, int konstitution, int intelligenz, int weisheit, int charisma) {
        super(name, "Stab", material, einhaendig, haupt, neben, beschreibung, wert*material.getWert(),
                staerke*material.getStaerke(),geschicklichkeit*material.getGeschicklichkeit(),
                konstitution*material.getKonstitution(), intelligenz*material.getIntelligenz(),
                weisheit*material.getWeisheit(), charisma*material.getCharisma());
    }
}
