using System;

public abstract class KuantumNesnesi
{
    public string ID { get; set; }
    private int _stabilite;
    public int Stabilite 
    {
        get => _stabilite;
        set
        {
            if (value > 100) _stabilite = 100;
            else if (value < 0) _stabilite = 0;
            else _stabilite = value;
        }
    }

    public int TehlikeSeviyesi { get; set; }

    public KuantumNesnesi(string id, int stabilite, int tehlike)
    {
        ID = id;
        Stabilite = stabilite;
        TehlikeSeviyesi = tehlike;
    }

    public abstract void AnalizEt();

    public string DurumBilgisi()
    {
        return $"ID: {ID} | Stabilite: {Stabilite}";
    }
}
