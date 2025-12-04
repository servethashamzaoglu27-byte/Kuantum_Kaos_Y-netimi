using System;

public class KuantumCokusuException : Exception
{
    public KuantumCokusuException(string id)
        : base($"Kuantum Çöküşü! Patlayan nesne ID: {id}")
    {
    }
}
