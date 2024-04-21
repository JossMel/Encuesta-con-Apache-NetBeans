/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelosDAO;

import db.cn;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import modelos.encuesta;

/**
 *
 * @author JosselynMartinez
 */
public class GraficaDAO {
    private cn CN;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public GraficaDAO() throws ClassNotFoundException{
    CN = new cn();
    }
    
    //consulta 
    public List grafico(){
        ArrayList<encuesta> lista1 = new ArrayList<>();
        String sql="SELECT sexo, COUNT(*) AS cantidad FROM respuestas GROUP BY sexo ";

        try {
            con=CN.getCon();
            ps=con.prepareStatement (sql);
            rs=ps.executeQuery();

            while(rs.next()){
                encuesta encuestal = new encuesta();
                encuestal.setTipo(rs.getString("sexo"));
                encuestal.setCantidad(rs.getInt("cantidad"));
                lista1.add(encuestal);
            }
        }catch (Exception e){}
        return lista1;
    }
}
