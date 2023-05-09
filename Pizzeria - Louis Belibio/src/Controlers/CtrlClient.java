package Controlers;

import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlClient
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlClient() {
        cnx = ConnexionBDD.getCnx();
    }

    public ArrayList<String> getAllClients()
    {
        ArrayList<String> lesClients = new ArrayList<>();

        // A vous de jouer
        try{
            ps=cnx.prepareStatement("SELECT nomCli FROM client");
            rs = ps.executeQuery();
            while (rs.next()) {
                String client = rs.getString("nomCli");
                lesClients.add(client);
            }
            ps.close();
            rs.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(CtrlClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return lesClients;
    }
    public int getIdClientByName(String nomCli)
    {
        int numCli = 0;

        // A vous de jouer
        try {
            ps=cnx.prepareStatement("SELECT numCli FROM clients WHERE nomCli LIKE ?");
            ps.setString(1, nomCli);
            rs = ps.executeQuery();
            numCli=rs.getInt("numCli");
        }
        catch (SQLException ex) {
            Logger.getLogger(CtrlClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return numCli;
    }
}
