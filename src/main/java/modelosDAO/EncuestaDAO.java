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
public class EncuestaDAO {
    private cn CN;
    private Connection con;
    private PreparedStatement ps;
    private ResultSet rs;
    
    public EncuestaDAO() throws ClassNotFoundException{
    CN = new cn();
    }
    
    //consulta general
    public List listar(){
        ArrayList<encuesta> lista = new ArrayList<>();
        String sql="SELECT * FROM respuestas";

        try {
            con=CN.getCon();
            ps=con.prepareStatement (sql);
            rs=ps.executeQuery();

            while(rs.next()){
                encuesta encuestal =new encuesta();
                encuestal.setNombre(rs.getString("nombre"));
                encuestal.setSexo(rs.getString("sexo"));
                encuestal.setDeporte(rs.getString("deporte"));
                encuestal.setEstudio(rs.getString("estudio"));
                encuestal.setTema(rs.getString("temas"));
                lista.add(encuestal);
            }
            
        }catch (Exception e){}
        return lista;
    }
    
    //agregar una encuesta
    public boolean agregar (encuesta encuesta){
        String sql="insert into respuestas(nombre,sexo,deporte,estudio,temas) values(?,?,?,?,?)";

        try{
            con = CN.getCon();
            ps = con.prepareStatement(sql);
            ps.setString (1 ,encuesta.getNombre());
            ps.setString (2,encuesta.getSexo());
            ps.setString (3 ,encuesta.getDeporte());
            ps.setString (4,encuesta.getEstudio());
            ps.setString (5,encuesta.getTema());
            int filasAfectadas = ps.executeUpdate();
            return filasAfectadas>0;
            
        }catch (Exception e){
            return false;
        }finally{ }  
    }
    
    //consulta 
    public List grafico(){
        ArrayList<encuesta> lista1 = new ArrayList<>();
        String sql="SELECT sexo as tipo, COUNT(*) AS cantidad FROM respuestas GROUP BY sexo ";

        try {
            con=CN.getCon();
            ps=con.prepareStatement (sql);
            rs=ps.executeQuery();

            while(rs.next()){
                encuesta encuestal = new encuesta();
                encuestal.setTipo(rs.getString("tipo"));
                encuestal.setCantidad(rs.getInt("cantidad"));
                lista1.add(encuestal);
            }
        }catch (Exception e){}
        return lista1;
    }
}
