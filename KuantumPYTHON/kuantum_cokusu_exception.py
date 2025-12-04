class KuantumCokusuException(Exception):
    def __init__(self, nesne_id):
        super().__init__(f"Kuantum Çöküşü! Patlayan nesne ID: {nesne_id}")
        self.nesne_id = nesne_id
