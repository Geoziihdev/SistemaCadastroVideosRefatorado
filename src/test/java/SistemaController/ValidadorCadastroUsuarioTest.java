package SistemaController;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ValidadorCadastroUsuarioTest {

    private final ValidadorCadastroUsuario validador = new ValidadorCadastroUsuario();

    @Test
    public void deveRetornarTrueQuandoCamposObrigatoriosEstiveremPreenchidos() {
        boolean resultado = validador.camposObrigatoriosPreenchidos("teste@email.com", "1234", "1234");
        assertTrue(resultado);
    }

    @Test
    public void deveRetornarFalseQuandoAlgumCampoObrigatorioEstiverVazio() {
        boolean resultado = validador.camposObrigatoriosPreenchidos("", "1234", "1234");
        assertFalse(resultado);
    }

    @Test
    public void deveRetornarTrueQuandoAsSenhasForemIguais() {
        boolean resultado = validador.senhasConferem("1234", "1234");
        assertTrue(resultado);
    }

    @Test
    public void deveRetornarFalseQuandoAsSenhasForemDiferentes() {
        boolean resultado = validador.senhasConferem("1234", "9999");
        assertFalse(resultado);
    }

    @Test
    public void deveRetornarTrueQuandoEmailForValido() {
        boolean resultado = validador.emailValido("teste@email.com");
        assertTrue(resultado);
    }

    @Test
    public void deveRetornarFalseQuandoEmailForInvalido() {
        boolean resultado = validador.emailValido("testeemail.com");
        assertFalse(resultado);
    }
}