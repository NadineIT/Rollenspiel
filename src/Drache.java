public class Drache extends Figuren{

    protected String element;

    public Drache(String name, boolean sp, String element) {
        super(name, "Drache", sp, false, 900, 40, 40, 40, 40, 40, 40,
                20, 20, 20, 20);
        this.element = element;
    }

    public Drache(String name, boolean sp) {
        super(name, "Drache", sp, false, 900, 40, 40, 40, 40, 40, 40,
                20, 20, 20, 20);
        this.element = "Feuer";
    }

    @Override
    public void addCharisma(int charisma) {
        charisma = this.charisma + charisma;
    }

    @Override
    public int getLevel() {
        return level;
    }

    @Override
    public void setLevelNPC(int level) {

    }


    @Override
    public void legeAb(String slot) {
    }

    @Override
    public void maleDich() {
        System.out.println("Name:  " + name );
        System.out.println("Rasse: " + rasse + " || Element: " + element);
        System.out.println("----------------------------------------------");
        System.out.println("HP:   " + leben +"/"+ maxleben);
        System.out.println("AP:   " + energie+"/"+ maxenergie);
        System.out.println("MP:   " + mana+"/"+ maxmana);
        System.out.println();
        System.out.println("Str: " + staerke + " || Ges: "  + geschicklichkeit);
        System.out.println("Kon: " + konstitution + " || Int: " + intelligenz);
        System.out.println("Wei: " + weisheit + " || Cha: " + charisma);
    }

    @Override
    public Waffen waehleWaffeAus() {
        System.out.println("Ein Drache braucht keine Waffen");
        return null;
    }

    @Override
    public void ruesteWaffeAus(Waffen waffe, String slot) {
        System.out.println("Ein Drache braucht keine Waffen");
    }

}
