package com.brenobrito;

public class Maratona extends Prova
{

  @Override
  protected String percorrer()
  {
    return "42195m em ritmo constante";
  }

  @Override
  protected String hidratar()
  {
    return "Hidratacao no km 21";
  }
}
