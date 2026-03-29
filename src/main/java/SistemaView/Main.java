package SistemaView;

import SistemaController.SistemaController;

public class Main {
    public static void main(String[] args) {

        SistemaController controller = new SistemaController();

        System.out.println(
                controller.cadastrarCategoria("Tecnologia", "Vídeos sobre programação")
        );

        System.out.println(
                controller.cadastrarUsuario("geo@email.com", "1234", "1234")
        );

        System.out.println(
                controller.cadastrarVideo(
                        "CRUD em Java",
                        "Tutorial de CRUD com JDBC",
                        "10/10/2025",
                        "1"
                )
        );

        System.out.println("Testes finalizados.");
    }
}