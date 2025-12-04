using System;

public class VeriPaketi : KuantumNesnesi
{
    public VeriPaketi(string id, int stabilite, int tehlike)
        : base(id, stabilite, tehlike)
    {
    }

    public override void AnalizEt()
    {
        Stabilite -= 5;
        Console.WriteLine("Veri içeriği okundu.");
    }
}
