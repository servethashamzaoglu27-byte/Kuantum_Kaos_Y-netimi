from kuantum_nesnesi import KuantumNesnesi

class VeriPaketi(KuantumNesnesi):
    def __init__(self, ID, stabilite, tehlike_seviyesi):
        super().__init__(ID, stabilite, tehlike_seviyesi)

    def analiz_et(self):
        # stabilite 5 düşer
        self.stabilite -= 5
        print("Veri içeriği okundu.")
