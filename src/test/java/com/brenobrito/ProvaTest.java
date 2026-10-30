package com.brenobrito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ProvaTest
{

  @Test
  void deveCorrerAMilhaNoRitmoDela()
  {
    assertEquals("Aquecimento | Largada | 1609m em ritmo forte | Chegada",
        new Milha().correr());
  }

  @Test
  void deveCorrerOsCincoMilNoRitmoDeles()
  {
    assertEquals("Aquecimento | Largada | 5000m em ritmo sustentado | Chegada",
        new CincoMil().correr());
  }

  @Test
  void deveCorrerAMaratonaNoRitmoDela()
  {
    assertEquals("Aquecimento | Largada | 42195m em ritmo constante | Hidratacao no km 21 | Chegada",
        new Maratona().correr());
  }

  @Test
  void deveAquecerELargarAntesDoPercursoEmTodasAsProvas()
  {
    for (Prova prova : new Prova[] { new Milha(), new CincoMil(), new Maratona() })
    {
      String relato = prova.correr();

      assertTrue(relato.indexOf("Aquecimento") < relato.indexOf("Largada"));
      assertTrue(relato.indexOf("Largada") < relato.indexOf("m em ritmo"));
    }
  }

  @Test
  void deveChegarPorUltimoEmTodasAsProvas()
  {
    for (Prova prova : new Prova[] { new Milha(), new CincoMil(), new Maratona() })
    {
      assertTrue(prova.correr().endsWith("Chegada"));
    }
  }

  @Test
  void naoDeveHidratarNasProvasCurtas()
  {
    assertFalse(new Milha().correr().contains("Hidratacao"));
    assertFalse(new CincoMil().correr().contains("Hidratacao"));
  }

  @Test
  void deveHidratarApenasNaMaratona()
  {
    assertTrue(new Maratona().correr().contains("Hidratacao no km 21"));
  }

  @Test
  void deveHidratarDepoisDoPercursoEAntesDaChegada()
  {
    String relato = new Maratona().correr();

    assertTrue(relato.indexOf("42195m") < relato.indexOf("Hidratacao"));
    assertTrue(relato.indexOf("Hidratacao") < relato.indexOf("Chegada"));
  }
}
