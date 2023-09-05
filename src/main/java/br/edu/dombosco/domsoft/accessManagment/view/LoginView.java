package br.edu.dombosco.domsoft.accessManagment.view;

import br.edu.dombosco.domsoft.accessManagment.controller.UserController;
import br.edu.dombosco.domsoft.accessManagment.model.User;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

@Lazy
@Component
@Scope("prototype")
public class LoginView extends JFrame {
    private JTextField txtUsuario;
    private JPasswordField txtSenha;
    private JLabel lblEsqueciSenha;
    private JLabel lblCadastreSe;
    private JButton btnEntrar;

    private  UserController userController;



    public LoginView(UserController userController) {
        this.userController = userController;
        setTitle("Tela de Login");
        setSize(280, 300);
        setLocationRelativeTo(null);
        setLayout(null);

        JLabel lblUsuario = new JLabel("Usuario:");
        lblUsuario.setBounds(10, 10, 60, 25);
        add(lblUsuario);

        txtUsuario = new JTextField();
        txtUsuario.setBounds(100, 10, 150, 25);
        add(txtUsuario);

        JLabel lblSenha = new JLabel("Senha:");
        lblSenha.setBounds(10, 70, 60, 25);
        add(lblSenha);

        txtSenha = new JPasswordField();
        txtSenha.setBounds(100, 70, 150, 25);
        add(txtSenha);


        lblEsqueciSenha = new JLabel("Esqueci minha senha");
        lblEsqueciSenha.setBounds(10, 140, 150, 25);
        lblEsqueciSenha.setForeground(Color.BLUE);
        lblEsqueciSenha.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(lblEsqueciSenha);

        lblCadastreSe = new JLabel("Cadastre-se");
        lblCadastreSe.setBounds(10, 170, 150, 25);
        lblCadastreSe.setForeground(Color.BLUE);
        lblCadastreSe.setCursor(new Cursor(Cursor.HAND_CURSOR));
        add(lblCadastreSe);



        btnEntrar = new JButton("Entrar");
        btnEntrar.setBounds(100, 110, 150, 25);
        add(btnEntrar);

        btnEntrar.addActionListener(e -> {
            String usuario = txtUsuario.getText();
            String senha = new String(txtSenha.getPassword());

            userController.create(User.builder()
                            .username(usuario)
                            .password(senha)
                    .build());
        });

        lblEsqueciSenha.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new ResetPasswordView().setVisible(true);  // Modificado para abrir a nova janela

            }
        });

        lblCadastreSe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                setVisible(false);
                new RegisterView().setVisible(true);  // Modificado para abrir a nova janela
            }
        });

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
}