public class KaranlikMadde extends KuantumNesnesi implements IKritik {

    public KaranlikMadde(String ID, double stabilite, int tehlikeSeviyesi) {
        super(ID, stabilite, tehlikeSeviyesi);
    }

    @Override
    public void AnalizEt() {
        // 15 birim stabilite düşer
        setStabilite(getStabilite() - 15);
        System.out.println("Karanlık madde analiz edildi.");
    }

    @Override
    public void AcilDurumSogutmasi() {
        // Max 100 olacak şekilde 50 artırılır
        setStabilite(getStabilite() + 50);
        System.out.println("Karanlık madde soğutuldu!");
    }
}

    

