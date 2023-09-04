import java.util.ArrayList;

abstract public class Figuren{
    protected boolean isSpielbar;
    protected String name;
    protected boolean nebenwaffe;
    protected int level;
    protected int leben;
    protected int maxleben;
    protected int energie;
    protected int maxenergie;
    protected int mana;
    protected int maxmana;
    protected String rasse;
    protected String klasse;
    protected int staerke;
    protected int geschicklichkeit;
    protected int konstitution;
    protected int intelligenz;
    protected int weisheit;
    protected int charisma;
    protected int angriff;
    protected int abwehr;
    protected int magieangriff;
    protected int magieabwehr;

    public Figuren(){
    }
    public Figuren (String name, String rasse, boolean sp, boolean nebenwaffe, int xtrenergie, int xtrstaerke, int xtrgeschicklichkeit,
                    int xtrkonstitution, int xtrintelligenz, int xtrweisheit, int xtrcharisma, int xtrangriff, int xtrabwehr, int xtrmagieangriff,
                    int xtrmagieabwehr){
        this.name = name;
        this.rasse = rasse;
        isSpielbar = sp;
        this.nebenwaffe = nebenwaffe;
        level = 1;
        staerke = 10 + xtrstaerke;
        geschicklichkeit = 10 + xtrgeschicklichkeit;
        konstitution = 10 + xtrkonstitution;
        intelligenz = 10 + xtrintelligenz;
        weisheit = 10 + xtrweisheit;
        charisma = 10 + xtrcharisma;
        angriff = 10 + xtrangriff;
        abwehr = 10 + xtrabwehr;
        magieangriff = 10 + xtrmagieangriff;
        magieabwehr = 10 + xtrmagieabwehr;
        maxleben = staerke * 20 + konstitution * 10;
        leben = maxleben;
        maxenergie = 100 + xtrenergie;
        energie = maxenergie;
        maxmana = intelligenz*10+weisheit*5;
        mana = maxmana;
    }
    public Figuren (String name, String rasse, String klasse, boolean sp, boolean nebenwaffe, int xtrenergie, int xtrstaerke, int xtrgeschicklichkeit,
                    int xtrkonstitution, int xtrintelligenz, int xtrweisheit, int xtrcharisma, int xtrangriff, int xtrabwehr, int xtrmagieangriff,
                    int xtrmagieabwehr){
        this.name = name;
        this.rasse = rasse;
        this.klasse = klasse;
        isSpielbar = sp;
        this.nebenwaffe = nebenwaffe;
        level = 1;
        staerke = 10 + xtrstaerke;
        geschicklichkeit = 10 + xtrgeschicklichkeit;
        konstitution = 10 + xtrkonstitution;
        intelligenz = 10 + xtrintelligenz;
        weisheit = 10 + xtrweisheit;
        charisma = 10 + xtrcharisma;
        angriff = 10 + xtrangriff;
        abwehr = 10 + xtrabwehr;
        magieangriff = 10 + xtrmagieangriff;
        magieabwehr = 10 + xtrmagieabwehr;
        maxleben = staerke * 20 + konstitution * 10;
        leben = maxleben;
        maxenergie = 100 + xtrenergie;
        energie = maxenergie;
        maxmana = intelligenz*10+weisheit*5;
        mana = maxmana;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return getName();
    }
    abstract public void addCharisma(int charisma);
    public boolean getNebenwaffe(){
        return nebenwaffe;
    }
    abstract public int getLevel();
    public String getRasse() {
        return rasse;
    }
    abstract public void setLevelNPC(int level);
    abstract public void legeAb(String slot);
    abstract public void maleDich();
    abstract public Waffen waehleWaffeAus();
    abstract public void ruesteWaffeAus(Waffen waffe, String slot);
}
abstract class Spielfigur extends Figuren{
    protected ArrayList<Waffen> waffen;
    protected ArrayList<Ruestung> ruestung;
    protected ArrayList<Item> items;
    protected Waffen haupthand;
    protected Waffen nebenhand;
    protected Ruestung helm;
    protected Ruestung oberkoerper;
    protected Ruestung unterkoerper;
    protected Ruestung fuesse;
    protected int geldbeutel;
    protected int changeSta;
    protected int changeGes;
    protected int changeKon;
    protected int changeInt;
    protected int changeWei;
    protected int changeCha;

    public Spielfigur (String name, String rasse, boolean sp, boolean nebenwaffe, int xtrleben, int xtrenergie, int xtrmana, int xtrstaerke, int xtrgeschicklichkeit,
                    int xtrkonstitution, int xtrintelligenz, int xtrweisheit, int xtrcharisma, int xtrangriff, int xtrabwehr, int xtrmagieangriff,
                    int xtrmagieabwehr){
        super(name, rasse, sp, nebenwaffe, xtrenergie, xtrstaerke, xtrgeschicklichkeit,
        xtrkonstitution, xtrintelligenz, xtrweisheit, xtrcharisma, xtrangriff, xtrabwehr, xtrmagieangriff,
        xtrmagieabwehr);
        changeSta = 0;
        changeGes = 0;
        changeKon = 0;
        changeInt = 0;
        changeWei = 0;
        changeCha = 0;
        geldbeutel = 0;
    }
    public Spielfigur (String name, String rasse, String klasse, boolean sp, boolean nebenwaffe, int xtrleben, int xtrenergie, int xtrmana, int xtrstaerke, int xtrgeschicklichkeit,
                    int xtrkonstitution, int xtrintelligenz, int xtrweisheit, int xtrcharisma, int xtrangriff, int xtrabwehr, int xtrmagieangriff,
                    int xtrmagieabwehr){
        super(name, rasse, klasse, sp, nebenwaffe, xtrenergie, xtrstaerke, xtrgeschicklichkeit,
        xtrkonstitution, xtrintelligenz, xtrweisheit, xtrcharisma, xtrangriff, xtrabwehr, xtrmagieangriff, xtrmagieabwehr);
        changeSta = 0;
        changeGes = 0;
        changeKon = 0;
        changeInt = 0;
        changeWei = 0;
        changeCha = 0;
        geldbeutel = 0;
    }
    public Spielfigur (String name, String rasse, boolean sp, boolean nebenwaffe, int xtrleben, int xtrenergie, int xtrmana, int xtrstaerke, int xtrgeschicklichkeit,
                    int xtrkonstitution, int xtrintelligenz, int xtrweisheit, int xtrcharisma, int xtrangriff, int xtrabwehr, int xtrmagieangriff,
                    int xtrmagieabwehr, int geldbeutel){
        super(name, rasse, sp, nebenwaffe, xtrenergie, xtrstaerke, xtrgeschicklichkeit,
        xtrkonstitution, xtrintelligenz, xtrweisheit, xtrcharisma, xtrangriff, xtrabwehr, xtrmagieangriff,
        xtrmagieabwehr);
        changeSta = 0;
        changeGes = 0;
        changeKon = 0;
        changeInt = 0;
        changeWei = 0;
        changeCha = 0;
        this.geldbeutel = geldbeutel;
    }
    public Spielfigur (String name, String rasse, String klasse, boolean sp, boolean nebenwaffe, int xtrleben, int xtrenergie, int xtrmana, int xtrstaerke, int xtrgeschicklichkeit,
                    int xtrkonstitution, int xtrintelligenz, int xtrweisheit, int xtrcharisma, int xtrangriff, int xtrabwehr, int xtrmagieangriff,
                    int xtrmagieabwehr, int geldbeutel){
        super(name, rasse, klasse, sp, nebenwaffe, xtrenergie, xtrstaerke, xtrgeschicklichkeit,
        xtrkonstitution, xtrintelligenz, xtrweisheit, xtrcharisma, xtrangriff, xtrabwehr,  xtrmagieangriff,
        xtrmagieabwehr);
        changeSta = 0;
        changeGes = 0;
        changeKon = 0;
        changeInt = 0;
        changeWei = 0;
        changeCha = 0;
        this.geldbeutel = geldbeutel;
    }
    public int getGeldbeutel() {
        return geldbeutel;
    }
    public void setGeldbeutel(int geldbeutel) {
        this.geldbeutel = geldbeutel;
    }
    abstract public void setHaupthand(Waffen waffe);
    abstract public Waffen getHaupthand();
    abstract public void setNebenhand(Waffen waffe);
    abstract public Gegenstand getNebenhand();
    abstract public void setLevelPC(int level);
    public void addWaffe(Waffen waffe){
        waffen.add(waffe);
    }
    public void addItem(Item item){
        items.add(item);
    }
    public void addRuestung(Ruestung ausruestung) {
        ruestung.add(ausruestung);
    }
    public void addGeldbeutel(int geld){
        this.geldbeutel = this.geldbeutel + geld;
    }
}