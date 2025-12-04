using System;

public class AntiMadde : KuantumNesnesi, IKritik
{
    public AntiMadde(string id, int stabilite, int tehlike)
        : base(id, stabilite, tehlike)
    {
    }

    public override void AnalizEt()
    {
        Stabilite -= 25;
        Console.WriteLine("Evrenin dokusu titriyor...");
    }

    public void AcilDurumSogutmasi()
    {
        Stabilite += 50;
        Console.WriteLine("Antimadde soğutuldu!");
    }
}
