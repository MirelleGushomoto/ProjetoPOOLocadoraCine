
package db;

import java.sql.Date;
import java.util.ArrayList;


public class Locacao {
      
    private long id;
    private Date aluguel;
    private Date devolucao;
    
    public Locacao(long id, Date aluguel, Date devolucao) {
        this.id = id;
        this.aluguel = aluguel;
        this.devolucao = devolucao;
    }
 public static Usuarios getUsuarios(String login, String senha)
            throws Exception{
        
        String SQL = "SELECT * FROM USUARIOS "
                + "WHERE usuario_login = ? AND usuario_passwordhash = ?";
        Object parameters[] = {login, senha.hashCode()};
        ArrayList<Object[]> list = Conexao.getQuery(SQL, parameters);
        if(list.isEmpty()){
            return null;
        }
        else{
            Object row[] = list.get(0);
            Usuarios x = new Usuarios(
                    (long) row[0],
                    (String) row[1],
                    (String) row[2],
                    (String) row[3],
                    (long) row[4],
                    (long) row[5]
            );
            return x;
        }
        
    }
  public static ArrayList<Locacao> getLocacao()
            throws Exception{
        
        String SQL = "SELECT * FROM LOCACOES";
        ArrayList<Locacao> locacaocliente = new ArrayList<>();
        ArrayList<Object[]> list = Conexao.getQuery(SQL, new Object[]{});
       for(int i=0; i<list.size(); i++){
            Object row[] = list.get(i);
            Locacao l = new Locacao(
                    (long) row[0],
                    (Date) row[1],
                    (Date) row[2]);
                    locacaocliente.add(l);
                    
        }
        return locacaocliente;
        
    }
   public static void AddLocacao(Date aluguel, Date devolucao) throws Exception{
    
    String SQL = "INSERT INTO LOCACOES VALUES("
            + "default"
            + ", ?"
            + ", ?"
            + ")";
            
          
    
    Object parameters[] = {aluguel, devolucao};
    Conexao.execute(SQL, parameters);
            
}
    
    public static void ExcluirAlguel(long id) throws Exception{
    
    String SQL = "DELETE FROM LOCACOES WHERE LOCACAO_ID = ?";       
    Object parameters[] = {id};
    Conexao.execute(SQL, parameters);
    
}
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getAluguel() {
        return aluguel;
    }

    public void setAluguel(Date aluguel) {
        this.aluguel = aluguel;
    }

    public Date getDevolucao() {
        return devolucao;
    }

    public void setDevolucao(Date devolucao) {
        this.devolucao = devolucao;
    }
}
