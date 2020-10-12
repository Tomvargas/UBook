package model;

//@author TOMAS VARGAS

interface metodos{
    public String Tostr();
    public String bio();
    public String aut_name();
}
public abstract class autor implements metodos {
    //ATRIBUTES
    private String aut_nom;
    private String aut_contact;
    private String aut_bio;
    
    //CONSTRUCTOR
    public autor(String aut_nom, String aut_contact, String aut_bio){
        this.aut_nom=aut_nom;
        this.aut_contact=aut_contact;
        this.aut_bio=aut_bio;  
    }
    
    //GETTERS AND SETTERS
    public String getAut_nom() {return aut_nom;}
    public void setAut_nom(String aut_nom) {this.aut_nom = aut_nom;}

    public String getAut_contact() {return aut_contact;}
    public void setAut_contact(String aut_contact) {this.aut_contact = aut_contact;}

    public String getAut_bio() {return aut_bio;}
    public void setAut_bio(String aut_bio) {this.aut_bio = aut_bio;}
    
    //METHOD 
    @Override
    public String Tostr(){
        String s="\nAutor: "+aut_nom+"\nContacto: "+aut_contact;
        return s;
    }
    @Override
    public String bio(){
        return "\n"+aut_bio+"\n";
    }
    @Override
    public String aut_name(){
        return aut_nom; 
    }

}
