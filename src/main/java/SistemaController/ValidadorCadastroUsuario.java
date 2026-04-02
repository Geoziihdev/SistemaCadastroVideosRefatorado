package SistemaController;

public class ValidadorCadastroUsuario {

    public boolean camposObrigatoriosPreenchidos(String email, String senha, String confirma) {
        return email != null && !email.trim().isEmpty()
                && senha != null && !senha.trim().isEmpty()
                && confirma != null && !confirma.trim().isEmpty();
    }

    public boolean senhasConferem(String senha, String confirma) {
        if (senha == null || confirma == null) {
            return false;
        }
        return senha.equals(confirma);
    }

    public boolean emailValido(String email) {
        if (email == null || email.trim().isEmpty()) {
            return false;
        }
        return email.contains("@") && email.contains(".");
    }
}