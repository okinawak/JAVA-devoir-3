package Vues;

import Controlers.*;
import Entities.Pizza;
import Tools.ConnexionBDD;
import Tools.ModelJTable;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FrmCommander extends JFrame {
    private JPanel pnlRoot;
    private JLabel lblTitre;
    private JLabel lblNumCommande;
    private JTextField txtNumCommande;
    private JLabel lblClients;
    private JComboBox cboClients;
    private JLabel lblLivreurs;
    private JTable tblPizzas;
    private JComboBox cboLivreurs;
    private JButton btnCommander;
    private PreparedStatement ps;
    private ResultSet rs;
    private Connection cnx;

    private CtrlClient ctrlClient;
    private CtrlLigneCommande ctrlLigneCommande;
    private CtrlLivreur ctrlLivreur;
    private CtrlPizza ctrlPizza;
    private CtrlCommande ctrlCommande;

    public FrmCommander() throws SQLException, ClassNotFoundException {
        this.setTitle("Commander");
        this.setContentPane(pnlRoot);
        this.pack();
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setLocationRelativeTo(null);

        ConnexionBDD maCnx = new ConnexionBDD();


        // A vous de jouer
        ctrlClient = new CtrlClient();
        ctrlCommande = new CtrlCommande();
        ctrlLigneCommande = new CtrlLigneCommande();
        ctrlLivreur = new CtrlLivreur();
        ctrlPizza = new CtrlPizza();
        //for (String client : ctrlClient.getAllClients)
            //cboClients.addItem();
        btnCommander.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // A vous de jouer


            }
        });
    }
}
