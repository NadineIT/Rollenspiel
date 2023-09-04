public class Material {
    protected String name;
    protected String beschreibung;
    protected int angriff;
    protected int magAngriff;
    protected int abwehr;
    protected int magAbwehr;
    protected int staerke;
    protected int geschicklichkeit;
    protected int konstitution;
    protected int intelligenz;
    protected int weisheit;
    protected int charisma;
    protected int wertmulti;

    public Material(String name, int wertmulti, int statmulti, int magistatmulti){
        this.name = name;
        this.wertmulti = wertmulti;
        this.staerke = statmulti;
        this.geschicklichkeit = statmulti;
        this.konstitution = statmulti;
        this.intelligenz = magistatmulti;
        this.weisheit = magistatmulti;
        this.charisma = magistatmulti;
    }
    public Material(String name, String beschreibung, int wertmulti, int statmulti, int magistatmulti){
        this.name = name;
        this.beschreibung = beschreibung;
        this.wertmulti = wertmulti;
        this.staerke = statmulti;
        this.geschicklichkeit = statmulti;
        this.konstitution = statmulti;
        this.intelligenz = magistatmulti;
        this.weisheit = magistatmulti;
        this.charisma = magistatmulti;
    }
    public Material(String name, String beschreibung, int wertmulti, int staerke){
        this.name = name;
        this.beschreibung = beschreibung;
        this.wertmulti = wertmulti;
        this.staerke = staerke;
        this.geschicklichkeit = 1;
        this.konstitution = 1;
        this.intelligenz = 1;
        this.weisheit = 1;
        this.charisma = 1;
    }
    public Material(String name, int wertmulti, int staerke){
        this.name = name;
        this.wertmulti = wertmulti;
        this.staerke = staerke;
        this.geschicklichkeit = 1;
        this.konstitution = 1;
        this.intelligenz = 1;
        this.weisheit = 1;
        this.charisma = 1;
    }
    public Material(String name, String beschreibung, int wertmulti, int staerke, int geschicklichkeit , int konstitution, int intelligenz, int weisheit, int charisma){
        this.name = name;
        this.beschreibung = beschreibung;
        this.wertmulti = wertmulti;
        this.staerke = staerke;
        this.geschicklichkeit = geschicklichkeit;
        this.konstitution = konstitution;
        this.intelligenz = intelligenz;
        this.weisheit = weisheit;
        this.charisma = charisma;
    }
    public Material(String name,  int wertmulti, int staerke, int geschicklichkeit , int konstitution, int intelligenz, int weisheit, int charisma){
        this.name = name;
        this.wertmulti = wertmulti;
        this.staerke = staerke;
        this.geschicklichkeit = geschicklichkeit;
        this.konstitution = konstitution;
        this.intelligenz = intelligenz;
        this.weisheit = weisheit;
        this.charisma = charisma;
    }

    public String getName(){
        return name;
    }
    public int getStaerke(){
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
    public int getWert(){
        return wertmulti;
    }
    @Override
    public String toString() {
        return getName();
    }
}

