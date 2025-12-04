import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        Random rnd = new Random();

        List<KuantumNesnesi> envanter = new ArrayList<>();

        while (true) {
            try {
                System.out.println("\n===== KUANTUM AMBARI KONTROL PANELİ =====");
                System.out.println("1. Yeni Nesne Ekle");
                System.out.println("2. Tüm Envanteri Listele");
                System.out.println("3. Nesneyi Analiz Et");
                System.out.println("4. Acil Durum Soğutması Yap");
                System.out.println("5. Çıkış");
                System.out.print("Seçiminiz: ");

                int secim = scan.nextInt();
                scan.nextLine(); // buffer temizliği

                if (secim == 1) {
                    int tip = rnd.nextInt(3); // 0,1,2

                    String id = "N" + (rnd.nextInt(9000) + 1000);
                    double stab = rnd.nextInt(60) + 40; // 40-100 arası
                    int teh = rnd.nextInt(10) + 1;

                    KuantumNesnesi yeni = null;

                    if (tip == 0) {
                        yeni = new VeriPaketi(id, stab, teh);
                        System.out.println("Yeni VeriPaketi oluşturuldu: " + id);
                    } else if (tip == 1) {
                        yeni = new KaranlikMadde(id, stab, teh);
                        System.out.println("Yeni KaranlikMadde oluşturuldu: " + id);
                    } else {
                        yeni = new AntiMadde(id, stab, teh);
                        System.out.println("Yeni AntiMadde oluşturuldu: " + id);
                    }

                    envanter.add(yeni);
                }

                else if (secim == 2) {
                    System.out.println("\n--- ENVANTER ---");
                    for (KuantumNesnesi k : envanter) {
                        System.out.println(k.DurumBilgisi());
                    }
                }

                else if (secim == 3) {
                    System.out.print("Analiz edilecek nesnenin ID'si: ");
                    String id = scan.nextLine();

                    KuantumNesnesi hedef = null;

                    for (KuantumNesnesi k : envanter) {
                        if (k.getID().equals(id)) {
                            hedef = k;
                            break;
                        }
                    }

                    if (hedef == null) {
                        System.out.println("Nesne bulunamadı!");
                    } else {
                        hedef.AnalizEt();

                        if (hedef.getStabilite() <= 0) {
                            throw new KuantumCokusuException(hedef.getID());
                        }
                    }
                }

                else if (secim == 4) {
                    System.out.print("Soğutulacak nesnenin ID'si: ");
                    String id = scan.nextLine();

                    KuantumNesnesi hedef = null;

                    for (KuantumNesnesi k : envanter) {
                        if (k.getID().equals(id)) {
                            hedef = k;
                            break;
                        }
                    }

                    if (hedef == null) {
                        System.out.println("Nesne bulunamadı!");
                    } else if (hedef instanceof IKritik) {
                        IKritik kritikNesne = (IKritik) hedef;
                        kritikNesne.AcilDurumSogutmasi();
                    } else {
                        System.out.println("Bu nesne soğutulamaz!");
                    }
                }

                else if (secim == 5) {
                    System.out.println("Programdan çıkılıyor...");
                    break;
                }

                else {
                    System.out.println("Geçersiz seçim!");
                }

            } catch (KuantumCokusuException e) {
                System.out.println("\n!!! SİSTEM ÇÖKTÜ! TAHLİYE BAŞLATILIYOR...");
                System.out.println(e.getMessage());
                break;
            }
        }
    }
}

    

