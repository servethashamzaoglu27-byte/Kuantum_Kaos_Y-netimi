using System;
using System.Collections.Generic;

class Program
{
    static Random rnd = new Random();

    static void Main(string[] args)
    {
        List<KuantumNesnesi> envanter = new List<KuantumNesnesi>();

        while (true)
        {
            try
            {
                Console.WriteLine("\n===== KUANTUM AMBARI KONTROL PANELİ =====");
                Console.WriteLine("1. Yeni Nesne Ekle");
                Console.WriteLine("2. Tüm Envanteri Listele");
                Console.WriteLine("3. Nesneyi Analiz Et");
                Console.WriteLine("4. Acil Durum Soğutması Yap");
                Console.WriteLine("5. Çıkış");
                Console.Write("Seçiminiz: ");

                string secim = Console.ReadLine();

                if (secim == "1")
                {
                    KuantumNesnesi nesne = RastgeleNesneUret();
                    envanter.Add(nesne);
                }

                else if (secim == "2")
                {
                    Console.WriteLine("\n--- ENVANTER ---");
                    foreach (var item in envanter)
                        Console.WriteLine(item.DurumBilgisi());
                }

                else if (secim == "3")
                {
                    Console.Write("Analiz edilecek ID: ");
                    string id = Console.ReadLine();

                    var hedef = envanter.Find(n => n.ID == id);

                    if (hedef == null)
                    {
                        Console.WriteLine("Nesne bulunamadı!");
                    }
                    else
                    {
                        hedef.AnalizEt();

                        if (hedef.Stabilite <= 0)
                            throw new KuantumCokusuException(hedef.ID);
                    }
                }

                else if (secim == "4")
                {
                    Console.Write("Soğutulacak ID: ");
                    string id = Console.ReadLine();

                    var hedef = envanter.Find(n => n.ID == id);

                    if (hedef == null)
                    {
                        Console.WriteLine("Nesne bulunamadı!");
                    }
                    else if (hedef is IKritik kritikNesne)
                    {
                        kritikNesne.AcilDurumSogutmasi();
                    }
                    else
                    {
                        Console.WriteLine("Bu nesne soğutulamaz!");
                    }
                }

                else if (secim == "5")
                {
                    Console.WriteLine("Program kapatılıyor...");
                    break;
                }

                else
                {
                    Console.WriteLine("Geçersiz seçim!");
                }
            }
            catch (KuantumCokusuException ex)
            {
                Console.WriteLine("\n!!! SİSTEM ÇÖKTÜ! TAHLİYE BAŞLATILIYOR...");
                Console.WriteLine(ex.Message);
                break;
            }
        }
    }

    static KuantumNesnesi RastgeleNesneUret()
    {
        int tip = rnd.Next(3);
        string id = "N" + rnd.Next(1000, 9999);
        int stabilite = rnd.Next(40, 101);
        int tehlike = rnd.Next(1, 11);

        if (tip == 0)
        {
            Console.WriteLine($"Yeni VeriPaketi oluşturuldu: {id}");
            return new VeriPaketi(id, stabilite, tehlike);
        }
        else if (tip == 1)
        {
            Console.WriteLine($"Yeni KaranlikMadde oluşturuldu: {id}");
            return new KaranlikMadde(id, stabilite, tehlike);
        }
        else
        {
            Console.WriteLine($"Yeni AntiMadde oluşturuldu: {id}");
            return new AntiMadde(id, stabilite, tehlike);
        }
    }
}
