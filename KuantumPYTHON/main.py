from veri_paketi import VeriPaketi
from karanlik_madde import KaranlikMadde
from anti_madde import AntiMadde
from kuantum_cokusu_exception import KuantumCokusuException

import random

def rastgele_nesne_uret():
    tip = random.randint(0, 2)
    ID = "N" + str(random.randint(1000, 9999))
    stabilite = random.randint(40, 100)
    tehlike = random.randint(1, 10)

    if tip == 0:
        print(f"Yeni VeriPaketi oluşturuldu: {ID}")
        return VeriPaketi(ID, stabilite, tehlike)
    elif tip == 1:
        print(f"Yeni KaranlikMadde oluşturuldu: {ID}")
        return KaranlikMadde(ID, stabilite, tehlike)
    else:
        print(f"Yeni AntiMadde oluşturuldu: {ID}")
        return AntiMadde(ID, stabilite, tehlike)

def main():
    envanter = []

    while True:
        try:
            print("\n===== KUANTUM AMBARI KONTROL PANELİ =====")
            print("1. Yeni Nesne Ekle")
            print("2. Tüm Envanteri Listele")
            print("3. Nesneyi Analiz Et")
            print("4. Acil Durum Soğutması Yap")
            print("5. Çıkış")
            secim = input("Seçiminiz: ")

            if secim == "1":
                nesne = rastgele_nesne_uret()
                envanter.append(nesne)

            elif secim == "2":
                print("\n--- ENVANTER ---")
                for k in envanter:
                    print(k.durum_bilgisi())

            elif secim == "3":
                hedef_id = input("Analiz edilecek nesnenin ID'si: ")
                hedef = next((x for x in envanter if x.ID == hedef_id), None)

                if hedef is None:
                    print("Nesne bulunamadı!")
                else:
                    hedef.analiz_et()
                    if hedef.stabilite <= 0:
                        raise KuantumCokusuException(hedef.ID)

            elif secim == "4":
                hedef_id = input("Soğutulacak nesnenin ID'si: ")
                hedef = next((x for x in envanter if x.ID == hedef_id), None)

                if hedef is None:
                    print("Nesne bulunamadı!")
                else:
                    # IKritik implement edenlerde bu method var
                    if hasattr(hedef, "acil_durum_sogutmasi"):
                        hedef.acil_durum_sogutmasi()
                    else:
                        print("Bu nesne soğutulamaz!")

            elif secim == "5":
                print("Program sonlandırılıyor...")
                break

            else:
                print("Geçersiz seçim!")

        except KuantumCokusuException as e:
            print("\n!!! SİSTEM ÇÖKTÜ! TAHLİYE BAŞLATILIYOR...")
            print(e)
            break

if __name__ == "__main__":
    main()
