from kuantum_nesnesi import KuantumNesnesi
from kritik_arayuzu import IKritik

class KaranlikMadde(KuantumNesnesi, IKritik):

    def __init__(self, ID, stabilite, tehlike_seviyesi):
        super().__init__(ID, stabilite, tehlike_seviyesi)

    def analiz_et(self):
        self.stabilite -= 15
        print("Karanlık madde analiz edildi.")

    def acil_durum_sogutmasi(self):
        self.stabilite += 50
        print("Karanlık madde soğutuldu!")
