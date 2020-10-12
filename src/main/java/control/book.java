package control;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

// @author TOMAS VARGAS

public class book {
    
    //METODO BUSCAR LIBRO
    public ArrayList<String> buscar(){
        //crear instancia para abrir el archivo
        File file=new File("libro.txt");
        //array para los libros
        ArrayList<String> book = new ArrayList<String>();
        String txt;
        try{
            BufferedReader in=new BufferedReader(new FileReader(file));
            
            txt=in.readLine();
            //recorrer los libros del fichero
            while(txt !=null){
                if(txt!="\n")
                    book.add(txt);
                txt=in.readLine();
            }
            //cerrar la instancia d electura de archivo
            in.close();
           
            //buscr libro, si contiene elvalor a buscar
                       
                 
        }catch(IOException e){
            JOptionPane.showMessageDialog(null,"Error con el archivo de registro.");
        }
        //regresar la lista resultante
        return book;
    }
    
    //METODO VALIDACION DE DATOS VACIOS
    public Boolean valid(String tit, Date fech, String autor, String estado){
        boolean x;
        if(!tit.isEmpty() && fech!=null && !autor.isEmpty() && !estado.isEmpty())
            x=true;
        else
            x=false;
        
        return x;
    }
    
    //METODO GUARDAR DATOS
    public void save(String tit, Date fech, String autor, String estado){
        try{
            File file=new File("libro.txt");
            if(!file.createNewFile()){
                //abrir el fichero en modo de sobreescritura si no se ha creado
                PrintWriter out=new PrintWriter(new FileWriter(file,true));
                out.close();
            }
            try{
                //abrir el fichero en modo de sobreescritura
                PrintWriter out=new PrintWriter(new FileWriter(file,true));
                //Da formato a la fecha con el año solamente
                SimpleDateFormat date=new SimpleDateFormat("yyyy");
                String year=date.format(fech);
                //escribir en el fichero
                out.println(tit);
                out.println(year);
                out.println(autor);
                out.println(estado);
                //cerrar el fichero
                out.close();
                JOptionPane.showMessageDialog(null,"Haz guardado: "+tit);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error al Guardar el libro");
                }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error con el archivo de registro.");
        }
    }
    
    //METODO UPDATE PARA REEMPLAZAR VALORES
    public void update(String tit, Date fech, String autor, String estado){
        try{
            //Obtener una lista con los libros y sus datos
            ArrayList<String> libros=buscar();
            File file=new File("libro.txt");
            try{
                //el archivo se abrirá en modo de reescribir
                PrintWriter out=new PrintWriter(new FileWriter(file));
                //formatear la fecha en año
                SimpleDateFormat date=new SimpleDateFormat("yyyy");
                String year=date.format(fech);
                //actualizar datos de la lista con los datos del libro modificado
                if (libros.contains(tit.toLowerCase())){
                    int pos=libros.indexOf(tit.toLowerCase());
                    libros.set(pos,tit.toLowerCase());
                    libros.set(pos+1,year);
                    libros.set(pos+2,autor.toLowerCase());
                    libros.set(pos+3,estado.toLowerCase());
                    //guardando los datos actualizados en el fichero
                    for (int i=0; i<libros.size();i++)
                        out.println(libros.get(i));
                    
                    out.close();
                    JOptionPane.showMessageDialog(null,"Haz Actualizado: "+tit);
                }
                else
                    JOptionPane.showMessageDialog(null,"Este libro no existe, Verifique que el titulo este bien escrito o agrege el libro");
                
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error al Actualizar el libro");
                }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error con el archivo de registro.");
        }
    }
    
    //METODO IMPRIMIR TODOS LOS LIBROS
     public String printall(){
        String t="";
        //Obtener una lista con los libros y sus datos
        ArrayList<String> books=buscar();
        //recorrer la lista asignando todos los libros de manera organizada
        for(int i=0; i<books.size(); i++){
            t+="================================\n";
            t+="Titulo: "+books.get(i)+"\n"; i++;
            t+="Año de publicación: "+books.get(i)+"\n"; i++;
            t+="Autor: "+books.get(i)+"\n"; i++;
            t+="Estado: "+books.get(i)+"\n";
        }
        
        return t;
    }
     
    //METODO ELIMINAR
    public void delete(String titulo){
        try{
            //Obtener una lista con los libros y sus datos
            ArrayList<String> libros=buscar();
            File file=new File("libro.txt");
            try{
                //Si el titulo que se obtuvo del formulario existe en la lista de libros
                if (libros.contains(titulo.toLowerCase())){
                    //el archivo se abrirá en modo de reescribir
                    PrintWriter out=new PrintWriter(new FileWriter(file));
                    //Obtener posicion del libro buscado
                    int pos=libros.indexOf(titulo.toLowerCase());
                    //remover los datos del libro
                    libros.remove(pos);
                    libros.remove(pos);
                    libros.remove(pos);
                    libros.remove(pos);
                    //guardando los datos actualizados en el fichero
                    for (int i=0; i<libros.size();i++)
                        out.println(libros.get(i));
                    out.close();
                    JOptionPane.showMessageDialog(null,"Haz Eliminado: "+titulo);
                }
                else
                    JOptionPane.showMessageDialog(null,"El libro ya no existe");
                
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null,"Error al Eliminar el libro");
                }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,"Error con el archivo de registro.");
        }
    }
    
}
