package com.brenobrito;

public abstract class Prova
{

  public String correr()
  {
    StringBuilder relato = new StringBuilder();
    relato.append(aquecer()).append(" | ");
    relato.append(largar()).append(" | ");
    relato.append(percorrer());

    String hidratacao = hidratar();
    if (!hidratacao.isEmpty())
    {
      relato.append(" | ").append(hidratacao);
    }

    relato.append(" | ").append(chegar());
    return relato.toString();
  }

  private String aquecer()
  {
    return "Aquecimento";
  }

  private String largar()
  {
    return "Largada";
  }

  private String chegar()
  {
    return "Chegada";
  }

  protected abstract String percorrer();

  protected String hidratar()
  {
    return "";
  }
}
