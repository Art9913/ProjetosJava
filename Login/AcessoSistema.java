import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AcessoSistema {

    public static void main(String[] args) {
        // Cria e configura a janela principal (JFrame)
        JFrame frame = new JFrame("Acesso ao Sistema"); // Título da janela 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(null); // Usando layout absoluto para posicionar componentes

        // Rótulo "Usuário"
        JLabel userLabel = new JLabel("Usuário:");
        userLabel.setBounds(30, 30, 80, 25);
        frame.add(userLabel);

        // Campo de texto para o usuário
        JTextField userText = new JTextField(20);
        userText.setBounds(100, 30, 220, 25);
        frame.add(userText);

        // Rótulo "Senha"
        JLabel passwordLabel = new JLabel("Senha:");
        passwordLabel.setBounds(30, 70, 80, 25);
        frame.add(passwordLabel);

        // Campo de senha
        JPasswordField passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 70, 220, 25);
        frame.add(passwordText);

        // Botões
        JButton entrarButton = new JButton("Entrar");
        entrarButton.setBounds(30, 110, 100, 25);
        frame.add(entrarButton);

        JButton cancelarButton = new JButton("Cancelar");
        cancelarButton.setBounds(140, 110, 100, 25);
        frame.add(cancelarButton);

        JButton novoUsuarioButton = new JButton("Novo Usuário");
        novoUsuarioButton.setBounds(250, 110, 120, 25);
        frame.add(novoUsuarioButton);

        /*
         * USO DA INTERFACE:
         * A variável 'loginService' é do tipo da INTERFACE (LoginService), mas recebe uma
         * instância de uma classe CONCRETA (AuthenticationService).
         * JUSTIFICATIVA: Utilizar a interface aqui desacopla a camada de
         * apresentação (esta tela) da implementação da lógica de login. Se no futuro
         * a forma de autenticação mudar (ex: para um banco de dados), só precisaremos
         * criar uma nova classe que implemente LoginService e trocar a instanciação
         * aqui ("new NovaAutenticacaoService()"), sem precisar alterar o resto do
         * código desta classe. Isso promove reuso e manutenção. 
         */
        LoginService loginService = new AuthenticationService();

        // Ação do botão "Entrar"
        entrarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Tratamento de Exceção 
                try {
                    String username = userText.getText();
                    String password = new String(passwordText.getPassword());

                    if (loginService.login(username, password)) {
                        // Mensagem de sucesso 
                        JOptionPane.showMessageDialog(frame, "Bem-vindo, " + loginService.getCurrentUser().getUsername() + "!");
                    } else {
                        // Mensagem de falha 
                        JOptionPane.showMessageDialog(frame, "Login inválido!", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } catch (Exception ex) {
                    JOptionPane.showMessageDialog(frame, "Ocorreu um erro inesperado: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                } finally {
                    // O bloco finally é sempre executado. Útil para limpar recursos.
                    // Neste caso simples, não há ação necessária, mas a estrutura está presente.
                }
            }
        });

        // Ação do botão "Cancelar"
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0); // Encerra o sistema 
            }
        });

        // Ação do botão "Novo Usuário"
        novoUsuarioButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Mensagem de "Em desenvolvimento" 
                JOptionPane.showMessageDialog(frame, "Em desenvolvimento.", "Mensagem", JOptionPane.INFORMATION_MESSAGE);
            }
        });

        // Centraliza a janela na tela 
        frame.setLocationRelativeTo(null);
        // Torna a janela visível
        frame.setVisible(true);
    }
}