package model;
import java.util.Date;

//@author TOMAS VARGAS

public final class libro extends autor  {
    //ATRIBUTES
    private String lib_tit;
    private Date lib_fech;
    private String lib_est;
    private String lib_cat;

    public libro(String lib_tit, Date lib_fech, String lib_est, String lib_cat, String aut_nom, String aut_contact, String aut_bio) {
        super(aut_nom, aut_contact, aut_bio);//father class atributes
        this.lib_tit = lib_tit;
        this.lib_fech = lib_fech;
        this.lib_est = lib_est;
        this.lib_cat = lib_cat;
    }
    //GETTERS AND SETTERS
    public String getLib_tit() {return lib_tit;}
    public void setLib_tit(String lib_tit) {this.lib_tit = lib_tit;}

    public Date getLib_fech() {return lib_fech;}
    public void setLib_fech(Date lib_fech) {this.lib_fech = lib_fech;}

    public String getLib_est() {return lib_est;}
    public void setLib_est(String lib_est) {this.lib_est = lib_est;}

    public String getLib_cat() {return lib_cat;}
    public void setLib_cat(String lib_cat) {this.lib_cat = lib_cat;}
    
    //METHOD
    @Override
    public String Tostr(){   
        String s="\nTitulo del libro: "+lib_tit+"\nAutor: "+super.aut_name()+"\nFecha de lanzamiento: "+lib_fech+"\nEstado: "+lib_est+"\nCategoria: "+lib_cat;
        return s;
    }    
}
