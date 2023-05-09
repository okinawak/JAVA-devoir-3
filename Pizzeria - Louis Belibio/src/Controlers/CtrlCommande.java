package Controlers;

import Tools.ConnexionBDD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CtrlCommande
{
    private Connection cnx;
    private PreparedStatement ps;
    private ResultSet rs;

    public CtrlCommande() {
        cnx = ConnexionBDD.getCnx();
    }

    public int getDernierNumeroDeCommande()
    {
        int maxNumero = 0;

        // A vous de jouer
        try{
            ps=cnx.prepareStatement("SELECT Max(numCde) FROM `commandes`");
            rs = ps.executeQuery();
            maxNumero= rs.getInt("numCde");
            ps.close();
            rs.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(CtrlClient.class.getName()).log(Level.SEVERE, null, ex);
        }
        return maxNumero;
    }
    public void InsertConsultation(int numCde, int numClient,int numLivreur)
    {
        // A vous de jouer
        try{
            numCde=getDernierNumeroDeCommande();
            ps=cnx.prepareStatement("INSERT INTO `commandes` (`numCde`, `numCli`, `numLiv`) VALUES (?, ?, ?)");
            rs = ps.executeQuery();
            ps.setInt(1, numCde);
            ps.setInt(2, numClient);
            ps.setInt(3, numLivreur);
            ps.close();
            rs.close();
        }
        catch (SQLException ex) {
            Logger.getLogger(CtrlClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
