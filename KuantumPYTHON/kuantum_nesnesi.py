from abc import ABC, abstractmethod

class KuantumNesnesi(ABC):
    def __init__(self, ID, stabilite, tehlike_seviyesi):
        self.ID = ID
        self._stabilite = None
        self.stabilite = stabilite  # kapsülleme kontrolünden geçecek
        self.tehlike_seviyesi = tehlike_seviyesi

    @property
    def stabilite(self):
        return self._stabilite

    @stabilite.setter
    def stabilite(self, value):
        if value > 100:
            self._stabilite = 100
        elif value < 0:
            self._stabilite = 0
        else:
            self._stabilite = value

    @abstractmethod
    def analiz_et(self):
        pass

    def durum_bilgisi(self):
        return f"ID: {self.ID} | Stabilite: {self.stabilite}"
