using System;

public class KaranlikMadde : KuantumNesnesi, IKritik
{
    public KaranlikMadde(string id, int stabilite, int tehlike)
        : base(id, stabilite, tehlike)
    {
    }

    public override void AnalizEt()
    {
        Stabilite -= 15;
        Console.WriteLine("Karanlık madde analiz edildi.");
    }

    public void AcilDurumSogutmasi()
    {
        Stabilite += 50;
        Console.WriteLine("Karanlık madde soğutuldu!");
    }
}
